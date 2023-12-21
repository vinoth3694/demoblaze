package testCases;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import baseDriverClass.driverInstance;
import pageObjects.signUpObjects;


public class signUp extends driverInstance {
	
	@Test
	public void testSignUp() throws Exception
	{
	
	
	//test = extent.createTest("testSignUp");
	//Create object to signup class
	signUpObjects sign_up = new signUpObjects(driver);
	
	sign_up.clickonSignUpButtonOnHomepage();
	Thread.sleep(2000);
	sign_up.EnterUserName("Test9876129@yopmail.com");
	sign_up.EnterPassword("Guvi123");
	sign_up.ClickOnSignUpToRegister();

	Thread.sleep(6000);
	
	Alert al = driver.switchTo().alert();
	assertEquals(al.getText(),"Sign up successful.");
	al.accept();
	
	Thread.sleep(1000);	
	
}

@Test
public void SignUpWithInvalidCredentials() throws Exception {
	
	
	//test = extent.createTest("SignUpWithInvalidCredentials");
	
	signUpObjects sign_up = new signUpObjects(driver);
	sign_up.clickonSignUpButtonOnHomepage();
	Thread.sleep(2000);
	sign_up.EnterUserName("Testuser575");
	sign_up.EnterPassword("");
	sign_up.ClickOnSignUpToRegister();
	
	Alert al = driver.switchTo().alert();
	assertEquals(al.getText(),"Please fill out Username and Password.");
	al.accept(); 
}

}

