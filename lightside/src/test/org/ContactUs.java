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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.base.Excelread;
import test.pom.Contactpom;
import test.utils.Utility;

public class ContactUs {
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
		Contactpom usdata = new Contactpom(driver);
		usdata.typecontactuslink();

	}

	@Test(priority = 1, description = "Verification for display the contact us page")
	public void termsofuseverify() throws InterruptedException {
		// contact us page verification
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/helpcenter']")));
		Boolean b = driver.findElement(By.xpath("//a[@href='/helpcenter']")).isDisplayed();
		System.out.println(b);
	}

	@Test(priority = 2, description = "Click the 'help center' link. it is displaying the help page")
	public void helpcenterLink() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/helpcenter']")));
		WebElement belowmove = driver.findElement(By.xpath("//a[@href='/helpcenter']"));
		menuClick(driver, belowmove);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Choose a Topic']")));
		Boolean b = driver.findElement(By.xpath("//h3[text()='Choose a Topic']")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 3, description = "click the 'this page' link. it is displaying the error code or oops page ")
	public void thispageLink() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@href='https://innercircle.lightersideofrealestate.com/bug-report']")));
		driver.findElement(By.xpath("//a[@href='https://innercircle.lightersideofrealestate.com/bug-report']")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//strong[text()='You must be logged in to view this page.']")));
		Boolean b = driver.findElement(By.xpath("//strong[text()='You must be logged in to view this page.']"))
				.isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 4, description = "User the fill the valid details. it is displaying successfully message")
	public void formFill()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@href='https://innercircle.lightersideofrealestate.com/bug-report']")));
		WebElement nameform = driver.findElement(By.name("email-333"));
		scrollIntoView(nameform, driver);
		Contactpom usdata = new Contactpom(driver);
		usdata.typeemail(Excelread.ExcelData(0, 4));
		usdata.typefullname(Excelread.ExcelData(1, 4));
		// select - your message about?
		WebElement mySelectElement = driver.findElement(By.name("menu-811"));
		Select dropdown = new Select(mySelectElement);
		dropdown.selectByVisibleText("Inner Circle Deals");
		usdata.typemessage(Excelread.ExcelData(2, 4));
		usdata.typesendmessage();
	}

	@Test(priority = 5, description = "User the fill the invalid details. it is displaying successfully message")
	public void formFill_Invalid()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@href='https://innercircle.lightersideofrealestate.com/bug-report']")));
		WebElement nameform = driver.findElement(By.name("email-333"));
		scrollIntoView(nameform, driver);
		Contactpom usdata = new Contactpom(driver);
		usdata.typeemail(Excelread.ExcelData(3, 4));
		usdata.typefullname(Excelread.ExcelData(1, 4));
		// select - your message about?
		WebElement mySelectElement = driver.findElement(By.name("menu-811"));
		Select dropdown = new Select(mySelectElement);
		dropdown.selectByVisibleText("Inner Circle Deals");
		usdata.typemessage(Excelread.ExcelData(2, 4));
		usdata.typesendmessage();
		// verify for error message
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='The e-mail address entered is invalid.']")));
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[text()='The e-mail address entered is invalid.']")).getText(),
				"The e-mail address entered is invalid.");

	}

	@Test(priority = 6, description = "User the fill the empty details. it is displaying successfully message ")
	public void formFill_empty()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@href='https://innercircle.lightersideofrealestate.com/bug-report']")));
		WebElement nameform = driver.findElement(By.xpath("//input[@value='Send Message']"));
		scrollIntoView(nameform, driver);
		Thread.sleep(2000);
		Contactpom usdata = new Contactpom(driver);
		usdata.typesendmessage();
		// invalid data verify
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='The field is required.']")));
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='The field is required.']")).getText(),
				"The field is required.");
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
			Utility.captureScreenshot(driver, "ContactUS");

		} else {
			driver.quit();
		}
	}
}
