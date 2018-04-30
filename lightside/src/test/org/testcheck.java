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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.base.Excelread;
import test.pom.Loginpom;
import test.utils.Utility;

public class testcheck {
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
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Content']")));
		WebElement menuhover1 = driver.findElement(By.xpath("//span[text()='Content']"));
		menuhover(driver, menuhover1);
		Thread.sleep(1000);
		WebElement belowmove = driver.findElement(By.linkText("Articles"));
		menuClick(driver, belowmove);

	}

	@Test(priority = 1, description = "Verify the Article page")
	public void articleVerify()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Share an Article']")));
		Boolean b = driver.findElement(By.xpath("//h1[text()='Share an Article']")).isDisplayed();
		System.out.println(b);
	}

	@Test(priority = 2, description = "Verify the Article image")
	public void articleImage()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
	
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	Thread.sleep(20000);
	WebElement privacyof = driver.findElement(By.xpath("//div[div[div[h3[text()='Image Memes']]]]//img"));
	scrollIntoView(privacyof, driver);
	// share article
	WebElement elem = driver.findElement(By.xpath("//div[div[div[h3[text()='Image Memes']]]]//img"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	Thread.sleep(10000);
	Boolean b = driver.findElement(By.className("share_via_fb")).isDisplayed();
	System.out.println(b);
	}
	////a[text()='RESOURCEFUL']
	
	@Test(priority = 3, description = "Verify the Article resorce function")
	public void articleResource()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
	
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	Thread.sleep(20000);
	WebElement privacyof = driver.findElement(By.xpath("//a[text()='RESOURCEFUL']"));
	scrollIntoView(privacyof, driver);
	// share article
	WebElement elem = driver.findElement(By.xpath("//a[text()='RESOURCEFUL']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	Thread.sleep(10000);
	Boolean b = driver.findElement(By.xpath("//h1[text()='Resourceful Articles']")).isDisplayed();
	System.out.println(b);
	}
	
	@Test(priority = 4, description = "Verify the Article entertaining function")
	public void articleEntertaining()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
	
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	Thread.sleep(20000);
	WebElement privacyof = driver.findElement(By.xpath("//a[text()='ENTERTAINING']"));
	scrollIntoView(privacyof, driver);
	// share article
	WebElement elem = driver.findElement(By.xpath("//a[text()='ENTERTAINING']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	Thread.sleep(10000);
	Boolean b = driver.findElement(By.xpath("//h1[text()='Entertaining Articles']")).isDisplayed();
	System.out.println(b);
	}
	@Test(priority = 5, description = "Verify the Article market news function")
	public void articleMarketnews()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
	
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	Thread.sleep(20000);
	WebElement privacyof = driver.findElement(By.xpath("//a[text()='MARKET NEWS']"));
	scrollIntoView(privacyof, driver);
	// share article
	WebElement elem = driver.findElement(By.xpath("//a[text()='MARKET NEWS']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	Thread.sleep(10000);
	Boolean b = driver.findElement(By.xpath("//h1[text()='Market News Articles']")).isDisplayed();
	System.out.println(b);
	}
	
	@Test(priority = 6, description = "Verify the Article holiday & special news function")
	public void articleHoliday()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
	
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	Thread.sleep(20000);
	WebElement privacyof = driver.findElement(By.xpath("//a[text()='HOLIDAYS & SPECIAL EVENTS']"));
	scrollIntoView(privacyof, driver);
	// share article
	WebElement elem = driver.findElement(By.xpath("//a[text()='HOLIDAYS & SPECIAL EVENTS']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	Thread.sleep(10000);
	Boolean b = driver.findElement(By.xpath("//h1[text()='Holiday & Special Event Articles']")).isDisplayed();
	System.out.println(b);
	}
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor jscroll = (JavascriptExecutor) driver;
		jscroll.executeScript("arguments[0].scrollIntoView(true);", element);
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
			Utility.captureScreenshot(driver, "ArticleBranding");

		} else {
			driver.quit();
		}
	}
}