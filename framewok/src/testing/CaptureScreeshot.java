package testing;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import configFile.config_File;

public class CaptureScreeshot {

	public static void main(String[] args) throws IOException
	{
		System.setProperty("webdriver.chrome.driver", config_File.driverpath+"chromedriver.exe");
		ChromeOptions op= new ChromeOptions();
		op.addArguments("--disable-infobars");
		op.addArguments("--start-maximized");
		ChromeDriver dr= new ChromeDriver(op);
		dr.manage().timeouts().implicitlyWait(config_File.implicitwait, TimeUnit.SECONDS);
		dr.get(config_File.url);
		
		
		File SrcFile=dr.getScreenshotAs(OutputType.FILE);
		
		String  path= "D://Anand.jpg";
		File DestFile=new File(path);
		FileUtils.copyFile(SrcFile, DestFile);

	}

}
