package test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Socialpom {
	WebDriver driver;

	By face = By.xpath("//div[@id='content']/div[2]/div[2]/div/div/div[2]/div/button");
	By disface = By.xpath("//button[text()='Disconnect Facebook']");
	By email = By.id("email");
	By pass = By.id("pass");
	By submit = By.xpath("//input[@name='login']");
	By confirmface = By.xpath("//button[@name='__CONFIRM__']");
	By faceskip = By.xpath("//button[@name='__SKIP__']");
	By twitter = By.xpath("//div[@class='tw-connect']//button[text()='Connect Twitter']");
	By twitteruser = By.id("username_or_email");
	By twitterpass = By.id("password");
	By subtwitter = By.xpath("//input[@id='allow']");
		
	By printerest = By.xpath("//div[@id='content']/div[2]/div[2]/div/div/div[4]/div/button");
	By printerestuser = By.id("email");
	By printerestpass = By.id("password");
	By subprinterest = By.xpath("//div[text()='Log in']");
	By okprinterest = By.xpath("//div[@id='dialog_footer']//button[contains(text(),'Okay')]");

	public Socialpom(WebDriver driver) {
		this.driver = driver;
	}

	public void typeface() {
		driver.findElement(face).click();
	}

	public void typeemail(String setemail) {
		driver.findElement(email).sendKeys(setemail);

	}

	public void typepass(String setpass) {
		driver.findElement(pass).sendKeys(setpass);

	}

	public void typesubmit() {
		driver.findElement(submit).click();
	}

	public void typedisface() {
		driver.findElement(disface).click();
	}

	public void typeconfirmface() {
		driver.findElement(confirmface).click();
	}

	public void typefaceskip() {
		driver.findElement(faceskip).click();
	}

	public void typetwitteruser(String settwitteruser) {
		driver.findElement(twitteruser).sendKeys(settwitteruser);

	}

	public void typetwitter() {
		driver.findElement(twitter).click();
	}

	public void typetwitterpass(String settwitterpass) {
		driver.findElement(twitterpass).sendKeys(settwitterpass);

	}

	public void typesubtwitter() {
		driver.findElement(subtwitter).click();
	}
	
	public void typeprinterestuser(String setprinterestuser) {
		driver.findElement(printerestuser).sendKeys(setprinterestuser);

	}
	public void typeprinterestpass(String setprinterestpass) {
		driver.findElement(printerestpass).sendKeys(setprinterestpass);

	}

	public void typesubprinterest() {
		driver.findElement(subprinterest).click();
	}
	public void typeokprinterest() {
		driver.findElement(okprinterest).click();
	}
	public void typeprinterest() {
		driver.findElement(printerest).click();
	}
}
