package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Testing3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);		
		ChromeOptions op= new ChromeOptions();		
		op.setCapability(ChromeOptions.CAPABILITY, cap );		
		WebDriver dr= new ChromeDriver(op);
		
		

	}

}
