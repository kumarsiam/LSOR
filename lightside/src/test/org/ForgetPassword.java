package test.org;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.base.Excelread;
import test.pom.Forgetpom;
import test.utils.Utility;

public class ForgetPassword {
	WebDriver driver;

	@BeforeMethod
	@Parameters({ "browser", "url" })
	public void setUp(String browser, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./jars/chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./jars/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void forgetverify()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		Forgetpom forgetd = new Forgetpom(driver);
		forgetd.typeforgetlink();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Forgot Password - The Inner Circle");
	}

	@Test(priority = 3)
	public void forgetInvalid()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Forgetpom forgetd = new Forgetpom(driver);
		forgetd.typeforgetlink();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		forgetd.typeemailadd(Excelread.ExcelData(1, 3));
		forgetd.typerecoverymypass();

	}

	@Test(priority = 4)
	public void forgetempty()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Forgetpom forgetd = new Forgetpom(driver);
		forgetd.typeforgetlink();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		forgetd.typerecoverymypass();
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
	/*
	 * @Test(priority=5) public void forgetValid() throws InterruptedException,
	 * EncryptedDocumentException, InvalidFormatException, IOException {
	 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); Forgetpom
	 * forgetd = new Forgetpom(driver); forgetd.typeforgetlink();
	 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 * forgetd.typeemailadd(Excelread.ExcelData(0, 2));
	 * forgetd.typerecoverymypass();
	 * 
	 * }
	 */

	@AfterMethod
	public void tearDo(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			Utility.captureScreenshot(driver, "ForgetPassword");

		} else {
			driver.quit();
		}
	}
}
