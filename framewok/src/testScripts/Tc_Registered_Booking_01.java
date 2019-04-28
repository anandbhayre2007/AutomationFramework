package testScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseClass.Driver;
import libraries.ApplicationLibrary;


public class Tc_Registered_Booking_01 extends Driver {
	
	
	WebDriver dr = null;
	WebDriverWait wait = null;
	
	ApplicationLibrary lib= new ApplicationLibrary();
	
	@BeforeClass
	@Parameters({ "browser" })
	public void navigate(String browser) throws IOException
	{
		logger=report.createTest("Set up - Launch browser");
		dr=lib.launchBrowser(browser);
		if(dr!=null)
		{
			logger.log(Status.PASS, "Browser launched successfully");
			logger.addScreenCaptureFromPath(lib.captureScreenshot(dr));
		}else
		{
			logger.fail("Browser could not be launched");
		}
	}
	
	
	
	
	@Test(dataProvider="getData")
	public void book_flight(String username, String password, String message) throws IOException
	{
		logger= report.createTest("To book a flight for user "+username);
		if(lib.isElementPresent(dr, or.getProperty("username")))
		{
			logger.log(Status.PASS, "Login page displayed successfully");
			logger.addScreenCaptureFromPath(lib.captureScreenshot(dr));
			
			if(lib.login(dr,username, password)!=null)
			{
				logger.log(Status.PASS, "User logged in successfully");
				logger.addScreenCaptureFromPath(lib.captureScreenshot(dr));
				
				//Add reporting 
				dr.findElement(By.xpath(or.getProperty("continue"))).click();
				dr.findElement(By.xpath(or.getProperty("continue2"))).click();
				dr.findElement(By.xpath(or.getProperty("secureFlight"))).click();
				
				String str=dr.findElement(By.xpath(or.getProperty("booked"))).getText();
				
				Assert.assertEquals(message, str);
				logger.log(Status.PASS, "Successfully booked the flight");
				logger.addScreenCaptureFromPath(lib.captureScreenshot(dr));
				
			
			}else
			{
				logger.log(Status.FAIL, "User is not logged in successfully");
				logger.addScreenCaptureFromPath(lib.captureScreenshot(dr));
			}
			
			
		
		logout();
		}else
		{
			System.out.println("Terminate the execution");
		}
	}
	
	public void logout() throws IOException
	{
		dr.findElement(By.xpath(or.getProperty("signoff"))).click();
		logger.log(Status.PASS, "Logged out successfully");
		logger.addScreenCaptureFromPath(lib.captureScreenshot(dr));
		
		
	}

	@AfterClass
	public void closeBrowser()
	{
		dr.quit();
	}
	

	@DataProvider
	public Object[][] getData() throws IOException {

		int rows = xl.getrowcount("Data");
		int cols = xl.getColumncount("Data");

		System.out.println("rows="+rows+" cols="+cols);
		Object[][] data = new Object[rows - 1][cols];

		for (int r = 2; r <= rows; r++) {
			for (int c = 1; c <= cols; c++) {
				data[r - 2][c-1] = xl.getCellData("Data", r, c );
			}

		}

		return data;

	}

}
