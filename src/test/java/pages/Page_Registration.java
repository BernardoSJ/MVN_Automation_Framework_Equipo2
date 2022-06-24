package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app.support.Keywords;
import templates.PageTemplate;

public class Page_Registration extends PageTemplate{

	private String xpathEmailFieldForNewAccount = "//input[@id='spree_user_email']";
	private String xpathPasswordFieldForNewAccount = "//input[@id='spree_user_password']";
	private String xpathConfirmPasswordFieldForNewAccount = "//input[@id='spree_user_password_confirmation']";
	private String xpathCreateButton = "//input[@name='commit' and @value='Create']";
	private String xpathLoginLink = "//a[@href='/login']";
	private String xpathEmailFieldGuest = "//input[@id='order_email']";
	private String xpathContinueButton = "//input[@name='commit' and @value='Continue']";
	public static final String URL = "https://demosite.appvance.com/checkout/registration";
	
	public Page_Registration(WebDriver driver) {
		super(driver);
	}
	
	public void goToLoginLink() {
		Keywords.clickElement(driver, By.xpath(xpathLoginLink));
	}
	
	public void createNewAccount(String email,String password, String confirmPassword) {
		Keywords.writeElement(driver, By.xpath(xpathEmailFieldForNewAccount), email);
		Keywords.writeElement(driver, By.xpath(xpathPasswordFieldForNewAccount), password);
		Keywords.writeElement(driver, By.xpath(xpathConfirmPasswordFieldForNewAccount), confirmPassword);
		Keywords.clickElement(driver, By.xpath(xpathCreateButton));
	}
	
	public void enterAccountAsGuest(String email) {
		Keywords.writeElement(driver, By.xpath(xpathEmailFieldGuest), email);
		Keywords.clickElement(driver, By.xpath(xpathContinueButton));
	}
	
}
