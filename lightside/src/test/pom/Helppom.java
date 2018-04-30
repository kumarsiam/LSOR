package test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Helppom {
	WebDriver driver;
	By helpbuton = By.xpath("//i[@class='vc_btn3-icon fa fa-envelope-o']");
	By sharecontent = By.xpath("//a[span[span[text()='Sharing Content']]]");
	By contentdropdown = By.xpath("//span[text()='Scheduling posts to Facebook']");
	By accountbill = By.xpath("//a[span[span[text()='Account / Billing']]]");
	By accountbilldrop = By.xpath("//span[text()='How do I update my credit card details?']");

	public Helppom(WebDriver driver) {
		this.driver = driver;
	}

	public void typehelpbuton() {
		driver.findElement(helpbuton).click();
	}

	public void typesharecontent() {
		driver.findElement(sharecontent).click();
	}

	public void typecontentdropdown() {
		driver.findElement(contentdropdown).click();
	}

	public void typeaccountbill() {
		driver.findElement(accountbill).click();
	}

	public void typeaccountbilldrop() {
		driver.findElement(accountbilldrop).click();
	}

}