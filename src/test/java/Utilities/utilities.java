package Utilities;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class utilities {
	
	public String takeScreenshot(String testName, WebDriver driver) throws IOException {
		//capture the screenshot and store it inf file objects
		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//define the path where screenshpt will be saved  
		String screenShotFilepath=System.getProperty("user.dir")+"\\Screenshots\\"+testName+".jpg";
		FileUtils.copyFile(srcScreenshot, new File(screenShotFilepath));
		return screenShotFilepath;

		
	}

}