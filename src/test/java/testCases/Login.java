package testCases;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import baseDriverClass.driverInstance;
import pageObjects.LoginPageObjects;
import Utilities.extentReport;

public class Login extends driverInstance{
	
	@Test(priority=1)
	public void testLogin() throws Exception {
		
		
		//test = extent.createTest("testLogin");
		//Create object to Login class
		LoginPageObjects login = new LoginPageObjects(driver);
		
		login.clickOnLoginBtnHomepage();
		Thread.sleep(2000);
		String user_name ="testguvi3@yopmail.com";
		Thread.sleep(1000);
		login.EnterUsername(user_name);
		Thread.sleep(1000);
		login.EnterPassword("Guvi123");
		login.clickOnLogin();
		//Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		String msg = "Welcome "+ user_name;
		assertEquals(login.verifyLogin(),msg);
	}
	@Test(priority=2)
	public void LiginWithInvalidPasswodCredentials() throws Exception {
		
		
		
		//test = extent.createTest("LiginWithInvalidPasswodCredentials");
		//Create object to Login class
		LoginPageObjects login = new LoginPageObjects(driver);
		
		login.clickOnLoginBtnHomepage();
		login.EnterUsername("testguvi3@yopmail.com");
		login.EnterPassword(" ");
		login.clickOnLogin();
		Thread.sleep(2000);
		
		Alert al= driver.switchTo().alert();
		assertEquals(al.getText(),"Wrong password.");
		al.accept();
	}
	
	@Test(priority=3)
	public void LiginWithoutPasswodCredentials() throws Exception {
		
		//test = extent.createTest("LiginWithoutPasswodCredentials");
		//Create object to Login class
		LoginPageObjects login = new LoginPageObjects(driver);
		
		login.clickOnLoginBtnHomepage();
		login.EnterUsername("testguvi3@yopmail.com");
		login.EnterPassword("");
		login.clickOnLogin();
		Thread.sleep(2000);
		
		Alert al= driver.switchTo().alert();
		assertEquals(al.getText(),"Please fill out Username and Password.");
		al.accept();
	}

}

