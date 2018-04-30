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
import test.utils.Utility;

public class Dashboard {
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

	}

	@Test(priority = 1, description = "Dashboard verification")
	public void verifyDashbo()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(20000);
		Assert.assertEquals(driver.getTitle(), "Dashboard - The Inner Circle");

	}

	@Test(priority = 2, description = "Email Letter Resources button - click and verification")
	public void emailLetter()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(20000);
		WebElement passelement = driver.findElement(By.xpath("//a[@href='/emails-letters']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(passelement).click().perform();
		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getCurrentUrl(), "https://innercircle.lightersideofrealestate.com/emails-letters");
	}

	@Test(priority = 3, description = "Branded Booklet Resources button - click and verification")
	public void BrandedBooklet()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(20000);
		WebElement passelement = driver.findElement(By.xpath("//a[@href='/branded-booklets']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(passelement).click().perform();
		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Boolean b = driver.findElement(By.xpath("//a[text()='learn more']")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 4, description = "Agent Script Resources button - click and verification")
	public void agentScript()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(20000);
		WebElement passelement = driver.findElement(By.xpath("//a[@href='/agent-scripts']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(passelement).click().perform();
		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Boolean b = driver.findElement(By.xpath("//a[@href='#commission']")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 5, description = "Witty post Cards Resources button - click and verification")
	public void wittyPostcards()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 150)");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement elem = driver
				.findElement(By.xpath("//div[div[div[h3[text()='Resources']]]]//a[@href='/witty-postcards']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Boolean b = driver.findElement(By.xpath("//button[@aria-controls='menu']")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 6, description = "Traning Video Resources button - click and verification")
	public void trainingVideo()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement elem = driver.findElement(By.xpath("//a[@href='/training-videos']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Boolean b = driver.findElement(By.xpath("//div[button[text()='Watch Now']]")).isDisplayed();
		System.out.println(b);
	}

	@Test(priority = 7, description = "Inner Circle Deals Resources button - click and verification")
	public void innercircleDeals()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement elem = driver.findElement(By.xpath("//a[@href='/deals']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Boolean b = driver.findElement(By.xpath("//span[span[span[text()='Apparel']]]")).isDisplayed();
		System.out.println(b);
	}

	@Test(priority = 8, description = "Tips and Help - FC Facebook Group button -click and verification")
	public void fcFacebookGroup()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement elem = driver.findElement(By.partialLinkText(" IC Facebook Group"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
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

	@Test(priority = 9, description = "Tips and Help - Help Center button - click and verification")
	public void helpCenter()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement elem = driver.findElement(By.partialLinkText(" Help Center"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Boolean b = driver.findElement(By.linkText("General FAQ")).isDisplayed();
		System.out.println(b);
	}
	// poster click or image click

	@Test(priority = 10, description = "All Article button click and verification")
	public void allArticle()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(20000);
		WebElement privacyof = driver
				.findElement(By.xpath("//div[div[div[h3[text()='Articles']]]]//a[@href='/share-article']"));
		scrollIntoView(privacyof, driver);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[div[div[h3[text()='Articles']]]]//a[@href='/share-article']")));
		// share article
		WebElement passelement = driver
				.findElement(By.xpath("//div[div[div[h3[text()='Articles']]]]//a[@href='/share-article']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(passelement).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/share-article/resourceful']")));
		Boolean b = driver.findElement(By.xpath("//a[@href='/share-article/resourceful']")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 11, description = "All Image Meme button click and verification")
	public void allimageMeme()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(20000);
		WebElement privacyof = driver
				.findElement(By.xpath("//div[div[div[h3[text()='Image Memes']]]]//a[@href='/share-an-image']"));
		scrollIntoView(privacyof, driver);
		// share article
		WebElement passelement = driver
				.findElement(By.xpath("//div[div[div[h3[text()='Image Memes']]]]//a[@href='/share-an-image']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(passelement).click().perform();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(10000);
		Boolean b = driver.findElement(By.xpath("//a[@href='/share-an-image/agent-life']")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 12, description = "All Video Meme button click and verification")
	public void allvideoMeme()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(20000);
		WebElement privacyof = driver
				.findElement(By.xpath("//div[div[div[h3[text()='Video Memes']]]]//a[@href='/share-a-video']"));
		scrollIntoView(privacyof, driver);
		// share article
		WebElement passelement = driver
				.findElement(By.xpath("//div[div[div[h3[text()='Video Memes']]]]//a[@href='/share-a-video']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(passelement).click().perform();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(10000);
		Boolean b = driver.findElement(By.xpath("//li[@data-filter-id='334']")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 13, description = "All Wisty post Cards button click and verification")
	public void allwistypostcards()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(20000);
		WebElement privacyof = driver
				.findElement(By.xpath("//div[div[div[h3[text()='Witty Postcards']]]]//a[@href='/witty-postcards']"));
		scrollIntoView(privacyof, driver);
		// share article
		WebElement passelement = driver
				.findElement(By.xpath("//div[div[div[h3[text()='Witty Postcards']]]]//a[@href='/witty-postcards']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(passelement).click().perform();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(10000);
		Boolean b = driver.findElement(By.xpath("//button[@aria-controls='menu']")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 14, description = "All Facebook Cover click and verification")
	public void allfacebookCover()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(20000);
		WebElement privacyof = driver
				.findElement(By.xpath("//div[div[div[h3[text()='Facebook Covers']]]]//a[@href='/facebook-covers']"));
		scrollIntoView(privacyof, driver);
		// share article
		WebElement passelement = driver
				.findElement(By.xpath("//div[div[div[h3[text()='Facebook Covers']]]]//a[@href='/facebook-covers']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(passelement).click().perform();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(10000);
		Boolean b = driver.findElement(By.xpath("//li[@data-filter-id='336']")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 15, description = "Article image click and verification")
	public void Article() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[div[div[h3[text()='Articles']]]]//img")));
		// share article
		WebElement passelement = driver.findElement(By.xpath("//div[div[div[h3[text()='Articles']]]]//img"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(passelement).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='entry-title']")));
		Boolean b = driver.findElement(By.xpath("//h1[@class='entry-title']")).isDisplayed();
		System.out.println(b);
	}

	@Test(priority = 16, description = "Image Memes - image click and verification")
	public void imageMemes()
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

	@Test(priority = 17, description = "Video Memes - image click and verification")
	public void videoMemes()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(20000);
		WebElement privacyof = driver.findElement(By.xpath("//div[div[div[h3[text()='Video Memes']]]]//img"));
		scrollIntoView(privacyof, driver);
		// share article
		WebElement elem = driver.findElement(By.xpath("//div[div[div[h3[text()='Video Memes']]]]//img"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(10000);
		Boolean b = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/groups/lightersideinnercircle']"))
				.isDisplayed();
		System.out.println(b);
	}

	@Test(priority = 18, description = "Witty Post Cards - image click and verification")
	public void wittypostCards()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(20000);
		WebElement privacyof = driver.findElement(By.xpath("//div[8]/div/div[2]/div/div/div/div/div/div/a/div/img"));
		scrollIntoView(privacyof, driver);
		// share article
		WebElement elem = driver.findElement(By.xpath("//div[8]/div/div[2]/div/div/div/div/div/div/a/div/img"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(10000);
		Boolean b = driver.findElement(By.xpath("//a[@href='/witty-postcards']")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 19, description = "Facebook Covers - image click and verification")
	public void FacebookCovers()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(20000);
		WebElement privacyof = driver.findElement(By.xpath("//div[12]/div/div[2]/div/div/div/div/div/div/a/div/img"));
		scrollIntoView(privacyof, driver);
		// share article
		WebElement elem = driver.findElement(By.xpath("//div[12]/div/div[2]/div/div/div/div/div/div/a/div/img"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(10000);
		Boolean b = driver.findElement(By.className("roboto")).isDisplayed();
		System.out.println(b);

	}

	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor jscroll = (JavascriptExecutor) driver;
		jscroll.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	@AfterMethod
	public void tearDo(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			Utility.captureScreenshot(driver, "Dashboard");

		} else {
			driver.quit();
		}
	}
}
