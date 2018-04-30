package test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Articlepom {
	WebDriver driver;

	By resourceful = By.xpath("//a[@href='/share-article/resourceful']");

	By entertaining = By.xpath("//a[@href='/share-article/entertaining']");

	By marketnews = By.xpath("//a[@href='/share-article/market-news']");

	By holiday = By.xpath("//a[@href='/share-article/holidays-events']");

	// resourceful sub category

	By homeownership = By.xpath("//a[@href='/share-article/resourceful/homeownership']");
	
	By homebuying = By.xpath("//a[@href='/share-article/resourceful/homebuying']");
	
	By homeselling = By.xpath("//a[@href='/share-article/resourceful/homeselling']");
	
	By fsbo = By.xpath("//a[@href='/share-article/resourceful/fsbo']");
	
	By expired = By.xpath("//a[@href='/share-article/resourceful/expired']");
	
	By all = By.xpath("//a[contains(text(),'ALL')]");
	
	//entertaining sub category
	
	

	public Articlepom(WebDriver driver) {
		this.driver = driver;
	}

	public void typeresourceful() {
		driver.findElement(resourceful).click();
	}

	public void typeentertaining() {
		driver.findElement(entertaining).click();
	}

	public void typemarketnews() {
		driver.findElement(marketnews).click();
	}

	public void typeholiday() {
		driver.findElement(holiday).click();
	}

	/*
	 * public void typetwitteruser(String settwitteruser) {
	 * driver.findElement(twitteruser).sendKeys(settwitteruser);
	 * 
	 * }
	 */

}
