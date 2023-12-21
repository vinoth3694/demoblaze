package baseDriverClass;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utilities.extentReport;

public class driverInstance extends extentReport{
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception
	{
	//
	driver = new ChromeDriver();
		
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	driver.manage().deleteAllCookies();
	
	driver.get("https://www.demoblaze.com/");
	Thread.sleep(2000);
	}
	@AfterMethod
	public void closeBrowser()
	{
		//d.quit();
		driver.close();
	}


}

