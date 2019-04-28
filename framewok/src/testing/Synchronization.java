package testing;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Synchronization {
	ChromeDriver dr= new ChromeDriver();
	
	public  void test() throws IOException 
	{
					
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		dr.get("https://www.flipkart.com/");
		dr.findElement(By.xpath("//*[@class='_2AkmmA _29YdH8']")).click();
		
		Actions act= new Actions(dr);		
		act.moveToElement(dr.findElement(By.xpath("//span[text()='Men']"))).build().perform();
		
		WebDriverWait wait= new WebDriverWait(dr, 20);
		wait.until(ExpectedConditions.visibilityOf(dr.findElement(By.xpath("//a[@title='Shirts']"))));
		
		
		File SrcFile=dr.getScreenshotAs(OutputType.FILE);		
		String  path= "D://Anand.jpg";
		File DestFile=new File(path);
		FileUtils.copyFile(SrcFile, DestFile);

		
		
		
	}

	private final String myId = "//*[contains(@name,'%s')]";
	

	private WebElement idSelect(String text) {
	    return dr.findElement(By.xpath(String.format(myId, text)));
	}
	
	@Test
	public void test1()
	{
		dr.get("http://www.newtours.demoaut.com/");
		
		WebElement ele= idSelect("userName");
		
		ele.sendKeys("mercury");
	}
}
