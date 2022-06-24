package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app.support.Keywords;
import templates.PageTemplate;

public class Page_CreateAccount extends PageTemplate{

	private String xpathEmailField = "//input[@id='spree_user_email']";
	private String xpathPasswordField = "//input[@id='spree_user_password']";
	private String xpathConfirmPasswordField = "//input[@id='spree_user_password_confirmation']";
	private String xpathCreateAccountButton = "//input[@name='commit']";
	private String xpathLoginLink = "//a[@href='/login']";
	public static final String URL = "https://demosite.appvance.com/signup";
	
	public Page_CreateAccount(WebDriver driver) {
		super(driver);
	}
	
	public void createAccount(String email, String password, String confirmPassword) {
		Keywords.writeElement(driver, By.xpath(xpathEmailField), email);
		Keywords.writeElement(driver, By.xpath(xpathPasswordField), password);
		Keywords.writeElement(driver, By.xpath(xpathConfirmPasswordField), password);
		Keywords.clickElement(driver, By.xpath(xpathCreateAccountButton));
	}
	
	public void goToLoginPage() {
		Keywords.clickElement(driver, By.xpath(xpathLoginLink));
	}
	
	
}
