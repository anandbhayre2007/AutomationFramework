package testing;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import configFile.config_File;

public class LearnExtentReport {
	
	

	public static void main(String[] args) throws IOException 
	{
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		ExtentHtmlReporter reporter= new ExtentHtmlReporter("D:\\AutomationReport2_"+timeStamp+".html");
		ExtentReports report= new ExtentReports();
		report.attachReporter(reporter);
		
		ExtentTest logger=report.createTest("TC1","To test login functionality");
		
		System.setProperty("webdriver.chrome.driver", config_File.driverpath + "chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-infobars");
		op.addArguments("--start-maximized");			
		WebDriver dr = new ChromeDriver(op);		
		dr.get("http://www.newtours.demoaut.com/");	
		
		
		//Capture Screenshot
		String str = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		TakesScreenshot scrShot = ((TakesScreenshot) dr);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String path = config_File.screenShotPath + str + ".jpg";
		File DestFile = new File(path);
		FileUtils.copyFile(SrcFile, DestFile);
		
		
		//Launch browser
		boolean rs=true;
		if(rs)
		{
			logger.pass("Browser launched successfully");
			
			List list=dr.findElements(By.xpath("//a[text()='SUPPORT']"));
			if(list.size()>0)
			{
				logger.pass("Support element is present");
				dr.findElement(By.xpath("//a[text()='SUPPORT']")).click();
			}else
			{
				logger.fail("Support element is not present");
			}
			
		}else
		{
			logger.fail("Browser couldn't launched");
			logger.addScreenCaptureFromPath(path);
		}
		
		
		
		
		
		report.flush();
	}

}
