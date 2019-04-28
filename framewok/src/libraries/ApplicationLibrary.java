package libraries;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;

import baseClass.Driver;
import configFile.config_File;

public class ApplicationLibrary {
	public WebDriver launchBrowser(String Browser) {
		WebDriver dr = null;
		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", config_File.driverpath + "chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--disable-infobars");
			op.addArguments("--start-maximized");			
			dr = new ChromeDriver(op);
			dr.manage().timeouts().implicitlyWait(config_File.implicitwait, TimeUnit.SECONDS);
			dr.get(config_File.url);

		} else if (Browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", config_File.driverpath + "geckodriver.exe");
			
			dr = new FirefoxDriver();
			dr.manage().timeouts().implicitlyWait(config_File.implicitwait, TimeUnit.SECONDS);
			dr.get(config_File.url);

		} else if (Browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", config_File.driverpath + "IEDriverServer.exe");
			InternetExplorerOptions op = new InternetExplorerOptions();
			// op.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,"");
			dr = new InternetExplorerDriver(op);
			dr.manage().timeouts().implicitlyWait(config_File.implicitwait, TimeUnit.SECONDS);
			dr.get(config_File.url);
		} else if (Browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", config_File.driverpath + "MicrosoftWebDriver.exe");
			dr = new EdgeDriver();
			dr.manage().timeouts().implicitlyWait(config_File.implicitwait, TimeUnit.SECONDS);
			dr.get(config_File.url);
		} else if (Browser.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", config_File.driverpath + "operadriver.exe");
			OperaOptions op = new OperaOptions();
			op.setBinary(config_File.operabinary);
			dr = new OperaDriver(op);
			dr.manage().timeouts().implicitlyWait(config_File.implicitwait, TimeUnit.SECONDS);
			dr.get(config_File.url);
		}

		return dr;
	}

	public String captureScreenshot(WebDriver dr) throws IOException {
		String str = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		TakesScreenshot scrShot = ((TakesScreenshot) dr);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String path = config_File.screenShotPath + str + ".jpg";
		File DestFile = new File(path);
		FileUtils.copyFile(SrcFile, DestFile);

		return path;
	}

	public boolean isElementPresent(WebDriver dr, String element_xpath) {
		if (dr.findElements(By.xpath(element_xpath)).size() >= 1) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Author : Anand Bhayre Date : Description: Param: Return:
	 */

	public WebElement login(WebDriver dr, String username, String password) throws IOException {
		WebElement ele = null;
		try {
			dr.findElement(By.xpath(Driver.or.getProperty("username"))).sendKeys(username);
			dr.findElement(By.xpath(Driver.or.getProperty("password"))).sendKeys(password);
			dr.findElement(By.xpath(Driver.or.getProperty("login"))).click();
			if (isElementPresent(dr, Driver.or.getProperty("continue"))) {
				ele = dr.findElement(By.xpath(Driver.or.getProperty("continue")));
			}
		} catch (Exception e) {
			//Driver.logger.log(Status.FAIL, e.getMessage(), captureScreenshot(dr));
		}

		return ele;
	}
}
