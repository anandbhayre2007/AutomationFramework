package testing;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing4 
{
	@Test
	public void learnAssert(){
	   
	   //Creating softAssert object
	   SoftAssert softAssert = new SoftAssert();
	   
	   //Assertion failing
	   softAssert.fail("Failing first assertion");
	   System.out.println("Failing 1");
	   
	   //Assertion failing
	   softAssert.fail("Failing second assertion");
	   System.out.println("Failing 2");

	   //Assertion passing
	   softAssert.assertEquals(1, 1, "Passing third assertion");
	   System.out.println("Passing 3");

	   //Collates the assertion results and marks test as pass or fail
	   softAssert.assertAll();
	}

}
