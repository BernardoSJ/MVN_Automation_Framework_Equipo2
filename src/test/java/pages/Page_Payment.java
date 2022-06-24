package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app.support.Keywords;
import templates.PageTemplate;

public class Page_Payment extends PageTemplate{

	private String xpathCreditCardOption = "//input[@id='order_payments_attributes__payment_method_id_2']";
	private String xpathCheckOption = "//input[@id='order_payments_attributes__payment_method_id_3']";
	private String xpathCardNumberField = "//input[@id='card_number']";
	private String xpathExpiryField = "//input[@id='card_expiry']";
	private String xpathCardCodeField = "//input[@id='card_code']";
	private String xpathCVVlink = "//a[@id='cvv_link']";
	private String xpathCouponCode = "//input[@id='order_coupon_code']";
	private String xpathContinueButton = "//input[@name='commit']";
	public static final String URL = "https://demosite.appvance.com/checkout/payment";
	
	public Page_Payment(WebDriver driver) {
		super(driver);
	}
	
	public void selectCreditCard() {
		Keywords.clickElement(driver, By.xpath(xpathCreditCardOption));
	}
	
	public void selectCheckCoupon() {
		Keywords.clickElement(driver, By.xpath(xpathCheckOption));
	}
	
	public void clickCvvLink() {
		Keywords.clickElement(driver, By.xpath(xpathCVVlink));
	}
	
	public void payWithCreditCard(String number, String expiration, String cvv) {
		Keywords.writeElement(driver, By.xpath(xpathCardNumberField), number);
		Keywords.writeElement(driver, By.xpath(xpathExpiryField), expiration);
		Keywords.writeElement(driver, By.xpath(xpathCardCodeField), cvv);
		Keywords.clickElement(driver, By.xpath(xpathContinueButton));
	}
	
	public void insertCouponCode(String code) {
		Keywords.writeElement(driver, By.xpath(xpathCouponCode), code);
		Keywords.clickElement(driver, By.xpath(xpathContinueButton));
	}
	
}
