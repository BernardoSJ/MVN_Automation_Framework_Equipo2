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
	
	public void searchByText(String text) {
		Keywords.writeElement(driver, By.xpath(xpathSearchInput), text);
		Keywords.clickElement(driver, By.xpath(xpathSearchButton));
	}
	
	public void searchByType(String value) {
		Keywords.selectElement(driver, By.xpath(xpathTypeSearchSelect), value);
		Keywords.clickElement(driver, By.xpath(xpathSearchButton));
	}
}
