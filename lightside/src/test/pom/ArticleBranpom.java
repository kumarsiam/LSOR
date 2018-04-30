package test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticleBranpom {
	WebDriver driver;
	By contactuslink = By.partialLinkText(" Contact Us");
	// preview
	By firstname = By.id("personal_custompro_first_name");
	By lastname = By.id("personal_custompro_last_name");
	By companyname = By.id("personal_custompro_custom_1");
	By teamname = By.id("personal_custompro_custom_23");
	By jobtitle = By.id("personal_custompro_custom_2");
	By desgination = By.id("personal_custompro_custom_3");
	By city = By.id("personal_custompro_custom_4");
	By state = By.id("personal_custompro_custom_16");
	By phone = By.id("personal_custompro_custom_5");
	By email = By.id("personal_custompro_email");
	By website = By.id("personal_custompro_custom_6");
	By professionalbody = By.xpath("//body[@id='tinymce']//p");
	By licencenumber = By.id("personal_custompro_custom_9");
	By url = By.id("personal_custompro_custom_22");
	By housecheck = By.xpath("//label[text()=' Equal Housing']");
	By closepre = By.className("pre_close");
	// social
	By faceurl = By.id("personal_custompro_custom_10");
	By twitterurl = By.id("personal_custompro_custom_11");
	By linkedinurl = By.id("personal_custompro_custom_12");
	By Gplusurl = By.id("personal_custompro_custom_13");
	By printeresturl = By.id("personal_custompro_custom_14");
	By instagramurl = By.id("personal_custompro_custom_31");
	By blogurl = By.id("post_breb_hom");
	By submitbutton = By.xpath("//div[@class='mm-dialog-button-container']//a[text()='Submit']");
	By watchplay = By.xpath("//button[@aria-label='Play']");
	// social
	By blogwatch = By.xpath("//p[@class='direct_url']//a[@class='youtube cboxElement']");
	By savemail = By.className("save_mail");
	By compliance = By.id("mceu_42");
	By equalhouse = By.xpath("//label[text()=' Equal Housing']");
	By Realtor = By.xpath("//label[text()=' Realtor']");
	By MLS = By.xpath("//label[text()=' MLS']");

	public ArticleBranpom(WebDriver driver) {
		this.driver = driver;
	}

	public void typecontactuslink() {
		driver.findElement(contactuslink).click();
	}

	public void typefirstname(String setfirstname) {
		driver.findElement(firstname).sendKeys(setfirstname);
	}

	public void typelastname(String setlastname) {
		driver.findElement(lastname).sendKeys(setlastname);
	}

	public void typecompanyname(String setcompanyname) {
		driver.findElement(companyname).sendKeys(setcompanyname);
	}

	public void typeteamname(String setteamname) {
		driver.findElement(teamname).sendKeys(setteamname);
	}

	public void typejobtitle(String setjobtitle) {
		driver.findElement(jobtitle).sendKeys(setjobtitle);
	}

	public void typedesgination(String setdesgination) {
		driver.findElement(desgination).sendKeys(setdesgination);
	}

	public void typecity(String setcity) {
		driver.findElement(city).sendKeys(setcity);
	}

	public void typestate(String setstate) {
		driver.findElement(state).sendKeys(setstate);
	}

	public void typephone(String setphone) {
		driver.findElement(phone).sendKeys(setphone);
	}

	public void typeemail(String setemail) {
		driver.findElement(email).sendKeys(setemail);
	}

	public void typewebsite(String setwebsite) {
		driver.findElement(website).sendKeys(setwebsite);
	}

	public void typelicencenumber(String setlicencenumber) {
		driver.findElement(licencenumber).sendKeys(setlicencenumber);
	}

	public void typeurl(String seturl) {
		driver.findElement(url).sendKeys(seturl);
	}

	public void typefirstnamecr() {
		driver.findElement(firstname).clear();
	}

	public void typelastnamecr() {
		driver.findElement(lastname).clear();
	}

	public void typecompanynamecr() {
		driver.findElement(companyname).clear();
	}

	public void typeteamnamecr() {
		driver.findElement(teamname).clear();
	}

	public void typejobtitlecr() {
		driver.findElement(jobtitle).clear();
	}

	public void typedesginationcr() {
		driver.findElement(desgination).clear();
	}

	public void typecitycr() {
		driver.findElement(city).clear();
	}

	public void typestatecr() {
		driver.findElement(state).clear();
	}

	public void typephonecr() {
		driver.findElement(phone).clear();
	}

	public void typeemailcr() {
		driver.findElement(email).clear();
	}

	public void typewebsitecr() {
		driver.findElement(website).clear();
	}

	public void typeprofessionalbodycr() {
		driver.findElement(professionalbody).clear();
	}

	public void typelicencenumbercr() {
		driver.findElement(licencenumber).clear();
	}

	public void typeurlcr() {
		driver.findElement(url).clear();
	}

	public void typehousecheck() {
		driver.findElement(housecheck).clear();
	}

	public void typeclosepre() {
		driver.findElement(closepre).clear();
	}

	public void typefaceurl(String setfaceurl) {
		driver.findElement(faceurl).sendKeys(setfaceurl);
	}

	public void typetwitterurl(String settwitterurl) {
		driver.findElement(twitterurl).sendKeys(settwitterurl);
	}

	public void typelinkedinurl(String setlinkedinurl) {
		driver.findElement(linkedinurl).sendKeys(setlinkedinurl);
	}

	public void typeGplusurl(String setGplusurl) {
		driver.findElement(Gplusurl).sendKeys(setGplusurl);
	}

	public void typeprinteresturl(String setprinteresturl) {
		driver.findElement(printeresturl).sendKeys(setprinteresturl);
	}

	public void typeinstagramurl(String setinstagramurl) {
		driver.findElement(instagramurl).sendKeys(setinstagramurl);
	}

	public void typefacecr() {
		driver.findElement(faceurl).clear();
	}

	public void typetwittercr() {
		driver.findElement(twitterurl).clear();
	}

	public void typelinkedincr() {
		driver.findElement(linkedinurl).clear();
	}

	public void typeGpluscr() {
		driver.findElement(Gplusurl).clear();
	}

	public void typeprinterestcr() {
		driver.findElement(printeresturl).clear();
	}

	public void typeinstagramcr() {
		driver.findElement(instagramurl).clear();
	}

	public void typeblogurl(String setblogurl) {
		driver.findElement(blogurl).sendKeys(setblogurl);
	}

	public void typeblogcr() {
		driver.findElement(blogwatch).clear();
	}

	public void typesubmitbutton() {
		driver.findElement(submitbutton).click();
	}

	public void typewatchplay() {
		driver.findElement(watchplay).click();
	}

	public void typesavemail() {
		driver.findElement(savemail).click();
	}

	public void typecompliance(String setcompliance) {
		driver.findElement(compliance).sendKeys(setcompliance);
	}

	public void typeequalhouse() {
		driver.findElement(equalhouse).click();
	}

	public void typeRealtor() {
		driver.findElement(Realtor).click();
	}

	public void typeMLS() {
		driver.findElement(MLS).click();
	}

}
