package test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegDatapom {
	WebDriver driver;
	By tenantname = By.name("test_name");
	By companyname = By.name("test_company_inst_name");
	By submitroom = By.className("btn");
	By dob = By.name("test_dob");
	By doj = By.name("test_doj");
	By permanentadd = By.name("test_permanent_address");
	By officeadd = By.name("test_office_addr");
	By percity = By.name("test_city");
	By offcity = By.name("test_office_city");
	By perstate = By.name("test_state");
	By offstate = By.name("test_office_state");
	By percountry = By.name("test_country");
	By offcountry = By.name("test_office_country");
	By perpincode = By.name("test_pin");
	By offpincode = By.name("test_office_pin");
	By emailid = By.name("test_emailid");
	By mobile = By.name("test_mobile");
	By guardname = By.name("test_father_guard_name");
	By guradno = By.name("test_father_guardian_no");

	By contactsubmit = By.id("submitidcontactsubmit");

	public RegDatapom(WebDriver driver) {
		this.driver = driver;
	}

	public void typetenantname(String settenantname) {
		driver.findElement(tenantname).sendKeys(settenantname);
	}

	public void typecompanyname(String setcompanyname) {
		driver.findElement(companyname).sendKeys(setcompanyname);
	}

	public void typesubmitroom() {
		driver.findElement(submitroom).click();
	}

	public void typedob() {
		driver.findElement(dob).click();
	}

	public void typedoj() {
		driver.findElement(doj).click();
	}

	public void typepermanentadd(String setpermanentadd) {
		driver.findElement(permanentadd).sendKeys(setpermanentadd);
	}

	public void typeofficeadd(String setofficeadd) {
		driver.findElement(officeadd).sendKeys(setofficeadd);
	}

	public void typepercity(String setpercity) {
		driver.findElement(percity).sendKeys(setpercity);
	}

	public void typeoffcity(String setoffcity) {
		driver.findElement(offcity).sendKeys(setoffcity);
	}

	public void typeperstate(String setperstate) {
		driver.findElement(perstate).sendKeys(setperstate);
	}

	public void typeoffstate(String setoffstate) {
		driver.findElement(offstate).sendKeys(setoffstate);
	}

	public void typepercountry(String setpercountry) {
		driver.findElement(percountry).sendKeys(setpercountry);
	}

	public void typeoffcountry(String setoffcountry) {
		driver.findElement(offcountry).sendKeys(setoffcountry);
	}

	public void typeperpincode(String setperpincode) {
		driver.findElement(perpincode).sendKeys(setperpincode);
	}

	public void typeoffpincode(String setoffpincode) {
		driver.findElement(offpincode).sendKeys(setoffpincode);
	}

	public void typeemailid(String setemailid) {
		driver.findElement(emailid).sendKeys(setemailid);
	}

	public void typemobile(String setmobile) {
		driver.findElement(mobile).sendKeys(setmobile);
	}

	public void typeguardname(String setguardname) {
		driver.findElement(guardname).sendKeys(setguardname);
	}

	public void typeguradno(String setguradno) {
		driver.findElement(guradno).sendKeys(setguradno);
	}

	public void typecontactsubmit() {
		driver.findElement(contactsubmit).click();
	}

}
