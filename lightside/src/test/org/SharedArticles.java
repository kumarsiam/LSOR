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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.base.Excelread;
import test.pom.Loginpom;
import test.pom.Sharedpom;
import test.utils.Utility;

public class SharedArticles {
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
		Loginpom data = new Loginpom(driver);
		data.typefirstname(Excelread.ExcelData(0, 0));
		data.typepassword(Excelread.ExcelData(1, 0));
		data.typesubmit();
		Thread.sleep(20000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement menuhover1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Account']")));
		menuhover(driver, menuhover1);
		Thread.sleep(1000);
		WebElement belowmove = driver.findElement(By.linkText("Shared Articles"));
		menuClick(driver, belowmove);

	}

	@Test(priority = 1, description = "Verify the Shared Articles page")
	public void verifysocialAccount()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		Boolean b = driver.findElement(By.className("box_header")).isDisplayed();
		System.out.println(b);
	}

	@Test(priority = 2, description = "Verify the click here link")
	public void VerifyClickHere()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[@class='pro_sub_head']//a[text()='(Click here)']")));
		WebElement elem = driver.findElement(By.xpath("//p[@class='pro_sub_head']//a[text()='(Click here)']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		String parent = driver.getWindowHandle();
		// Perform the click operation that opens new window // Switch to new window

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Assert.assertEquals(driver.getTitle(), "What's Your Home Worth In Today's Market?");
		driver.switchTo().window(parent);

	}

	@Test(priority = 3, description = "Verify the delete image function")
	public void ImageClick()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='InnerCircle_bete_custom_css4706']//img[1]")));

		Sharedpom share = new Sharedpom(driver);
		share.typeimage();
		// verification pending
	}

	@Test(priority = 4, description = "VVerify the delete image function - Delete")
	public void ImageDelete()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='InnerCircle_bete_custom_css4706']//img[2]")));

		Sharedpom share = new Sharedpom(driver);
		share.typeimagedel();
		driver.switchTo().alert().accept();

		// verification pending
	}

	@Test(priority = 4, description = "Verify the delete image - cancel function")
	public void ImageDeleteCancel()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='InnerCircle_bete_custom_css4706']//img[2]")));

		Sharedpom share = new Sharedpom(driver);
		share.typeimagedel();
		driver.switchTo().alert().dismiss();
		// verification pending
	}

	public static void menuClick(WebDriver driver, WebElement elementToclick) {
		Actions action2 = new Actions(driver);
		action2.click(elementToclick).perform();
	}

	public static void menuhover(WebDriver driver, WebElement elementTohover) {
		Actions action2 = new Actions(driver);
		action2.moveToElement(elementTohover).build().perform();
	}

	@AfterMethod
	public void tearDo(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			Utility.captureScreenshot(driver, "SocialAccount");

		} else {
			driver.quit();
		}
	}
}