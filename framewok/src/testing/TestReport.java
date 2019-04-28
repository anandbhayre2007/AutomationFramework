package testing;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestReport {

	public static void main(String[] args) throws IOException 
	{
		ExtentHtmlReporter reporter= new ExtentHtmlReporter("D://AutomationReport.html");
		
		ExtentReports report= new ExtentReports();
		
		report.attachReporter(reporter);
		
		ExtentTest logger= report.createTest("Test CaseObjective");
		
		logger.info("Test case starts");
		logger.pass("Step 1 passed");
		logger.warning("Step 2 faild");
		logger.info("Test case starts");
		logger.addScreenCaptureFromPath("D://Anand.jpg");
		logger.pass("Step 1 passed");
		logger.warning("Step 2 faild");
		logger.info("Test case starts");

		logger.addScreenCaptureFromPath("D://Anand.jpg");
		

		logger.addScreenCaptureFromPath("D://Anand.jpg");
		logger.warning("Step 2 faild");
		
		MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath("D://Anand.jpg").build();
		
		logger.pass("TestPAss", mediaModel);
		
		logger.pass("Step 1 passed");
		logger.warning("Step 2 faild");
		logger.info("Test case starts");
		logger.pass("Step 1 passed");
		
 logger= report.createTest("Test CaseObjective");
		
		logger.info("Test case starts");
		logger.pass("Step 1 passed");
		logger.warning("Step 2 faild");
		logger.info("Test case starts");
		logger.addScreenCaptureFromPath("D://Anand.jpg");
		logger.pass("Step 1 passed");
		logger.warning("Step 2 faild");
		logger.info("Test case starts");

		logger.addScreenCaptureFromPath("D://Anand.jpg");
		

		logger.addScreenCaptureFromPath("D://Anand.jpg");
		logger.warning("Step 2 faild");
		
		mediaModel = MediaEntityBuilder.createScreenCaptureFromPath("D://Anand.jpg").build();
		
		logger.pass("TestPAss", mediaModel);
		
		logger.pass("Step 1 passed");
		logger.warning("Step 2 faild");
		logger.info("Test case starts");
		logger.pass("Step 1 passed");
		
		report.flush();

	}

}
