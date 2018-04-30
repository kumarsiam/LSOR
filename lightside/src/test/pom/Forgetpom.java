package test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Forgetpom {
	WebDriver driver;
	By forgetlink = By.className("mm-forgot-password");

	By emailadd = By.id("email");

	By recoverymypass = By.name("submit");

	public Forgetpom(WebDriver driver) {
		this.driver = driver;
	}

	public void typeforgetlink() {
		driver.findElement(forgetlink).click();
	}

	public void typeemailadd(String setemailadd) {
		driver.findElement(emailadd).sendKeys(setemailadd);
	}

	public void typename(String setname) {
		driver.findElement(recoverymypass).sendKeys(setname);
	}

	public void typerecoverymypass() {
		driver.findElement(recoverymypass).click();
	}

}
