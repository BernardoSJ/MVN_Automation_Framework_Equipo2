package app.tsd;

import org.testng.annotations.Test;

import app.support.ExcelPropertyLoader;
import app.support.Keywords;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

/**
 * Copyright: Softtek. Description: In this file contains a basic test case of
 * demosite application.
 * 
 * @author Juan Carlos Hernández Castro<j.hernandez>
 *
 */

public class TSD_Cart {
	public String baseUrl = "https://demosite.appvance.com/";
	String driverPath = "C:\\Academia2206\\libs\\webdrivers\\chromedriver-102.0.5.exe";
	String excelPath = "C:\\Academia2206\\libs\\demosite_data.xlsx";
	public WebDriver driver;
	ExcelPropertyLoader excelData;

	@Test(description = "Add items to cart", priority = 1)
	public void addItemsToCart() {
		try {
			addItemToCart(1, 1, true);
			addItemToCart(2, 2, true);
			addItemToCart(1, 1, false);
			addItemToCart(2, 1, false);
		} catch (Exception e) {
			Assert.fail("Error Adding items - " + e.getMessage());
		}
	}

	@Test(description = "Change quantity in the cart and checkout", priority = 2)
	public void changeQuantityofCart() {
		try {
			changeQuantity(1, 2);
			Keywords.clickElement(driver, By.id("checkout-link"));
		} catch (Exception e) {
			Assert.fail("Error Changing quantity - " + e.getMessage());
		}
	}

	@Test(description = "Create new account and address", priority = 3)
	public void createNewAccount() {
		try {
			Keywords.writeElement(driver, By.id("spree_user_email"), excelData.getValue("spree_user_email"));
			Keywords.writeElement(driver, By.id("spree_user_password"), excelData.getValue("spree_user_password"));
			Keywords.writeElement(driver, By.id("spree_user_password_confirmation"),
					excelData.getValue("spree_user_password_confirmation"));
			Keywords.clickElement(driver, By.name("commit"));
			String expectedMessage = "Welcome! You have signed up successfully.";
			String actualMessage = Keywords.getText(driver, By.xpath("//div[@class='alert alert-notice']"));
			Assert.assertEquals(actualMessage, expectedMessage);
		} catch (Exception e) {
			Assert.fail("User already exist - " + e.getMessage());
		}
	}

	@Test(description = "Fill address", priority = 4, dependsOnMethods = "createNewAccount")
	public void fillAddress() {
		try {
			Keywords.writeElement(driver, By.id("order_bill_address_attributes_firstname"),
					excelData.getValue("order_bill_address_attributes_firstname"));
			Keywords.writeElement(driver, By.id("order_bill_address_attributes_lastname"),
					excelData.getValue("order_bill_address_attributes_lastname"));
			Keywords.writeElement(driver, By.id("order_bill_address_attributes_address1"),
					excelData.getValue("order_bill_address_attributes_address1"));
			Keywords.writeElement(driver, By.id("order_bill_address_attributes_city"),
					excelData.getValue("order_bill_address_attributes_city"));
			Keywords.writeElement(driver, By.id("order_bill_address_attributes_zipcode"),
					excelData.getValue("order_bill_address_attributes_zipcode"));
			Keywords.writeElement(driver, By.id("order_bill_address_attributes_phone"),
					excelData.getValue("order_bill_address_attributes_phone"));
			Keywords.selectElement(driver, By.id("order_bill_address_attributes_state_id"),
					excelData.getValue("order_bill_address_attributes_state_id"));
			Keywords.clickElement(driver, By.name("commit"));
		} catch (Exception e) {
			Assert.fail("Error Filling Address - " + e.getMessage());
		}
	}

	@Test(description = "Complete the delivery", priority = 5, dependsOnMethods = "fillAddress")
	public void completeDelivery() {
		try {
			Keywords.clickElement(driver, By.name("commit"));
			fillPaymentWithCode();
			String expectedMessage = "Your order has been processed successfully";
			String actualMessage = Keywords.getText(driver, By.xpath("//div[@class='alert alert-notice']"));
			System.out.println(actualMessage + "\n" + Keywords.getText(driver, By.xpath("//fieldset//h1")));
			Assert.assertEquals(actualMessage, expectedMessage);
		} catch (Exception e) {
			Assert.fail("Error Completing delivery - " + e.getMessage());
		}
	}

	/*
	 * Description: This method pays with code
	 * 
	 */

	public void fillPaymentWithCode() {
		Keywords.clickElement(driver, By.id("order_payments_attributes__payment_method_id_3"));
		Keywords.clickElement(driver, By.name("commit"));
	}

	/*
	 * Description: This method change the quantity of an item Inputs: numItem: To
	 * add an item, it receives a number of item newQuantity: The new quantity
	 */

	public void changeQuantity(int numItem, int newQuantity) {
		Keywords.clickElement(driver, By.xpath("//li[@id='link-to-cart']//a"));
		Keywords.writeElement(driver, By.id("order_line_items_attributes_" + numItem + "_quantity"),
				Integer.toString(newQuantity));
		Keywords.clickElement(driver, By.id("update-button"));
	}

	/*
	 * Description: This method adds items to cart by brand or category Inputs:
	 * isFromCategory: It contains true if we will add an item by category,
	 * otherwise should be false numSubMenu: Due the site doesn't contain a key or
	 * id, we send the submenu number numItem: To add an item, it receives a number
	 * of item
	 * 
	 */

	public void addItemToCart(int numSubmenu, int numItem, Boolean isFromCategory) {
		int categoryOrBrand = isFromCategory ? 1 : 2;
		Keywords.clickElement(driver,
				By.xpath("//nav[@id='taxonomies']/div[" + categoryOrBrand + "]/a[" + numSubmenu + "]"));
		Keywords.clickElement(driver, By.xpath("//div[@id='products']//div[" + numItem + "]//a"));
		System.out.println(Keywords.getText(driver, By.xpath("//div[@id='product-description']/h1")));
		Keywords.clickElement(driver, By.id("add-to-cart-button"));
		Keywords.clickElement(driver, By.xpath("//li[@id='home-link']/a"));
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		// Load test data required
		excelData = new ExcelPropertyLoader();
		excelData.LoadFile(excelPath);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
