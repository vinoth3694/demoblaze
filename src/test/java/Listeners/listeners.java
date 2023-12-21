package Listeners;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseDriverClass.driverInstance;
import Utilities.extentReport;
import Utilities.utilities;
public class listeners extends driverInstance implements ITestListener{
	
	WebDriver driver = null;
	ExtentReports report = extentReport.setExtent();
	ExtentTest test;
	
	//method which invoked before each test method execution
	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
	}
	
	//method which invoked before each test method sucessful.
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		//get the name of failed test case
		String testName=result.getName();
		
		utilities util = new utilities();
		//Logic for screenshot capture
		
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalAccessException|IllegalArgumentException|NoSuchFieldException|SecurityException e) {
			e.printStackTrace();
		}
		try {
			String screenshotPath= util.takeScreenshot(testName, driver);//calling method coming utilitu class in utilties
			test.addScreenCaptureFromPath(screenshotPath,testName);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
}

