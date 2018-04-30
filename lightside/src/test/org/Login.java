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
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.base.Excelread;
import test.pom.Contactpom;
import test.pom.Facebookpom;
import test.pom.Forgetpom;
import test.pom.Loginpom;
import test.utils.Utility;

public class Login {
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

	@Test(priority = 3, description="login empty" )
	public void validVerify() {
		Loginpom data = new Loginpom(driver);
		data.typesubmit();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Boolean b = driver.findElement(By.id("log")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 4, description="login negative")
	public void loginnegative()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		Loginpom data = new Loginpom(driver);
		data.typefirstname(Excelread.ExcelData(2, 0));
		data.typepassword(Excelread.ExcelData(3, 0));
		data.typesubmit();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mm-error")));
		Assert.assertEquals(driver.findElement(By.className("mm-error")).getText(), "Invalid username or password");
	}

	@Test(priority = 5, description="openlink")
	public void forget() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		Forgetpom forgetd = new Forgetpom(driver);
		forgetd.typeforgetlink();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Forgot Password - The Inner Circle");

	}

	@Test(priority = 6, description="learn more")
	public void learnmore()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		Loginpom data = new Loginpom(driver);
		data.typelearn();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/div[2]/span")));
		Boolean b = driver.findElement(By.xpath("//div/div/div[2]/span")).isDisplayed();
		System.out.println(b);
	}

	@Test(priority = 7, description="Contact us")
	public void contactus()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(" Contact Us")));
		WebElement contactusli = driver.findElement(By.partialLinkText(" Contact Us"));
		scrollIntoView(contactusli, driver);
		// contact us button click
		Contactpom usdata = new Contactpom(driver);
		usdata.typecontactuslink();
		// contact us page verification
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/helpcenter']")));
		Boolean b = driver.findElement(By.xpath("//a[@href='/helpcenter']")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 8, description="IC Facebook")
	public void icfacebook()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		Facebookpom facedata = new Facebookpom(driver);
		facedata.typefacelink();
		String parent = driver.getWindowHandle();
		// Perform the click operation that opens new window // Switch to new window
		// opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String actual = driver.getTitle();
		String excepted = "Log in to Facebook | Facebook";
		if (actual.equals(excepted)) {
			System.out.println("Success");
		} else {
			String b = driver.getTitle();
			System.out.println(b);
		}
		driver.switchTo().window(parent);
	}

	@Test(priority = 9, description="Privacy")
	public void privacy() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		WebElement privacyof = driver.findElement(By.partialLinkText("Privacy Policy"));
		scrollIntoView(privacyof, driver);
		Loginpom privacydata = new Loginpom(driver);
		privacydata.typeprivacypolicy();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Privacy Policy - The Inner Circle");

	}

	@Test(priority = 10, description="terms of use verification")
	public void terms() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		WebElement termsofuse = driver.findElement(By.partialLinkText("Terms of Use"));
		scrollIntoView(termsofuse, driver);
		Loginpom termsdata = new Loginpom(driver);
		termsdata.typetermsuse();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='1. Introduction.']")));
		Assert.assertEquals(driver.findElement(By.xpath("//h4[text()='1. Introduction.']")).getText(),
				"1. Introduction.");

	}

	@Test(priority = 11, description="lighterside login verification")
	public void lslogobelow()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		WebElement termsofuse = driver.findElement(By.partialLinkText("Terms of Use"));
		scrollIntoView(termsofuse, driver);
		Thread.sleep(4000);
		Loginpom termsdata = new Loginpom(driver);
		termsdata.typelslogo();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='The Inner Circle']")));
		Boolean b = driver.findElement(By.xpath("//img[@alt='The Inner Circle']")).isDisplayed();
		System.out.println(b);
	}

	@Test(priority = 12, description="lighterside login verification")
	public void lslogotop()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		Loginpom termsdata = new Loginpom(driver);
		termsdata.typelslogo();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='The Inner Circle']")));
		Boolean b = driver.findElement(By.xpath("//img[@alt='The Inner Circle']")).isDisplayed();
		System.out.println(b);
	}

	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor jscroll = (JavascriptExecutor) driver;
		jscroll.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	@AfterMethod
	public void tearDo(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			Utility.captureScreenshot(driver, "Login");

		} else {
			driver.quit();
		}
	}
}
