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

public class facebook {
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
		Loginpom data = new Loginpom(driver);
		data.typefirstname(Excelread.ExcelData(0, 0));
		data.typepassword(Excelread.ExcelData(1, 0));
		data.typesubmit();
		Thread.sleep(20000);
		WebDriverWait wait = new WebDriverWait(driver, 60);	
	    	WebElement menuhover1 = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Account']")));
		menuhover(driver, menuhover1);
		Thread.sleep(1000);
		WebElement belowmove = driver.findElement(By.linkText("Social Accounts"));
		menuClick(driver, belowmove);

	}
	
	@Test(priority = 1, description = "Verify the Social Account page")
	public void verifyAccountsettings()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("box_header")));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		/*WebElement face = driver.findElement(By.xpath("//button[@style='display:none;'][text()='Disconnect Twitter']"));
		scrollIntoView(face, driver);*/
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tw-connect']//button[text()='Connect Twitter']")));
		//if else condition proper
		//
		Thread.sleep(2000);
		boolean disconnect = driver.findElement(By.xpath("//div[@class='tw-connect']//button[text()='Connect Twitter']")).isEnabled();
		System.out.print(disconnect);
		WebElement disconnecttwitter = driver.findElement(By.xpath("//div[@class='tw-connect']//button[text()='Connect Twitter']"));
		  if(disconnecttwitter.isEnabled())
		  {
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
			Thread.sleep(1000);
			driver.switchTo().window(parent);
		  }
		  else {
				 System.out.println("testing");
				 
			 }
		 
		/*  
		  boolean disconnect = driver.findElement(By.xpath("//button[text()='Connect Twitter']")).isEnabled();
			System.out.print(disconnect);
			
				WebElement disconnectacef = driver.findElement(By.xpath("//button[text()='Connect Twitter']"));
				  if(disconnectacef.isEnabled())
				  {
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
						Thread.sleep(1000);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='__CONFIRM__']")));
						soc.typeconfirmface();
						
						Thread.sleep(4000);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='__SKIP__']")));
						soc.typefaceskip();
						
						driver.switchTo().window(parent);
					
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/div[2]/div[2]/div/div/div[2]/div/button")));
					
				  }
				  else if(connect.isEnabled())
				  {
				   System.out.print("Facebook is connect");
				  }
				 else {
					 System.out.println("testing");
					 
				 }
				  */
		
		
		/*Socialpom soc = new Socialpom(driver);
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
		driver.switchTo().window(parent);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/div[2]/div[2]/div/div/div[2]/div/button")));
	*/
		
		
		//button[text()='Disconnect Facebook']
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
			// driver.quit();
		}
	}
}