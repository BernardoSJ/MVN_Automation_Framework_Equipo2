package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app.support.Keywords;
import templates.PageTemplate;

public class Page_ForgotPassword extends PageTemplate{
	
	private String xpathEmailField = "//input[@id='spree_user_email']";
	private String xpathResetPasswordButton = "//input[@name='commit']";
	public static final String URL = "https://demosite.appvance.com/password/recover";
	
	public Page_ForgotPassword(WebDriver driver) {
		super(driver);
	}
	
	public void resetPassword(String email) {
		Keywords.writeElement(driver, By.xpath(xpathEmailField), email);
		Keywords.clickElement(driver, By.xpath(xpathResetPasswordButton));
	}
}
