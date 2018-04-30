package test.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Utility {

	public static void captureScreenshot(WebDriver driver, String ScreenshotName) throws IOException {
		EventFiringWebDriver s1=new EventFiringWebDriver(driver);
		File f1 =s1.getScreenshotAs(OutputType.FILE);
		//File f2 = new File("F:\\Screenshots\\"+ScreenshotName+".jpg");
		File f2 = new File("Screenshots/"+ScreenshotName+".jpg");
		FileUtils.copyFile(f1, f2);
	}
}
