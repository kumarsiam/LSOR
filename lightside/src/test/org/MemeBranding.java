package test.org;

import org.testng.annotations.Test;

import test.base.Excelread;
import test.pom.Loginpom;
import test.pom.Memepom;
import test.utils.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class MemeBranding {
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
		WebElement belowmove = driver.findElement(By.linkText("Meme Branding"));
		menuClick(driver, belowmove);

	}

	@Test(priority = 1, description = "Verify the Meme Branding page")
	public void articleVerify()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		Boolean b = driver.findElement(By.className("box_header")).isDisplayed();
		System.out.println(b);
	}

	@Test(priority = 2, description = "Verify the watch this tutorial link function")
	public void shorttutorialVideo()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[@class='pro_sub_head']//a[@class='youtube cboxElement']")));
		WebElement elem = driver.findElement(By.xpath("//p[@class='pro_sub_head']//a[@class='youtube cboxElement']"));
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

	@Test(priority = 3, description = "Verify contact us link function")
	public void contactUs()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[@class='pro_sub_head']//a[text()='contact us']")));
		WebElement elem = driver.findElement(By.xpath("//p[@class='pro_sub_head']//a[text()='contact us']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/helpcenter']")));
		Boolean b = driver.findElement(By.xpath("//a[@href='/helpcenter']")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 4, description = "Verify add image link function")
	public void AddImage()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Image']")));
		WebElement elem = driver.findElement(By.xpath("//span[text()='Add Image']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		Memepom meme = new Memepom(driver);
		meme.typeupload();
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
		Thread.sleep(1000);
		meme.typesave();
	}

	@Test(priority = 5, description = "Verify add text link function")
	public void AddText() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Text']")));
		WebElement elem = driver.findElement(By.xpath("//span[text()='Add Text']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		Memepom meme = new Memepom(driver);
		meme.typeaddbox(Excelread.ExcelData(24, 2));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='fpd-module fpd-active']//span[@data-defaulttext='Add Text']")));
		meme.typeaddtext();

	}

	@Test(priority = 6, description = "Verify add text link function")
	public void AddTextNegative()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Text']")));
		WebElement elem = driver.findElement(By.xpath("//span[text()='Add Text']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Memepom meme = new Memepom(driver);
		meme.typeaddbox(Excelread.ExcelData(24, 2));
		meme.typeaddclose();
	}

	@Test(priority = 7, description = "Verify add logos link function")
	public void AddLogos()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add Logos']")));
		WebElement elem = driver.findElement(By.xpath("//span[text()='Add Logos']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		Memepom meme = new Memepom(driver);
		meme.typelogo1();
		Thread.sleep(1000);
		meme.typelogo2();
		Thread.sleep(1000);
		meme.typesave();
	}

	@Test(priority = 8, description = "Verify manage layers link function")
	public void ManageLayers()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-module='manage-layers']")));
		WebElement elem = driver.findElement(By.xpath("//div[@data-module='manage-layers']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		Memepom meme = new Memepom(driver);
		meme.typemanagelay();
		Thread.sleep(1000);
		meme.typesave();
	}

	@Test(priority = 9, description = "Verify the watch this tutorial link function")
	public void updatewatermarkVideo()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='watermark_settings']//a[@class='youtube cboxElement']")));
		WebElement elem = driver
				.findElement(By.xpath("//div[@class='watermark_settings']//a[@class='youtube cboxElement']"));
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

	@Test(priority = 10, description = "Verify contact us here link function")
	public void contactUsHere()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='watermark_settings']//a[text()='contact us here']")));
		WebElement elem = driver
				.findElement(By.xpath("//div[@class='watermark_settings']//a[text()='contact us here']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/helpcenter']")));
		Boolean b = driver.findElement(By.xpath("//a[@href='/helpcenter']")).isDisplayed();
		System.out.println(b);

	}

	@Test(priority = 11, description = "Verify the upload watermark function")
	public void uploadWaterMark()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement updatecity = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='uploadwtrmrkimg']//p[@class='add_water_mark']")));
		scrollIntoView(updatecity, driver);
		Thread.sleep(2000);
		Memepom meme = new Memepom(driver);
		meme.typeuploadwater();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Robot r = new Robot();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		StringSelection s = new StringSelection("C:\\Users\\user\\eclipse-workspace\\lightside\\Images\\watermark.JPG");
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

	}

	@Test(priority = 12, description = "Verify the FAQ function")
	public void FAQ()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement faq1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#1497317564925-4522904b-5861']")));
		scrollIntoView(faq1, driver);
		Thread.sleep(2000);
		Memepom meme = new Memepom(driver);
		meme.typefaq1();

		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//iframe[@src='https://player.vimeo.com/video/221363859']")));
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='vp-controls']//button[@data-title-play='Play']")));
		WebElement watch = driver.findElement(By.xpath("//div[@class='vp-controls']//button[@data-title-play='Play']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", watch);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", watch);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// pause
		Thread.sleep(4000);
		WebElement watchpause = driver
				.findElement(By.xpath("//div[@class='vp-controls']//button[@data-title-play='Play']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", watchpause);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", watchpause);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	@Test(priority = 13, description = "Verify the FAQ function")
	public void FAQsec()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement faq1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#1497317564945-e3297893-28cb']")));
		scrollIntoView(faq1, driver);
		Thread.sleep(2000);
		Memepom meme = new Memepom(driver);
		meme.typefaq2();

		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//iframe[@src='https://player.vimeo.com/video/221363340']")));
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='vp-controls']//button[@data-title-play='Play']")));
		WebElement watch = driver.findElement(By.xpath("//div[@class='vp-controls']//button[@data-title-play='Play']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", watch);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", watch);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// pause
		Thread.sleep(4000);
		WebElement watchpause = driver
				.findElement(By.xpath("//div[@class='vp-controls']//button[@data-title-play='Play']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", watchpause);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", watchpause);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	@Test(priority = 14, description = "Verify the FAQ function")
	public void FAQthird()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement faq1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#1499816631246-b3356149-733e']")));
		scrollIntoView(faq1, driver);
		Thread.sleep(2000);
		Memepom meme = new Memepom(driver);
		meme.typefaq3();

		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//iframe[@src='https://player.vimeo.com/video/225179343']")));
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='vp-controls']//button[@data-title-play='Play']")));
		WebElement watch = driver.findElement(By.xpath("//div[@class='vp-controls']//button[@data-title-play='Play']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", watch);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", watch);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// pause
		Thread.sleep(4000);
		WebElement watchpause = driver
				.findElement(By.xpath("//div[@class='vp-controls']//button[@data-title-play='Play']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", watchpause);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", watchpause);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	@Test(priority = 15, description = "Verify the FAQ function")
	public void FAQfour()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement faq1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#1499817146330-b33c51d4-d818']")));
		scrollIntoView(faq1, driver);
		Thread.sleep(2000);
		Memepom meme = new Memepom(driver);
		meme.typefaq4();

		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//iframe[@src='https://player.vimeo.com/video/225178902']")));
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='vp-controls']//button[@data-title-play='Play']")));
		WebElement watch = driver.findElement(By.xpath("//div[@class='vp-controls']//button[@data-title-play='Play']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", watch);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", watch);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// pause
		Thread.sleep(4000);
		WebElement watchpause = driver
				.findElement(By.xpath("//div[@class='vp-controls']//button[@data-title-play='Play']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", watchpause);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", watchpause);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	@Test(priority = 16, description = "Verify the FAQ function")
	public void FAQfive()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement faq1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#1497321407351-84bf0769-cfd1']")));
		scrollIntoView(faq1, driver);
		Thread.sleep(2000);
		Memepom meme = new Memepom(driver);
		meme.typefaq5();

		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//iframe[@src='https://player.vimeo.com/video/221366330']")));
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='vp-controls']//button[@data-title-play='Play']")));
		WebElement watch = driver.findElement(By.xpath("//div[@class='vp-controls']//button[@data-title-play='Play']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", watch);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", watch);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// pause
		Thread.sleep(4000);
		WebElement watchpause = driver
				.findElement(By.xpath("//div[@class='vp-controls']//button[@data-title-play='Play']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", watchpause);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", watchpause);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
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
			Utility.captureScreenshot(driver, "MemeBranding");

		} else {
			driver.quit();
		}
	}
}
