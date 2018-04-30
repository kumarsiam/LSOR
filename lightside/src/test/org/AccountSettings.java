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
import test.pom.Accountpom;
import test.pom.Loginpom;
import test.utils.Utility;

public class AccountSettings {
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
		WebElement belowmove = driver.findElement(By.linkText("Account Settings"));
		menuClick(driver, belowmove);

	}

	@Test(priority = 1, description = "Verify the Meme Branding page")
	public void verifyAccountsettings()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		Boolean b = driver.findElement(By.className("box_header")).isDisplayed();
		System.out.println(b);
	}

	@Test(priority = 2, description = "Verify the Meme Branding page")
	public void VerifyContactus()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[@class='pro_sub_head']//a[text()='Contact us here']")));
		WebElement elem = driver.findElement(By.xpath("//p[@class='pro_sub_head']//a[text()='Contact us here']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/helpcenter']")));
		Boolean b = driver.findElement(By.xpath("//a[@href='/helpcenter']")).isDisplayed();
		System.out.println(b);
	}

	@Test(priority = 3, description = "Verify the Meme Branding page")
	public void enterMemebership()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		Accountpom acc = new Accountpom(driver);
		acc.typefirstnamecr();
		acc.typefirstname(Excelread.ExcelData(2, 2));
		acc.typelastnamecr();
		acc.typelastname(Excelread.ExcelData(3, 2));
		acc.typeusernamecr();
		acc.typeusername(Excelread.ExcelData(4, 2));
		acc.typesubmit();

	}

	@Test(priority = 4, description = "Verify the Meme Branding page")
	public void enterMemebershipEmpty()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		Accountpom acc = new Accountpom(driver);
		acc.typefirstnamecr();
		acc.typelastnamecr();
		acc.typeusernamecr();
		acc.typesubmit();

	}

	@Test(priority = 5, description = "Verify the Meme Branding page")
	public void changePassword()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		Accountpom acc = new Accountpom(driver);
		acc.typepass(Excelread.ExcelData(5, 2));
		acc.typerepass(Excelread.ExcelData(5, 2));
		acc.typeupdate();

	}

	@Test(priority = 6, description = "Verify the Meme Branding page")
	public void changePasswordNegative()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		WebElement pass = driver.findElement(By.id("accounts_new_password"));
		menuClick(driver, pass);
		Accountpom acc = new Accountpom(driver);
		acc.typepass(Excelread.ExcelData(5, 2));
		acc.typerepass(Excelread.ExcelData(6, 2));
		acc.typeupdate();
		// verification
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

	@Test(priority = 7, description = "Verify the Meme Branding page")
	public void changePasswordEmpty()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		Accountpom acc = new Accountpom(driver);
		acc.typeupdate();
		// verification
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

	@Test(priority = 8, description = "Verify the Meme Branding page")
	public void SubscriptionsCancel()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		WebElement photoup = driver.findElement(By.className("mm-update-subscription-button"));
		scrollIntoView(photoup, driver);
		Accountpom acc = new Accountpom(driver);
		acc.typecancel();
		// verification
		Assert.assertEquals(driver.getTitle(), "Cancel Membership - The Inner Circle");

	}

	@Test(priority = 9, description = "Verify the Meme Branding page")
	public void updateBillingdetails()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		WebElement billing = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("mm-update-subscription-button")));
		menuClick(driver, billing);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mm_field_cc_number")));

		Accountpom acc = new Accountpom(driver);
		// By credit = By.id("mm_field_cc_number");

		acc.typecredit("12345678");

		WebElement selectdate = driver.findElement(By.id("mm_field_cc_exp_month"));
		Select dropdown = new Select(selectdate);
		dropdown.selectByIndex(7);

		WebElement selectyear = driver.findElement(By.id("mm_field_cc_exp_year"));
		Select year = new Select(selectyear);
		year.selectByIndex(7);

		acc.typesecurity("1221");
		acc.typeaddress(Excelread.ExcelData(7, 2));
		acc.typecity(Excelread.ExcelData(8, 2));
		WebElement selectstate = driver.findElement(By.id("mm_field_billing_state_dd"));
		Select state = new Select(selectstate);
		state.selectByIndex(7);
		acc.typepin("1234");
		Thread.sleep(1000);
		// By country = By.id("mm_field_billing_country");
		WebElement belowmove = driver.findElement(By.id("mm_field_billing_country"));
		menuClick(driver, belowmove);
		Thread.sleep(1000);
		WebElement selectcountry = driver.findElement(By.id("mm_field_billing_country"));
		Select country = new Select(selectcountry);
		country.selectByIndex(0);

		acc.typeupdate();
	}

	@Test(priority = 10, description = "Verify the Meme Branding page")
	public void updateBillingCancel()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		WebElement billing = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("mm-update-subscription-button")));
		menuClick(driver, billing);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mm_field_cc_number")));

		Accountpom acc = new Accountpom(driver);

		acc.typecredit("12345678");

		WebElement selectdate = driver.findElement(By.id("mm_field_cc_exp_month"));
		Select dropdown = new Select(selectdate);
		dropdown.selectByIndex(7);

		WebElement selectyear = driver.findElement(By.id("mm_field_cc_exp_year"));
		Select year = new Select(selectyear);
		year.selectByIndex(7);

		acc.typesecurity("1221");
		acc.typeaddress(Excelread.ExcelData(7, 2));
		acc.typecity(Excelread.ExcelData(8, 2));
		WebElement selectstate = driver.findElement(By.id("mm_field_billing_state_dd"));
		Select state = new Select(selectstate);
		state.selectByIndex(7);
		acc.typepin("1234");
		Thread.sleep(1000);
		WebElement belowmove = driver.findElement(By.id("mm_field_billing_country"));
		menuClick(driver, belowmove);
		Thread.sleep(1000);
		WebElement selectcountry = driver.findElement(By.id("mm_field_billing_country"));
		Select country = new Select(selectcountry);
		country.selectByIndex(0);

		acc.typecancel();
	}

	@Test(priority = 11, description = "Verify the Meme Branding page")
	public void updateBillingCancelNega()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		WebElement billing = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("mm-update-subscription-button")));
		menuClick(driver, billing);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mm_field_cc_number")));

		Accountpom acc = new Accountpom(driver);
		acc.typecancel();
	}

	@Test(priority = 13, description = "Verify the Meme Branding page")
	public void OrderhistoryPrintReceipt()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		WebElement photoup = driver.findElement(By.className("mm-update-subscription-button"));
		scrollIntoView(photoup, driver);
		Thread.sleep(1000);
		WebElement icon1 = driver.findElement(By.xpath("//span[@id='5691|114967']/i"));
		scrollIntoView(icon1, driver);
		Accountpom acc = new Accountpom(driver);
		acc.typeicon1();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='pi-close']")));
		Thread.sleep(1000);

		acc.typeprint();
		// verification
	}

	@Test(priority = 14, description = "Verify the Meme Branding page")
	public void OrderHistoryview()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		WebElement photoup = driver.findElement(By.className("mm-update-subscription-button"));
		scrollIntoView(photoup, driver);
		Thread.sleep(1000);
		WebElement icon1 = driver.findElement(By.xpath("//span[@id='5691|114967']/i"));
		scrollIntoView(icon1, driver);
		Accountpom acc = new Accountpom(driver);
		acc.typeicon1();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='pi-close']")));
		Thread.sleep(1000);

		acc.typeclose();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mm-update-subscription-button")));
		Thread.sleep(1000);
		acc.typeicon2();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='pi-close']")));
		Thread.sleep(1000);

		acc.typeclose();
	}

	@Test(priority = 15, description = "Verify the Meme Branding page")
	public void OrderhistoryReBill()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));

		WebElement termsofuse = driver.findElement(By.partialLinkText("Terms of Use"));
		scrollIntoView(termsofuse, driver);
		Thread.sleep(1000);

		Accountpom acc = new Accountpom(driver);

		boolean next = driver.findElement(By.xpath("//a[@title='Next']")).isEnabled();
		System.out.print(next);

		WebElement pagination = driver.findElement(By.xpath("//a[@title='Next']"));

		if (pagination.isEnabled()) {
			acc.typepagination();
		} else {
			System.out.print("It is disable for pagination");
		}

		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Previous']")));

		boolean previous = driver.findElement(By.xpath("//a[@title='Previous']")).isEnabled();
		System.out.print(previous);

		WebElement paginationpre = driver.findElement(By.xpath("//a[@title='Previous']"));

		if (paginationpre.isEnabled()) {
			acc.typepaginationpre();
		} else {
			System.out.print("It is disable for pagination");
		}

		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Last']")));

		boolean last = driver.findElement(By.xpath("//a[@title='Last']")).isEnabled();
		System.out.print(last);

		WebElement paginationlast = driver.findElement(By.xpath("//a[@title='Last']"));

		if (paginationlast.isEnabled()) {
			acc.typepaginationlast();
		} else {
			System.out.print("It is disable for pagination");
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
			Utility.captureScreenshot(driver, "ArticleSettings");

		} else {
			driver.quit();
		}
	}
}
