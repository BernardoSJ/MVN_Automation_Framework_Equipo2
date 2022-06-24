package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app.support.Keywords;
import templates.PageTemplate;

public class Page_AddProduct extends PageTemplate{

	private String xpathQuantityField = "//input[@id='quantity']";
	private String xpathAddToCartButton = "//button[@id='add-to-cart-button']";
	public static final String URL = "https://demosite.appvance.com/products/product_name";
	
	public Page_AddProduct(WebDriver driver) {
		super(driver);
	}
	
	public void addProductoToCart(int numElements) {
		Keywords.writeElement(driver, By.xpath(xpathQuantityField), Integer.toString(numElements));
		Keywords.clickElement(driver, By.xpath(xpathAddToCartButton));
	}
	
}
