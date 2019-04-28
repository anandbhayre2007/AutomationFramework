package baseClass;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import configFile.config_File;
import libraries.ApplicationLibrary;
import utilities.Xls_Reader;

public class Driver 
{
	public static ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public  ExtentTest logger;
	public static ApplicationLibrary lib;
	public static Xls_Reader xl;
	public static Properties or;
	public  String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	
	
	
	@BeforeSuite
	public void initialize() throws IOException
	{
		//Extent reports
		reporter=new ExtentHtmlReporter(config_File.reportPath+"AutomationReport_"+timeStamp+".html");
		report= new ExtentReports();
		report.attachReporter(reporter);
		
		//Object repository
		or= new Properties();		
		FileInputStream file= new FileInputStream(config_File.or);		
		or.load(file);
		
		//Excel reader utility
		xl= new Xls_Reader(config_File.testdata);
		
		//Application Library
		lib=new ApplicationLibrary();
	}
	
	@AfterSuite
	public void teardown() throws IOException
	{
		report.flush();
		
		File report = new File(config_File.reportPath+"AutomationReport_"+timeStamp+".html");
		Desktop.getDesktop().browse(report.toURI());
	}

}
