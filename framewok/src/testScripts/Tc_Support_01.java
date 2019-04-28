//TC ID/MTc Link : 
/*
 * Pre Condition :
 * Steps:
 * Expected Results * 
 */
//Autor Details
/*
 * Name :
 * Date : 
 * 
 */

package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClass.Driver;
import libraries.ApplicationLibrary;


public class Tc_Support_01 extends Driver {
	
	WebDriver dr = null;

	@Test
	@Parameters({ "browser" })
	public void script(String browser) {
		logger = report.createTest("To test support link");
		try {

			ApplicationLibrary lib = new ApplicationLibrary();
			dr = lib.launchBrowser(browser);
			if (dr != null) {
				logger.pass("Browser luanched successfully");
				logger.addScreenCaptureFromPath(lib.captureScreenshot(dr));

				//Click on support link
				if(lib.isElementPresent(dr, or.getProperty("support")))
				{
					dr.findElement(By.xpath(or.getProperty("support"))).click();
					logger.pass("Successfully clicked on support link");
					logger.addScreenCaptureFromPath(lib.captureScreenshot(dr));
					
				}else
				{
					logger.fail("supprt link is not present");
					logger.addScreenCaptureFromPath(lib.captureScreenshot(dr));
				}
				
			} else {
				logger.fail("Browser could not be launched. browsername name:" + browser);
			}

		} catch (Exception e) {
			logger.fail("Exception occered :" + e.getMessage());
		} finally {
			if (dr != null) {
				dr.quit();
				logger.pass("Browser closed");
			}
		}

	}
}
