package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app.support.Keywords;
import templates.PageTemplate;

public class Page_Login extends PageTemplate{

	private String xpathEmailField = "//input[@id='spree_user_email']";
	private String xpathPasswordField = "//input[@id='spree_user_password']";
	private String xpathCheckRemeber = "//input[@type='checkbox']";
	private String xpathLoginButton = "//input[@name='commit']";
	private String xpathCreateAccountLink = "//a[@href='/signup']";
	private String xpathForgotPasswordLink = "//a[@href='/password/recover']";
	public static final String URL = "https://demosite.appvance.com/login";
	
	public Page_Login(WebDriver driver) {
		super(driver);
	}
	
	public void logInUser(String email,String password,boolean remember) {
		Keywords.writeElement(driver, By.xpath(xpathEmailField), email);
		Keywords.writeElement(driver, By.xpath(xpathPasswordField), password);
		if(remember) {
			Keywords.clickElement(driver, By.xpath(xpathCheckRemeber));
		}
		Keywords.clickElement(driver, By.xpath(xpathLoginButton));
	}
	
	public void goToCreateAccountLink() {
		Keywords.clickElement(driver, By.xpath(xpathCreateAccountLink));
	}
	
	public void goToForgotPasswordLink() {
		Keywords.clickElement(driver, By.xpath(xpathForgotPasswordLink));
	}
	
}

