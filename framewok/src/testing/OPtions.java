package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OPtions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", config_File.driverpath+"chromedriver.exe");
		ChromeOptions op= new ChromeOptions();
		op.addArguments("--disable-infobars");
		op.addArguments("--start-maximized");
		WebDriver dr= new ChromeDriver(op);

	}

}
