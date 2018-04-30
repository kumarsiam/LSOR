package test.org;

import org.testng.annotations.Test;

import test.pom.Contactpom;
import test.pom.Helppom;
import test.utils.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Helpcenter {
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
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(" Contact Us")));
		WebElement contactusli = driver.findElement(By.partialLinkText(" Contact Us"));
		scrollIntoView(contactusli, driver);
		// contact us button click
		Contactpom usdata = new Contactpom(driver);
		usdata.typecontactuslink();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='vc_btn3-icon fa fa-envelope-o']")));
		Helppom helpbu = new Helppom(driver);
		helpbu.typehelpbuton();

	}

	@Test(priority = 1, description = "Help page verification")
	public void Helpverify()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Choose a Topic']")));
		Assert.assertEquals(driver.findElement(By.xpath("//h3[text()='Choose a Topic']")).getText(), "Choose a Topic");
	}

	@Test(priority = 2, description = "Sharing Content button verification and drop down details verification")
	public void Sharingcontent()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//ul[@id='advanced-tabs-wrap-9931']//span[text()='Sharing Content']")));
		Thread.sleep(8000);
		WebElement belowmove = driver
				.findElement(By.xpath("//ul[@id='advanced-tabs-wrap-9931']//span[text()='Sharing Content']"));
		menuClick(driver, belowmove);
		Thread.sleep(4000);
		WebElement belowmove1 = driver
				.findElement(By.xpath("//span[text()='How do I update my credit card details?']"));
		menuClick(driver, belowmove1);

		/*
		 * Helppom helpbu = new Helppom(driver);
		 * 
		 * Thread.sleep(2000); helpbu.typesharecontent(); Thread.sleep(2000);
		 * helpbu.typecontentdropdown();
		 */

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Get HTML Function']")));
		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Get HTML Function']")).getText(),
				"Get HTML Function");
	}

	@Test(priority = 3, description = "Account billing button verification and drop down details verification")
	public void Accountbilling()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span[span[text()='Sharing Content']]]")));
		Thread.sleep(8000);
		WebElement belowmove = driver.findElement(By.xpath("//a[span[span[text()='Sharing Content']]]"));
		menuClick(driver, belowmove);
		Thread.sleep(4000);
		WebElement belowmove1 = driver.findElement(By.xpath("//span[text()='Scheduling posts to Facebook']"));
		menuClick(driver, belowmove1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//p[text()='Once you log in, visit your ']//a[@href='/my-account']")));
		Assert.assertEquals(driver
				.findElement(By.xpath("//p[text()='Once you log in, visit your ']//a[@href='/my-account']")).getText(),
				"Account Settings");
	}

	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor jscroll = (JavascriptExecutor) driver;
		jscroll.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void menuClick(WebDriver driver, WebElement elementToclick) {
		Actions action2 = new Actions(driver);
		action2.click(elementToclick).perform();
	}

	@AfterMethod
	public void tearDo(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			Utility.captureScreenshot(driver, "HelpCenter");

		} else {
			driver.quit();
		}
	}
}