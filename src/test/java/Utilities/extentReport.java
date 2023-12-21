package Utilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//ExtentHtmlReporter is removed from version 5 of avenstack replaced by ExtentSparkReporter

public class extentReport {
	
	
	public static ExtentReports setExtent() {
		
		ExtentSparkReporter Reporter;
		ExtentReports extent;
		Reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\test-output\\old\\myReport.html");
		
		Reporter.config().setDocumentTitle("DemoBlaze Automation Report");//Title of Report
		Reporter.config().setReportName("LoginSignUpReport");
		
		Reporter.config().setTheme(Theme.STANDARD); //Set the theme
		
		extent = new ExtentReports(); // Instance of ExtentReports
		
		extent.attachReporter(Reporter); //attach HTML report to extent
		
		return extent;
		
	}
	
	
	
}