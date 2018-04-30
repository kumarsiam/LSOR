package test.org;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.base.Excelread;
import test.pom.Loginpom;

public class Framework_test {
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

	@Test(priority = 1, description = "Dashboard")
	public void verifyLogin() throws InterruptedException {
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		Boolean b = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("log"))).isDisplayed();
		System.out.println(b);

	}
	@Test(priority = 2, description="login positive")
	public void loginpositive()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Loginpom data = new Loginpom(driver);
		data.typefirstname(Excelread.ExcelData(0, 0));
		data.typepassword(Excelread.ExcelData(1, 0));
		data.typesubmit();
		// logout
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//ul[@id='primary-menu']//a[text()='Log out']")));
		data.typelogout();
		Boolean b = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("log"))).isDisplayed();
		System.out.println(b);

	}
  public static void scrollIntoView(WebElement element, WebDriver driver) {
	  JavascriptExecutor jscroll=(JavascriptExecutor)driver;
	  jscroll.executeScript("arguments[0].scrollIntoView(true);",element);
  }


  
}
