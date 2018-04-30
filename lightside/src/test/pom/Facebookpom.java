package test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Facebookpom {
	WebDriver driver;
	By facelink = By.partialLinkText(" IC Facebook Group");

	public Facebookpom(WebDriver driver) {
		this.driver = driver;
	}

	public void typefacelink() {
		driver.findElement(facelink).click();
	}
}