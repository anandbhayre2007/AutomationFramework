package testing;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Anand {

	public static void main(String[] args) 
	{
		
		//Step 1
		ExtentHtmlReporter reporter= new ExtentHtmlReporter("D:\\02092018\\Framework\\src\\reports\\Automation.html");
		
		//Step 2
		ExtentReports report=new ExtentReports();
		
		//Step 3
		report.attachReporter(reporter);
		
		//Step 4
		ExtentTest logger=report.createTest("To test xyz functionality");
		
		//TC step 1
		logger.pass("step 1 passed");
		logger.fail("Step 2 failed");
		logger.info("Executing step 3");
		logger.pass("Step 3 passed");
		
		//
		report.flush();
	}

}
