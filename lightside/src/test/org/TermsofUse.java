package test.org;

import org.testng.annotations.Test;

import test.pom.Loginpom;
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

public class TermsofUse {
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

	@Test(description = "high light the border colour and verification of the term of use page ")
	public void termsofuseverify() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Terms of Use")));
		// terms of use link find
		WebElement termsofuse = driver.findElement(By.partialLinkText("Terms of Use"));
		scrollIntoView(termsofuse, driver);
		// terms of use link click
		Loginpom termsdata = new Loginpom(driver);
		termsdata.typetermsuse();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='1. Introduction.']")));
		// terms of use page verification
		Assert.assertEquals(driver.findElement(By.xpath("//h4[text()='1. Introduction.']")).getText(),
				"1. Introduction.");

		WebElement termsofuse27 = driver
				.findElement(By.xpath("//h4[text()='27. Section Headings, Fonts, and Styles.']"));
		scrollIntoView(termsofuse27, driver);

		WebElement termsofuse5 = driver.findElement(By.xpath(
				"//b[text()='IF YOU DO NOT MEET ALL OF THE ELIGIBILITY REQUIREMENTS HEREIN, YOU SHALL NOT ACCESS OR USE THE SERVICE.']"));
		scrollIntoView(termsofuse5, driver);

		WebElement ele = driver.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/div/div/div/div/p[6]/b"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
		Thread.sleep(2000);

		WebElement termso = driver
				.findElement(By.xpath("//a[@href='https://innercircle.lightersideofrealestate.com']"));
		scrollIntoView(termso, driver);
		String getT = driver.findElement(By.xpath("//a[@href='https://innercircle.lightersideofrealestate.com']"))
				.getText();
		System.out.println(getT);

		WebElement termsofacc = driver.findElement(By.linkText("My Account"));
		scrollIntoView(termsofacc, driver);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Account")));

		Thread.sleep(2000);
		WebElement menu = driver.findElement(By.xpath("//span[text()='My Account']"));
		WebElement belowmove = driver.findElement(By.linkText("Account Settings"));
		// span[text()='Article Branding']
		menuClick(driver, menu);
		Thread.sleep(2000);
		menuClick(driver, belowmove);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='The Inner Circle']")));
		Boolean b = driver.findElement(By.xpath("//img[@alt='The Inner Circle']")).isDisplayed();
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

	@AfterMethod
	public void tearDo(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			Utility.captureScreenshot(driver, "TermsofUse");

		} else {
			driver.quit();
		}
	}
}
