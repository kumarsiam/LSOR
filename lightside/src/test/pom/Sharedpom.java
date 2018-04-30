//div[@id='InnerCircle_bete_custom_css4706']//img[1]
package test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sharedpom {
	WebDriver driver;
	By image = By.xpath("//div[@id='InnerCircle_bete_custom_css4706']//img[1]");

	By imagedel = By.xpath("//div[@id='InnerCircle_bete_custom_css4706']//img[2]");

	public Sharedpom(WebDriver driver) {
		this.driver = driver;
	}

	public void typeimage() {
		driver.findElement(image).click();
	}
	public void typeimagedel() {
		driver.findElement(imagedel).click();
	}

}
