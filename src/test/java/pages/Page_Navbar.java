package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app.support.Keywords;
import templates.PageTemplate;

public class Page_Navbar extends PageTemplate {

	private String xpathLogin = "//li[@id='link-to-login']/a";
	private String xpathLogoHome = "//figure[@id='logo']/a";
	private String xpathLinkHome = "//li[@id='link-to-login']/a";
	private String xpathSearchInput = "//input[@name='keywords']";
	private String xpathSearchButton = "//input[@type='submit' and @value='Search']";
	private String xpathTypeSearchSelect = "//select[@name='taxon']";
	private String xpathCart = "//li[@id='link-to-cart']/a";
	public static final String URL = "https://demosite.appvance.com/"; // We can access to this from excel file or from here

	public Page_Navbar(WebDriver driver) {
		super(driver);
	}
	
	public void goToLogin() {
		Keywords.clickElement(driver, By.xpath(xpathLogin));
	}
	
	public void goToHomeLink() {
		Keywords.clickElement(driver, By.xpath(xpathLinkHome));
	}
	
	public void goToHomeLogo() {
		Keywords.clickElement(driver, By.xpath(xpathLogoHome));
	}
	
	public void goToCart() {
		Keywords.clickElement(driver, By.xpath(xpathCart));
	}
	
	public void searchByText(String text) {
		Keywords.clearSelect(driver, By.xpath(xpathTypeSearchSelect));
		Keywords.writeElement(driver, By.xpath(xpathSearchInput), text);
		Keywords.clickElement(driver, By.xpath(xpathSearchButton));
	}
	
	public void searchByType(String value) {
		Keywords.clearElement(driver, By.xpath(xpathSearchInput));
		Keywords.selectElement(driver, By.xpath(xpathTypeSearchSelect), value);
		Keywords.clickElement(driver, By.xpath(xpathSearchButton));
	}
}
