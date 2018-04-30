package test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Memepom {
	WebDriver driver;

	By upload = By.className("fpd-icon-file-upload");
	By save = By.xpath("//span[@class='fpd-btn']");
	By addbox = By.xpath("//div[@class='fpd-module fpd-active']//textarea[@data-defaulttext='Enter some text']");
	By addtext = By.xpath("//div[@class='fpd-module fpd-active']//span[@data-defaulttext='Add Text']");
	By addclose = By.xpath("//div[@class='fpd-close-dialog']//span[@class='fpd-icon-close']");
	By logo1 = By.xpath("//div[@id='mCSB_3_container']/div/div/picture");
	By logo2 = By.xpath("//div[@id='mCSB_3_container']/div/div[2]/picture");
	By managelay = By.className("fpd-cell-1");
	By uploadwater = By.xpath("//div[@class='uploadwtrmrkimg']//p[@class='add_water_mark']");
	By faq1 = By.xpath("//a[@href='#1497317564925-4522904b-5861']");
	By faq2 = By.xpath("//a[@href='#1497317564945-e3297893-28cb']");
	By faq3 = By.xpath("//a[@href='#1499816631246-b3356149-733e']");
	By faq4 = By.xpath("//a[@href='#1499817146330-b33c51d4-d818']");
	By faq5 = By.xpath("//a[@href='#1497321407351-84bf0769-cfd1']");

	public Memepom(WebDriver driver) {
		this.driver = driver;
	}

	public void typeupload() {
		driver.findElement(upload).click();
	}

	public void typesave() {
		driver.findElement(save).click();
	}

	public void typeaddbox(String setaddbox) {
		driver.findElement(addbox).sendKeys(setaddbox);
	}

	public void typeaddtext() {
		driver.findElement(addtext).click();
	}

	public void typeaddclose() {
		driver.findElement(addclose).click();
	}

	public void typelogo1() {
		driver.findElement(logo1).click();
	}

	public void typelogo2() {
		driver.findElement(logo2).click();
	}

	public void typemanagelay() {
		driver.findElement(managelay).click();
	}

	public void typeuploadwater() {
		driver.findElement(uploadwater).click();
	}

	public void typefaq1() {
		driver.findElement(faq1).click();
	}

	public void typefaq2() {
		driver.findElement(faq2).click();
	}

	public void typefaq3() {
		driver.findElement(faq3).click();
	}

	public void typefaq4() {
		driver.findElement(faq4).click();
	}

	public void typefaq5() {
		driver.findElement(faq5).click();
	}
}
