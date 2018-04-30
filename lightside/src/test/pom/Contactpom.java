package test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Contactpom {
	WebDriver driver;
	By contactuslink = By.partialLinkText(" Contact Us");
	By email = By.name("email-333");
	By fullname = By.name("text-978");
	By message = By.name("textarea-656");
	By sendmessage = By.xpath("//input[@value='Send Message']");

	public Contactpom(WebDriver driver) {
		this.driver = driver;
	}

	public void typecontactuslink() {
		driver.findElement(contactuslink).click();
	}

	public void typeemail(String setemail) {
		driver.findElement(email).sendKeys(setemail);
	}

	public void typefullname(String setfullname) {
		driver.findElement(fullname).sendKeys(setfullname);
	}

	public void typemessage(String setmessage) {
		driver.findElement(message).sendKeys(setmessage);
	}

	public void typesendmessage() {
		driver.findElement(sendmessage).click();
	}
}