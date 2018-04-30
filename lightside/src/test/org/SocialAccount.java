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
import test.pom.Socialpom;
import test.utils.Utility;

public class SocialAccount {
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
		WebElement belowmove = driver.findElement(By.linkText("Social Accounts"));
		menuClick(driver, belowmove);

	}

	@Test(priority = 1, description = "Verify the facebook button")
	public void verifysocialAccount()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		Boolean b = driver.findElement(By.className("box_header")).isDisplayed();
		System.out.println(b);
	}

	@Test(priority = 2, description = "Verify the Meme Branding page")
	public void FaceBook()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 40);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(
		 * "box_header")));
		 * 
		 * 
		 * WebElement face = driver.findElement(By.xpath(
		 * "//div[@id='content']/div[2]/div[2]/div/div/div[2]/div/button"));
		 * scrollIntoView(face, driver); Thread.sleep(1000);
		 * 
		 * Socialpom soc = new Socialpom(driver); soc.typeface();
		 * 
		 * String parent = driver.getWindowHandle(); // Perform the click operation that
		 * opens new window // Switch to new window
		 * 
		 * for (String winHandle : driver.getWindowHandles()) {
		 * driver.switchTo().window(winHandle); } Thread.sleep(1000);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		 * driver.findElement(By.id("email")).sendKeys("testing");
		 */

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));

		WebElement face = driver.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/div/div/div[2]/div/button"));
		scrollIntoView(face, driver);

		// if else condition proper

		Thread.sleep(2000);

		boolean disconnect = driver
				.findElement(By.xpath("//button[@style='display:none;'][text()='Disconnect Facebook']")).isEnabled();
		System.out.print(disconnect);

		WebElement disconnectacef = driver
				.findElement(By.xpath("//button[@style='display:none;'][text()='Disconnect Facebook']"));
		WebElement connect = driver
				.findElement(By.xpath("//button[@style='display:none;'][text()='Disconnect Facebook']"));
		if (disconnectacef.isEnabled()) {
			Socialpom soc = new Socialpom(driver);
			soc.typeface();

			String parent = driver.getWindowHandle();
			// Perform the click operation that opens new window // Switch to new window

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

			soc.typeemail(Excelread.ExcelData(9, 2));
			soc.typepass(Excelread.ExcelData(10, 2));
			soc.typesubmit();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='__CONFIRM__']")));
			soc.typeconfirmface();

			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='__SKIP__']")));
			soc.typefaceskip();

			driver.switchTo().window(parent);

			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@id='content']/div[2]/div[2]/div/div/div[2]/div/button")));

		} else if (connect.isEnabled()) {
			System.out.print("Facebook is connect");
		} else {
			System.out.println("testing");

		}

	}
	@Test(priority = 3, description = "Verify the Twitter button")
	public void Twitter()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));

		WebElement twitter = driver.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/div/div/div[3]/div/button"));
		scrollIntoView(twitter, driver);                   

		// if else condition proper

		Thread.sleep(2000);

		boolean disconnect = driver
				.findElement(By.xpath("//button[@style='display:none;'][text()='Connect Twitter']")).isEnabled();
		System.out.print(disconnect);

		WebElement disconnectacef = driver
				.findElement(By.xpath("//button[@style='display:none;'][text()='Connect Twitter']"));
		WebElement connect = driver
				.findElement(By.xpath("//button[@style='display:none;'][text()='Connect Twitter']"));
		if (disconnectacef.isEnabled()) {
			Socialpom soc = new Socialpom(driver);
			soc.typetwitter();

			String parent = driver.getWindowHandle();
			// Perform the click operation that opens new window // Switch to new window

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username_or_email")));

			soc.typetwitteruser(Excelread.ExcelData(9, 2));
			soc.typetwitterpass(Excelread.ExcelData(10, 2));
			soc.typesubtwitter();
			Thread.sleep(6000);	

			driver.switchTo().window(parent);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
			scrollIntoView(twitter, driver); 

			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@id='content']/div[2]/div[2]/div/div/div[3]/div/button")));

		} else if (connect.isEnabled()) {
			System.out.print("twitter is connect");
		} else {
			System.out.println("testing");

		}
		
	}
	
	@Test(priority = 4, description = "Verify the Printerest button")
	public void Printerest()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));

		WebElement printerest = driver.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/div/div/div[4]/div/button"));
		scrollIntoView(printerest, driver);

		// if else condition proper

		Thread.sleep(2000);

		boolean disconnect = driver
				.findElement(By.xpath("//button[@style='display:none;'][text()='Connect Pinterest ']")).isEnabled();
		System.out.print(disconnect);

		WebElement disconnectacef = driver
				.findElement(By.xpath("//button[@style='display:none;'][text()='Connect Pinterest ']"));
		WebElement connect = driver
				.findElement(By.xpath("//button[@style='display:none;'][text()='Connect Pinterest ']"));
		if (disconnectacef.isEnabled()) {
			Socialpom soc = new Socialpom(driver);
			soc.typeprinterest();

			String parent = driver.getWindowHandle();
			// Perform the click operation that opens new window // Switch to new window

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

			soc.typeprinterestuser(Excelread.ExcelData(9, 2));
			soc.typeprinterestpass(Excelread.ExcelData(11, 2));
			soc.typesubprinterest();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dialog_footer']//button[contains(text(),'Okay')]")));
			soc.typeokprinterest();
			Thread.sleep(6000);	

			driver.switchTo().window(parent);
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
            scrollIntoView(printerest, driver);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/div[2]/div[2]/div/div/div[4]/div/button")));

		} else if (connect.isEnabled()) {
			System.out.print("printerest is connect");
		} else {
			System.out.println("testing");

		}
		
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
			Utility.captureScreenshot(driver, "SocialAccount");

		} else {
			driver.quit();
		}
	}
}