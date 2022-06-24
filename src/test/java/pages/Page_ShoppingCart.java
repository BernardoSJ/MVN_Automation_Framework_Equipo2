package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app.support.Keywords;
import templates.PageTemplate;

public class Page_ShoppingCart extends PageTemplate {
	private String xpathContinueShoppingLink = "//div[@data-hook='cart_container']//a[text()='Continue shopping']";
	private String xpathEmptyCartLink = "//input[@type='submit' and @name='commit']";
	private String xpathCouponCode= "//input[@type='text' and @id='order_coupon_code']";
	private String xpathApplyButton = "//button[@type='submit' and @name='button' and text()='Apply']";
	private String xpathUpdateButton = "//button[@type='submit' and @name='button' and @id='update-button']";
	private String xpathCheckoutButton = "//button[@type='submit' and @name='checkout' and @id='checkout-link']";
	public static final String URL = "https://demosite.appvance.com/";

	public Page_ShoppingCart(WebDriver driver) {
		super(driver);
	}

	public void clickOnContinueShopping() {
		Keywords.clickElement(driver, By.xpath(xpathContinueShoppingLink));
	}
	
	public void clickOnEmptyCart() {
		Keywords.clickElement(driver, By.xpath(xpathEmptyCartLink));
	}
	
	public void clickOnUpdate() {
		Keywords.clickElement(driver, By.xpath(xpathUpdateButton));
	}
	
	public void clickOnCheckout() {
		Keywords.clickElement(driver, By.xpath(xpathCheckoutButton));
	}
	
	public void applyCouponCode(String code) {
		Keywords.writeElement(driver, By.xpath(xpathCouponCode), code);
		Keywords.clickElement(driver, By.xpath(xpathApplyButton));
	}
	
	public void changeQuantity(int numItem, int newQuantity) {
		String xpathFieldQuantity = "order_line_items_attributes_" + numItem + "_quantity";
		Keywords.writeElement(driver, By.xpath(xpathFieldQuantity), Integer.toString(newQuantity));
	}
	
}
