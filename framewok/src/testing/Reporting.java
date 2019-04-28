package testing;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Reporting {

	public static void main(String[] args) throws IOException 
	{
		String str=new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("D://Automation_"+str+".html");
		ExtentReports report= new ExtentReports();
		report.attachReporter(reporter);		
		ExtentTest logger=report.createTest("Testing report");
		
		logger.pass("Step 1");
		logger.fail("Step 2");
		
		
		MediaEntityModelProvider img = MediaEntityBuilder.createScreenCaptureFromPath("D://Anand.jpg").build();
		
		logger.fail("Testing add screenshot", img);
		
		report.flush();
		
	}

}
