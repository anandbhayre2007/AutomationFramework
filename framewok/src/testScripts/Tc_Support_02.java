package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClass.Driver;


public class Tc_Support_02 extends Driver
{
	@Test
	@Parameters({ "browser" })
	public void script(String browser) {
		logger=report.createTest("To test Support link");
		WebDriver dr=null;
		
		try {
		//Step 1: Launch browser
		dr=lib.launchBrowser(browser);
		if(dr!=null)
		{
			logger.pass("Browser is launched successfully");
			logger.addScreenCaptureFromPath(lib.captureScreenshot(dr));
			
			if(lib.isElementPresent(dr, or.getProperty("support")))
			{
				logger.pass("Support element is present");
				dr.findElement(By.xpath(or.getProperty("support"))).click();
				
				if(lib.isElementPresent(dr, or.getProperty("backtohome")))
				{
					logger.pass("BackToHome button is displayed successfully");
					logger.addScreenCaptureFromPath(lib.captureScreenshot(dr));
				}else
				{
					logger.fail("After clicking on support link support page is not displayed");
					logger.addScreenCaptureFromPath(lib.captureScreenshot(dr));
				}
				
			}else {
				logger.fail("Support element is not present");
			}
			
			
		}else
		{
			logger.fail("Browse is not luanched");
		}
		
		//Step 2: Click on Support link
		
		
		//Verify Back To Home button is displayed or not
		}catch(Exception e)
		{
			logger.fail("Exception occuered "+e.getMessage());
		}finally {
			if(dr!=null)
			dr.close();
		}
		
	}

}
