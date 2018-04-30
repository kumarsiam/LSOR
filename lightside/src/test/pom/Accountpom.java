package test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Accountpom {
	WebDriver driver;

	By firstname = By.id("accounts_custompro_first_name");

	By lastname = By.id("accounts_custompro_last_name");

	By username = By.id("accounts_custompro_usernm");

	By submit = By.xpath("//div[@class='mm-dialog-button-container']//a[text()='Submit']");

	By pass = By.id("accounts_new_password");

	By repass = By.id("accounts_re_new_password");

	By update = By.xpath("//div[@class='mm-dialog-button-container']//a[text()='Update']");

	By updatebilling = By.className("mm-update-subscription-button");

	By cancel = By.xpath("//a[text()='cancel']");

	// update billing details
	By credit = By.id("mm_field_cc_number");
	By security = By.id("mm_field_cc_cvv");

	By address = By.id("mm_field_billing_address");

	By city = By.id("mm_field_billing_city");

	By pin = By.id("mm_field_billing_zip");

	By updatebill = By.xpath("//a[text()='Update']");

	By cancelbill = By.className("mm-ui-button");

	By icon1 = By.xpath("//span[@id='5691|114967']/i");
	By icon2 = By.xpath("//span[@id='5691|104880']/i");

	By close = By.xpath("//span[@class='pi-close']");
	By print = By.xpath("//span[@class='print_invoice']");
	By printview = By.xpath("//button[text()='Print']");

	By pagination = By.xpath("//a[@title='Next']");
	By paginationpre = By.xpath("//a[@title='Previous']");

	By paginationlast = By.xpath("//a[@title='Last']");

	public Accountpom(WebDriver driver) {
		this.driver = driver;
	}

	public void typefirstnamecr() {
		driver.findElement(firstname).clear();
	}

	public void typefirstname(String setfirstname) {
		driver.findElement(firstname).sendKeys(setfirstname);
	}

	public void typelastnamecr() {
		driver.findElement(lastname).clear();
	}

	public void typelastname(String setlastname) {
		driver.findElement(lastname).sendKeys(setlastname);
	}

	public void typeusernamecr() {
		driver.findElement(username).clear();
	}

	public void typeusername(String setusername) {
		driver.findElement(username).sendKeys(setusername);
	}

	public void typesubmit() {
		driver.findElement(submit).click();
	}

	public void typepass(String setpass) {
		driver.findElement(pass).sendKeys(setpass);
	}

	public void typerepass(String setrepass) {
		driver.findElement(repass).sendKeys(setrepass);
	}

	public void typeupdate() {
		driver.findElement(update).click();
	}

	public void typecancel() {
		driver.findElement(cancel).click();
	}

	public void typeupdatebilling() {
		driver.findElement(updatebilling).click();
	}

	public void typecredit(String setcredit) {
		driver.findElement(credit).sendKeys(setcredit);
	}

	public void typesecurity(String setsecurity) {
		driver.findElement(security).sendKeys(setsecurity);
	}

	public void typeaddress(String setaddress) {
		driver.findElement(address).sendKeys(setaddress);
	}

	public void typecity(String setcity) {
		driver.findElement(city).sendKeys(setcity);
	}

	public void typepin(String setpin) {
		driver.findElement(pin).sendKeys(setpin);
	}

	public void typeupdatebill() {
		driver.findElement(updatebill).click();
	}

	public void typecancelbill() {
		driver.findElement(cancelbill).click();
	}

	public void typeicon1() {
		driver.findElement(icon1).click();
	}

	public void typeicon2() {
		driver.findElement(icon2).click();
	}

	public void typeclose() {
		driver.findElement(close).click();
	}

	public void typeprint() {
		driver.findElement(print).click();
	}

	public void typeprintview() {
		driver.findElement(printview).click();
	}

	public void typepagination() {
		driver.findElement(pagination).click();
	}

	public void typepaginationpre() {
		driver.findElement(paginationpre).click();
	}

	public void typepaginationlast() {
		driver.findElement(paginationlast).click();
	}
}
