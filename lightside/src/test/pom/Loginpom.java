package test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpom {
	WebDriver driver;
	By username = By.id("log");
	By password = By.id("pwd");
	By submit = By.name("submit");
	// learn more
	By learn = By.partialLinkText(" Click Here To Learn More");
	// privacy
	By privacypolicy = By.partialLinkText("Privacy Policy");
	// terms
	By termsuse = By.partialLinkText("Terms of Use");
	// logo - check home
	By lslogo = By.xpath("//img[@alt='The Inner Circle']");
	By logout = By.xpath("//ul[@id='primary-menu']//a[text()='Log out']");

	public Loginpom(WebDriver driver) {
		this.driver = driver;
	}

	public void typefirstname(String setusername) {
		driver.findElement(username).sendKeys(setusername);
	}

	public void typepassword(String setpassword) {
		driver.findElement(password).sendKeys(setpassword);
	}

	public void typesubmit() {
		driver.findElement(submit).click();
	}

	public void typelearn() {
		driver.findElement(learn).click();
	}

	public void typeprivacypolicy() {
		driver.findElement(privacypolicy).click();
	}

	public void typetermsuse() {
		driver.findElement(termsuse).click();
	}

	public void typelslogo() {
		driver.findElement(lslogo).click();
	}
	public void typelogout() {
		driver.findElement(logout).click();
	}
	
}
