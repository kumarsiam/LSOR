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

public class PrivacyPolicy {
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Privacy Policy")));

		WebElement privacyof = driver.findElement(By.partialLinkText("Privacy Policy"));
		scrollIntoView(privacyof, driver);

		Loginpom privacydata = new Loginpom(driver);
		privacydata.typeprivacypolicy();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Contacting Us']")));

		WebElement scrollbottom = driver.findElement(By.xpath("//h4[text()='Contacting Us']"));
		scrollIntoView(scrollbottom, driver);

		Thread.sleep(2000);

		WebElement scrolltop = driver.findElement(By.xpath(
				"//h4[text()='What personal information do we collect from the people that visit our blog, website or app?']"));
		scrollIntoView(scrolltop, driver);

		Thread.sleep(2000);
		WebElement privacyhighli = driver.findElement(By.xpath(
				"//p[strong[text()='We do not specifically market to children under the age of 13 years old.']]"));

		scrollIntoView(privacyhighli, driver);

		WebElement ele = driver.findElement(By.xpath(
				"//p[strong[text()='We do not specifically market to children under the age of 13 years old.']]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "Privacy Policy - The Inner Circle");

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
			Utility.captureScreenshot(driver, "PrivacyPolicy");

		} else {
			driver.quit();
		}
	}
}
