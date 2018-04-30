package test.org;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
import test.pom.ArticleBranpom;
import test.pom.Loginpom;
import test.utils.Utility;

public class ArticleBranding {
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Account']")));
		WebElement menuhover1 = driver.findElement(By.xpath("//span[text()='My Account']"));
		menuhover(driver, menuhover1);
		Thread.sleep(1000);
		WebElement belowmove = driver.findElement(By.linkText("Article Branding"));
		menuClick(driver, belowmove);

	}

	@Test(priority = 1, description = "Verify the Article Branding page")
	public void articleVerify()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		Boolean b = driver.findElement(By.className("box_header")).isDisplayed();
		System.out.println(b);
	}

	@Test(priority = 2, description = "Verify submenu for Memes Branding page link ")
	public void memesubMenuLink()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Meme Branding']")));
		WebElement elem = driver.findElement(By.xpath("//a[text()='Meme Branding']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		Boolean b = driver.findElement(By.className("box_header")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 3, description = "Verify submenu for Account Settings page link")
	public void accountSettingsLink()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Account Settings']")));
		WebElement elem = driver.findElement(By.xpath("//a[text()='Account Settings']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		Boolean b = driver.findElement(By.className("box_header")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 4, description = "Verify submenu for Social Account page link")
	public void socialAccountLink()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Social Accounts']")));
		WebElement elem = driver.findElement(By.xpath("//a[text()='Social Accounts']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		Boolean b = driver.findElement(By.className("box_header")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 5, description = "Verify submenu for Shared Article page link")
	public void sharedArticleLink()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Shared Articles']")));
		WebElement elem = driver.findElement(By.xpath("//a[text()='Social Accounts']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		Boolean b = driver.findElement(By.className("box_header")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 6, description = "Verify the short tutorial video link function")
	public void shorttutorialVideo()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[h3[text()='Article Branding']]//a[1]")));
		WebElement elem = driver.findElement(By.xpath("//div[h3[text()='Article Branding']]//a[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.switchTo().defaultContent();
		Thread.sleep(12000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Play']")));
		driver.findElement(By.xpath("//button[@aria-label='Play']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//button[@aria-label='Pause']")).click();

	}

	@Test(priority = 7, description = "Verify contact us link function")
	public void contactUs()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[h3[text()='Article Branding']]//a[2]")));
		WebElement elem = driver.findElement(By.xpath("//div[h3[text()='Article Branding']]//a[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);

	}

	@Test(priority = 8, description = "update your photo - change your image button click and upload")
	public void changeyourImage()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(20000);
		JavascriptExecutor scr = (JavascriptExecutor) driver;
		scr.executeScript("scroll(0,300)");

		Thread.sleep(12000);

		WebElement photoup = driver
				.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/input"));
		scrollIntoView(photoup, driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='content']/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/input")));

		driver.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/input"))
				.click();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='file_input']")));

		WebElement belowmove = driver.findElement(By.xpath("//input[@class='file_input']"));
		menuClick(driver, belowmove);

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		Robot r = new Robot();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		StringSelection s = new StringSelection("C:\\Users\\user\\eclipse-workspace\\lightside\\Images\\photo.JPG");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_ENTER);

		// upload
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("upload_btn")));

		driver.findElement(By.id("upload_btn")).click();
		Thread.sleep(5000);
		// crop
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("crop_btn")));

		driver.findElement(By.id("crop_btn")).click();
	}

	@Test(priority = 9, description = "Verify the update your personal information preview link function")
	public void updatepersonalPreview()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(12000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement previewidntify = driver
				.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement elem = driver.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);

		WebElement photoup = driver.findElement(By.xpath("//div[@class=\"social_new_icons\"]//img"));
		scrollIntoView(photoup, driver);

		Boolean b = driver.findElement(By.xpath("//div[@class=\"social_new_icons\"]//img")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 10, description = "Verify the update your personal information preview link function for content link")
	public void previewContent()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement previewidntify = driver
				.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement elem = driver.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);

		WebElement photoup = driver.findElement(By.xpath("//div[3]/span/p"));
		scrollIntoView(photoup, driver);
		WebElement ele = driver.findElement(By.xpath("//div[3]/span/p"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
		Thread.sleep(2000);

		Boolean b = driver.findElement(By.xpath("//div[3]/span/p")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 11, description = "Verify the all the update details for preview")
	public void previewverifyDetails()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement previewidntify = driver
				.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement elem = driver.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatepers = driver.findElement(By.className("personal_custompro_first_name"));
		scrollIntoView(updatepers, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_first_name")).getText(),
				Excelread.ExcelData(4, 4));

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateperso = driver.findElement(By.className("personal_custompro_last_name"));
		scrollIntoView(updateperso, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_last_name")).getText(),
				Excelread.ExcelData(5, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateperson = driver.findElement(By.className("personal_custompro_custom_1"));
		scrollIntoView(updateperson, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_custom_1")).getText(),
				Excelread.ExcelData(6, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateteam = driver.findElement(By.className("personal_custompro_custom_23"));
		scrollIntoView(updateteam, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_custom_23")).getText(),
				Excelread.ExcelData(7, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatejob = driver.findElement(By.className("personal_custompro_custom_2"));
		scrollIntoView(updatejob, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_custom_2")).getText(),
				Excelread.ExcelData(8, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatedes = driver.findElement(By.className("personal_custompro_custom_3"));
		scrollIntoView(updatedes, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_custom_3")).getText(),
				Excelread.ExcelData(9, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatecity = driver.findElement(By.className("city_pre"));
		scrollIntoView(updatecity, driver);
		Assert.assertEquals(driver.findElement(By.className("city_pre")).getText(), Excelread.ExcelData(10, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatestate = driver.findElement(By.className("state_pre"));
		scrollIntoView(updatestate, driver);
		Assert.assertEquals(driver.findElement(By.className("state_pre")).getText(), Excelread.ExcelData(11, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatephon = driver.findElement(By.className("phnum"));
		scrollIntoView(updatephon, driver);
		Assert.assertEquals(driver.findElement(By.className("phnum")).getText(), Excelread.ExcelData(12, 4));

	}

	@Test(priority = 12, description = "Verify the all the update details for Visit Website")
	public void previewverifyWebsite()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement previewidntify = driver
				.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement elem = driver.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatepers = driver.findElement(By.className("personal_custompro_first_name"));
		scrollIntoView(updatepers, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_first_name")).getText(),
				Excelread.ExcelData(4, 4));

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateperso = driver.findElement(By.xpath("//a[text()='Visit Website']"));
		scrollIntoView(updateperso, driver);
		driver.findElement(By.xpath("//a[text()='Visit Website']")).click();

	}

	@Test(priority = 13, description = "Verify the all the update details for get Touch button")
	public void previewverifyGettouch()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement previewidntify = driver
				.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement elem = driver.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatepers = driver.findElement(By.className("personal_custompro_first_name"));
		scrollIntoView(updatepers, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_first_name")).getText(),
				Excelread.ExcelData(4, 4));

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateperso = driver.findElement(By.xpath("//a[text()='Get In Touch']"));
		scrollIntoView(updateperso, driver);
		driver.findElement(By.xpath("//a[text()='Get In Touch']")).click();

	}

	@Test(priority = 14, description = "Verify the all the update details for social icons (facebook)")
	public void previewverifyFacebook()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement previewidntify = driver
				.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement elem = driver.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatepers = driver.findElement(By.className("personal_custompro_first_name"));
		scrollIntoView(updatepers, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_first_name")).getText(),
				Excelread.ExcelData(4, 4));

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateperso = driver.findElement(By.xpath("//div[3]/span/p[1]"));
		scrollIntoView(updateperso, driver);
		driver.findElement(By.xpath("//div[3]/span/p[1]")).click();
		// verification pending

	}

	@Test(priority = 15, description = "Verify the all the update details for social icons (Twitter)")
	public void previewverifyTwitter()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement previewidntify = driver
				.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement elem = driver.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatepers = driver.findElement(By.className("personal_custompro_first_name"));
		scrollIntoView(updatepers, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_first_name")).getText(),
				Excelread.ExcelData(4, 4));

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateperso = driver.findElement(By.xpath("//div[3]/span/p[2]"));
		scrollIntoView(updateperso, driver);
		driver.findElement(By.xpath("//div[3]/span/p[2]")).click();
		// verification pending

	}

	@Test(priority = 16, description = "Verify the all the update details for social icons (Linkedin)")
	public void previewverifyLinkedin()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement previewidntify = driver
				.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement elem = driver.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatepers = driver.findElement(By.className("personal_custompro_first_name"));
		scrollIntoView(updatepers, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_first_name")).getText(),
				Excelread.ExcelData(4, 4));

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateperso = driver.findElement(By.xpath("//div[3]/span/p[3]"));
		scrollIntoView(updateperso, driver);
		driver.findElement(By.xpath("//div[3]/span/p[3]")).click();
		// verification pending

	}

	@Test(priority = 17, description = "Verify the all the update details for social icons (G+)")
	public void previewverifyGPlus()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement previewidntify = driver
				.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your personal information.']//span")));

		WebElement elem = driver.findElement(By.xpath("//h3[text()='Update your personal information.']//span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatepers = driver.findElement(By.className("personal_custompro_first_name"));
		scrollIntoView(updatepers, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_first_name")).getText(),
				Excelread.ExcelData(4, 4));

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateperso = driver.findElement(By.xpath("//div[3]/span/p[4]"));
		scrollIntoView(updateperso, driver);
		driver.findElement(By.xpath("//div[3]/span/p[4]")).click();
		// verification pending

	}

	@Test(priority = 18, description = "Verify the all the update details for box")
	public void verifydetailsbox()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_custompro_first_name")));

		WebElement previewidntify = driver.findElement(By.id("personal_custompro_first_name"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_custompro_first_name")));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		ArticleBranpom box = new ArticleBranpom(driver);
		box.typefirstnamecr();
		box.typefirstname(Excelread.ExcelData(4, 4));
		box.typelastnamecr();
		box.typelastname(Excelread.ExcelData(5, 4));
		box.typecompanynamecr();
		box.typecompanyname(Excelread.ExcelData(6, 4));
		box.typeteamnamecr();
		box.typeteamname(Excelread.ExcelData(7, 4));
		box.typejobtitlecr();
		box.typejobtitle(Excelread.ExcelData(8, 4));
		box.typedesginationcr();
		box.typedesgination(Excelread.ExcelData(9, 4));
		box.typecitycr();
		box.typecity(Excelread.ExcelData(10, 4));
		box.typestatecr();
		box.typestate(Excelread.ExcelData(11, 4));
		box.typephonecr();
		box.typephone(Excelread.ExcelData(12, 4));

		Thread.sleep(2000);
		WebElement previewemail = driver.findElement(By.id("personal_custompro_email"));
		scrollIntoView(previewemail, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_custompro_email")));
		box.typeemailcr();
		box.typeemail(Excelread.ExcelData(13, 4));
		box.typewebsitecr();
		box.typewebsite(Excelread.ExcelData(14, 4));
		Thread.sleep(2000);
		WebElement previecont = driver.findElement(By.id("personal_custompro_custom_9"));
		scrollIntoView(previecont, driver);
		box.typelicencenumbercr();
		box.typelicencenumber(Excelread.ExcelData(15, 4));
		box.typeurlcr();
		box.typeurl(Excelread.ExcelData(16, 4));
		Thread.sleep(2000);
		WebElement faceurl = driver.findElement(By.id("personal_custompro_custom_10"));
		scrollIntoView(faceurl, driver);
		box.typefacecr();
		box.typefaceurl(Excelread.ExcelData(17, 4));
		box.typetwittercr();
		box.typetwitterurl(Excelread.ExcelData(18, 4));
		box.typelinkedincr();
		box.typelinkedinurl(Excelread.ExcelData(19, 4));
		box.typeGpluscr();
		box.typeGplusurl(Excelread.ExcelData(20, 4));
		box.typeprinterestcr();
		box.typeprinteresturl(Excelread.ExcelData(21, 4));
		box.typeinstagramcr();
		box.typeinstagramurl(Excelread.ExcelData(22, 4));
		Thread.sleep(2000);
		WebElement subdet = driver
				.findElement(By.xpath("//div[@class='mm-dialog-button-container']//a[text()='Submit']"));
		scrollIntoView(subdet, driver);
		box.typesubmitbutton();

	}

	@Test(priority = 19, description = "Verify the all the update details for preview")
	public void previewContact()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your contact information.']//span")));

		WebElement previewidntify = driver
				.findElement(By.xpath("//h3[text()='Update your contact information.']//span"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your contact information.']//span")));

		WebElement elem = driver.findElement(By.xpath("//h3[text()='Update your contact information.']//span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatepers = driver.findElement(By.className("personal_custompro_first_name"));
		scrollIntoView(updatepers, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_first_name")).getText(),
				Excelread.ExcelData(4, 4));

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateperso = driver.findElement(By.className("personal_custompro_last_name"));
		scrollIntoView(updateperso, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_last_name")).getText(),
				Excelread.ExcelData(5, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateperson = driver.findElement(By.className("personal_custompro_custom_1"));
		scrollIntoView(updateperson, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_custom_1")).getText(),
				Excelread.ExcelData(6, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateteam = driver.findElement(By.className("personal_custompro_custom_23"));
		scrollIntoView(updateteam, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_custom_23")).getText(),
				Excelread.ExcelData(7, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatejob = driver.findElement(By.className("personal_custompro_custom_2"));
		scrollIntoView(updatejob, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_custom_2")).getText(),
				Excelread.ExcelData(8, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatedes = driver.findElement(By.className("personal_custompro_custom_3"));
		scrollIntoView(updatedes, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_custom_3")).getText(),
				Excelread.ExcelData(9, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatecity = driver.findElement(By.className("city_pre"));
		scrollIntoView(updatecity, driver);
		Assert.assertEquals(driver.findElement(By.className("city_pre")).getText(), Excelread.ExcelData(10, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatestate = driver.findElement(By.className("state_pre"));
		scrollIntoView(updatestate, driver);
		Assert.assertEquals(driver.findElement(By.className("state_pre")).getText(), Excelread.ExcelData(11, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatephon = driver.findElement(By.className("phnum"));
		scrollIntoView(updatephon, driver);
		Assert.assertEquals(driver.findElement(By.className("phnum")).getText(), Excelread.ExcelData(12, 4));

	}

	@Test(priority = 20, description = "Verify the all the professional bio for preview")
	public void previewprofessionalBio()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your professional bio.']//span")));

		WebElement previewidntify = driver.findElement(By.xpath("//h3[text()='Update your professional bio.']//span"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your professional bio.']//span")));

		WebElement elem = driver.findElement(By.xpath("//h3[text()='Update your professional bio.']//span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatepers = driver.findElement(By.className("personal_custompro_first_name"));
		scrollIntoView(updatepers, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_first_name")).getText(),
				Excelread.ExcelData(4, 4));

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateperso = driver.findElement(By.className("personal_custompro_last_name"));
		scrollIntoView(updateperso, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_last_name")).getText(),
				Excelread.ExcelData(5, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateperson = driver.findElement(By.className("personal_custompro_custom_1"));
		scrollIntoView(updateperson, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_custom_1")).getText(),
				Excelread.ExcelData(6, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateteam = driver.findElement(By.className("personal_custompro_custom_23"));
		scrollIntoView(updateteam, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_custom_23")).getText(),
				Excelread.ExcelData(7, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatejob = driver.findElement(By.className("personal_custompro_custom_2"));
		scrollIntoView(updatejob, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_custom_2")).getText(),
				Excelread.ExcelData(8, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatedes = driver.findElement(By.className("personal_custompro_custom_3"));
		scrollIntoView(updatedes, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_custom_3")).getText(),
				Excelread.ExcelData(9, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatecity = driver.findElement(By.className("city_pre"));
		scrollIntoView(updatecity, driver);
		Assert.assertEquals(driver.findElement(By.className("city_pre")).getText(), Excelread.ExcelData(10, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatestate = driver.findElement(By.className("state_pre"));
		scrollIntoView(updatestate, driver);
		Assert.assertEquals(driver.findElement(By.className("state_pre")).getText(), Excelread.ExcelData(11, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatephon = driver.findElement(By.className("phnum"));
		scrollIntoView(updatephon, driver);
		Assert.assertEquals(driver.findElement(By.className("phnum")).getText(), Excelread.ExcelData(12, 4));

	}

	@Test(priority = 21, description = "Verify the all the social links for preview")
	public void previewSocial()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your social links.']//span")));

		WebElement previewidntify = driver.findElement(By.xpath("//h3[text()='Update your social links.']//span"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[text()='Update your social links.']//span")));

		WebElement elem = driver.findElement(By.xpath("//h3[text()='Update your social links.']//span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatepers = driver.findElement(By.className("personal_custompro_first_name"));
		scrollIntoView(updatepers, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_first_name")).getText(),
				Excelread.ExcelData(4, 4));

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateperso = driver.findElement(By.className("personal_custompro_last_name"));
		scrollIntoView(updateperso, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_last_name")).getText(),
				Excelread.ExcelData(5, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateperson = driver.findElement(By.className("personal_custompro_custom_1"));
		scrollIntoView(updateperson, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_custom_1")).getText(),
				Excelread.ExcelData(6, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updateteam = driver.findElement(By.className("personal_custompro_custom_23"));
		scrollIntoView(updateteam, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_custom_23")).getText(),
				Excelread.ExcelData(7, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatejob = driver.findElement(By.className("personal_custompro_custom_2"));
		scrollIntoView(updatejob, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_custom_2")).getText(),
				Excelread.ExcelData(8, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatedes = driver.findElement(By.className("personal_custompro_custom_3"));
		scrollIntoView(updatedes, driver);
		Assert.assertEquals(driver.findElement(By.className("personal_custompro_custom_3")).getText(),
				Excelread.ExcelData(9, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatecity = driver.findElement(By.className("city_pre"));
		scrollIntoView(updatecity, driver);
		Assert.assertEquals(driver.findElement(By.className("city_pre")).getText(), Excelread.ExcelData(10, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatestate = driver.findElement(By.className("state_pre"));
		scrollIntoView(updatestate, driver);
		Assert.assertEquals(driver.findElement(By.className("state_pre")).getText(), Excelread.ExcelData(11, 4));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement updatephon = driver.findElement(By.className("phnum"));
		scrollIntoView(updatephon, driver);
		Assert.assertEquals(driver.findElement(By.className("phnum")).getText(), Excelread.ExcelData(12, 4));
		ArticleBranpom box = new ArticleBranpom(driver);
		box.typeclosepre();

	}

	@Test(priority = 22, description = "Verify the drag and drop for first name")
	public void draganddropFirst()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='memeber_drag_fields']/li/p")));

		WebElement previewidntify = driver.findElement(By.xpath("//ul[@id='memeber_drag_fields']/li/p"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='memeber_drag_fields']/li/p")));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// one
		// Using Action class for drag and drop.
		/*
		 * WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));
		 * WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li")); Actions
		 * act=new Actions(driver); act.dragAndDrop(From, To).build().perform();
		 */

		// two
		WebElement From = driver.findElement(By.xpath("//ul[@id='memeber_drag_fields']/li/p"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(From, 400, 400).perform();

		// three
		/*
		 * WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));
		 * WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li")); Actions
		 * act=new Actions(driver); act.clickAndHold(From).perform();
		 * act.moveToElement(To).perform(); act.release(From).perform();
		 */

	}

	@Test(priority = 23, description = "Verify the drag and drop for company")
	public void draganddropCompany()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='memeber_drag_fields']/li[2]/p")));

		WebElement previewidntify = driver.findElement(By.xpath("//ul[@id='memeber_drag_fields']/li[2]/p"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='memeber_drag_fields']/li[2]/p")));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement From = driver.findElement(By.xpath("//ul[@id='memeber_drag_fields']/li[2]/p"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(From, 300, 300).perform();
	}

	@Test(priority = 24, description = "Verify the drag and drop for company")
	public void draganddropTeam()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='memeber_drag_fields']/li[3]/p")));

		WebElement previewidntify = driver.findElement(By.xpath("//ul[@id='memeber_drag_fields']/li[3]/p"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='memeber_drag_fields']/li[3]/p")));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement From = driver.findElement(By.xpath("//ul[@id='memeber_drag_fields']/li[3]/p"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(From, 200, 200).perform();
	}

	@Test(priority = 25, description = "Verify the drag and drop for company")
	public void draganddropJob()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='memeber_drag_fields']/li[4]/p")));

		WebElement previewidntify = driver.findElement(By.xpath("//ul[@id='memeber_drag_fields']/li[4]/p"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='memeber_drag_fields']/li[4]/p")));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement From = driver.findElement(By.xpath("//ul[@id='memeber_drag_fields']/li[4]/p"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(From, 100, 100).perform();
	}

	@Test(priority = 26, description = "Verify the drag and drop for company")
	public void draganddropDesig()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='memeber_drag_fields']/li[5]/p")));

		WebElement previewidntify = driver.findElement(By.xpath("//ul[@id='memeber_drag_fields']/li[5]/p"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='memeber_drag_fields']/li[5]/p")));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement From = driver.findElement(By.xpath("//ul[@id='memeber_drag_fields']/li[5]/p"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(From, 100, 200).perform();
	}

	@Test(priority = 27, description = "Verify the Lead Generation Tool")
	public void verifyGenTool()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("slider")));

		WebElement previewidntify = driver.findElement(By.className("slider"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("slider")));

		WebElement elem = driver.findElement(By.className("slider"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	@Test(priority = 28, description = "Verify the Blog Home Page for Watch Video")
	public void BlogHomepage()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[@class='direct_url']//a[@class='youtube cboxElement']")));

		WebElement previewidntify = driver
				.findElement(By.xpath("//p[@class='direct_url']//a[@class='youtube cboxElement']"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[@class='direct_url']//a[@class='youtube cboxElement']")));

		WebElement elem = driver.findElement(By.xpath("//p[@class='direct_url']//a[@class='youtube cboxElement']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.className("cboxIframe")));
		Thread.sleep(20000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(@id,'player_uid')]//div[4]/button")));

		WebElement watch = driver.findElement(By.xpath("//*[contains(@id,'player_uid')]//div[4]/button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", watch);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", watch);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// pause
		Thread.sleep(4000);
		WebElement watchpause = driver.findElement(By.xpath("//*[contains(@id,'player_uid')]//div[4]/button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", watchpause);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", watchpause);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	@Test(priority = 29, description = "Verify the Lead Generation Tool to Click Here Video")
	public void leadgentoolClick()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//p[@class='lead_gen_content_class']//a[@class='youtube cboxElement']")));

		WebElement previewidntify = driver
				.findElement(By.xpath("//p[@class='lead_gen_content_class']//a[@class='youtube cboxElement']"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//p[@class='lead_gen_content_class']//a[@class='youtube cboxElement']")));

		WebElement elem = driver
				.findElement(By.xpath("//p[@class='lead_gen_content_class']//a[@class='youtube cboxElement']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.className("cboxIframe")));
		Thread.sleep(20000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(@id,'player_uid')]//div[4]/button")));

		WebElement watch = driver.findElement(By.xpath("//*[contains(@id,'player_uid')]//div[4]/button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", watch);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", watch);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		// pause
		Thread.sleep(4000);
		WebElement watchpause = driver.findElement(By.xpath("//*[contains(@id,'player_uid')]//div[4]/button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", watchpause);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", watchpause);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	@Test(priority = 30, description = "Verify the Lead Generation Tool to URL")
	public void leadgentoolUrl()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[@class='direct_url']//a[text()='https://goo.gl/tLXFQ5']")));

		WebElement previewidntify = driver
				.findElement(By.xpath("//p[@class='direct_url']//a[text()='https://goo.gl/tLXFQ5']"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[@class='direct_url']//a[text()='https://goo.gl/tLXFQ5']")));

		WebElement elem = driver.findElement(By.xpath("//p[@class='direct_url']//a[text()='https://goo.gl/tLXFQ5']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		String parent = driver.getWindowHandle();
		// Perform the click operation that opens new window // Switch to new window
		// opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String actual = driver.getTitle();
		String excepted = "What's Your Home Worth In Today's Market?";
		if (actual.equals(excepted)) {
			System.out.println("Success");
		} else {
			String b = driver.getTitle();
			System.out.println(b);
		}
		driver.switchTo().window(parent);
	}

	@Test(priority = 31, description = "Verify the Lead Generation Tool to URL")
	public void leadgentoolEditMail()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='edit_email email_edit_btn']")));

		WebElement previewidntify = driver.findElement(By.xpath("//span[@class='edit_email email_edit_btn']"));
		scrollIntoView(previewidntify, driver);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='edit_email email_edit_btn']")));

		WebElement elem = driver.findElement(By.xpath("//span[@class='edit_email email_edit_btn']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("save_mail")));
		driver.findElement(By.className("save_mail")).click();
	}

	@Test(priority = 32, description = "Verify the compliance info Box")
	public void complianceinfoBox()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mceu_42")));

		WebElement previewidntify = driver.findElement(By.id("mceu_42"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mceu_42")));

		ArticleBranpom box = new ArticleBranpom(driver);
		box.typecompliance(Excelread.ExcelData(24, 4));

	}

	@Test(priority = 33, description = "Verify the all the update details for box clear the data")
	public void verifydetailsboxNegative()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_custompro_first_name")));

		WebElement previewidntify = driver.findElement(By.id("personal_custompro_first_name"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_custompro_first_name")));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		ArticleBranpom box = new ArticleBranpom(driver);
		box.typefirstnamecr();
		box.typelastnamecr();
		box.typecompanynamecr();
		box.typeteamnamecr();
		box.typejobtitlecr();
		box.typedesginationcr();
		box.typecitycr();
		box.typestatecr();
		box.typephonecr();
		Thread.sleep(2000);
		WebElement previewemail = driver.findElement(By.id("personal_custompro_email"));
		scrollIntoView(previewemail, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_custompro_email")));
		box.typeemailcr();
		box.typewebsitecr();

		Thread.sleep(2000);
		WebElement previecont = driver.findElement(By.id("personal_custompro_custom_9"));
		scrollIntoView(previecont, driver);
		box.typelicencenumbercr();
		box.typeurlcr();
		Thread.sleep(2000);
		WebElement faceurl = driver.findElement(By.id("personal_custompro_custom_10"));
		scrollIntoView(faceurl, driver);
		box.typefacecr();
		box.typetwittercr();
		box.typelinkedincr();
		box.typeGpluscr();
		box.typeprinterestcr();
		box.typeinstagramcr();
		Thread.sleep(2000);
		WebElement subdet = driver
				.findElement(By.xpath("//div[@class='mm-dialog-button-container']//a[text()='Submit']"));
		scrollIntoView(subdet, driver);
		box.typesubmitbutton();

		/*
		 * // verification Thread.sleep(20000);
		 * driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); WebElement
		 * updateperso =
		 * driver.findElement(By.className("personal_custompro_last_name"));
		 * scrollIntoView(updateperso, driver);
		 * Assert.assertEquals(driver.findElement(By.className(
		 * "personal_custompro_last_name")).getText(), Excelread.ExcelData(5, 4));
		 */

	}

	@Test(priority = 33, description = "Verify the all the update details for box clear the data")
	public void chooselogoCheckBox()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_custompro_first_name")));

		WebElement previewidntify = driver.findElement(By.xpath("//label[text()=' Equal Housing']"));
		scrollIntoView(previewidntify, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()=' Equal Housing']")));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		ArticleBranpom box = new ArticleBranpom(driver);
		box.typeequalhouse();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		box.typeRealtor();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		box.typeMLS();
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