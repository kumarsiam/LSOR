package test.org;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
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

import test.utils.Utility;

public class OOPS {
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
		driver.get("https://innercircle.lightersideofrealestate.com/mm-error?code=100031");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	@Test(priority = 1, description="OOPs page verification")
	public void verifyOops() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Boolean b = driver.findElement(By.xpath("//strong[text()='Your account has been locked.']")).isDisplayed();
		System.out.println(b);

	}
	@Test(priority = 2, description="Dashboard")
	public void verifyDashboard() throws InterruptedException {
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
	WebElement belowmove = driver.findElement(By.linkText("Dashboard"));
	menuClick(driver, belowmove);
	WebDriverWait wait = new WebDriverWait(driver, 40);
	Boolean b =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("log"))).isDisplayed();
			System.out.println(b);		
	
	}
	@Test(priority = 3, description="Content")
	public void verifyContent() throws InterruptedException {
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
	WebElement belowmove = driver.findElement(By.linkText("Content"));
	menuClick(driver, belowmove);
	WebDriverWait wait = new WebDriverWait(driver, 40);
	Boolean b =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("log"))).isDisplayed();
			System.out.println(b);		
	
	}
	@Test(priority = 4, description="Resources")
	public void verifyResources() throws InterruptedException {
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
	WebElement belowmove = driver.findElement(By.linkText("Resources"));
	menuClick(driver, belowmove);
	WebDriverWait wait = new WebDriverWait(driver, 40);
	Boolean b =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("log"))).isDisplayed();
			System.out.println(b);		
	
	}
	@Test(priority = 5, description="Verification for Help page")
	public void verifyHelp() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Help']")));
		WebElement menuhover1 = driver.findElement(By.xpath("//span[text()='Help']"));
		menuhover(driver, menuhover1);
		Thread.sleep(1000);
		WebElement belowmove = driver.findElement(By.linkText("Help Center"));
		menuClick(driver, belowmove);
		//verification
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Choose a Topic']")));
		Assert.assertEquals(driver.findElement(By.xpath("//h3[text()='Choose a Topic']")).getText(), "Choose a Topic");
	}
	@Test(priority = 6, description="Verification for Contact us page")
	public void verifyContactus() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Help']")));
		WebElement menuhover1 = driver.findElement(By.xpath("//span[text()='Help']"));
		menuhover(driver, menuhover1);
		Thread.sleep(1000);
		WebElement belowmove = driver.findElement(By.linkText("Contact Us"));
		menuClick(driver, belowmove);
		//verification
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/helpcenter']")));
		Boolean b = driver.findElement(By.xpath("//a[@href='/helpcenter']")).isDisplayed();
		System.out.println(b);
	
	}
	@Test(priority = 7, description="Verification for Account Settings page")
	public void verifyAccountSettings() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement menuhover1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Account']")));
		menuhover(driver, menuhover1);
		Thread.sleep(1000);
		WebElement belowmove = driver.findElement(By.linkText("Account Settings"));
		menuClick(driver, belowmove);
		//verification
		Boolean b =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("log"))).isDisplayed();
				System.out.println(b);
	
	}
	
	
	@Test(priority = 8, description="Login Button Verification")
	public void verifyLogin() throws InterruptedException {
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
	WebElement belowmove = driver.findElement(By.linkText("Log in"));
	menuClick(driver, belowmove);
	WebDriverWait wait = new WebDriverWait(driver, 40);
	Boolean b =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("log"))).isDisplayed();
			System.out.println(b);		
	
	}
	
	public static void menuhover(WebDriver driver, WebElement elementTohover) {
		Actions action2 = new Actions(driver);
		action2.moveToElement(elementTohover).build().perform();
	}
	
	
	public static void menuClick(WebDriver driver, WebElement elementToclick) {
		Actions action2 = new Actions(driver);
		action2.click(elementToclick).perform();
	}
	@AfterMethod
	public void tearDo(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			Utility.captureScreenshot(driver, "Oops");

		} else {
			driver.quit();
		}
	}
	
	
}
