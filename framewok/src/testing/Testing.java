package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import configFile.config_File;

public class Testing {
	
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", config_File.driverpath+"chromedriver.exe");
		ChromeOptions op= new ChromeOptions();
		op.addArguments("--disable-infobars");
		op.addArguments("--start-maximized");
		ChromeDriver dr= new ChromeDriver(op);
		dr.manage().timeouts().implicitlyWait(config_File.implicitwait, TimeUnit.SECONDS);
		dr.get(config_File.url);
		
		dr.findElement(By.name("userName"));
		dr.findElements(By.name("userName"));
	}

}
