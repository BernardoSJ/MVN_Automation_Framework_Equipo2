package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app.support.Keywords;
import templates.PageTemplate;

public class Page_Address extends PageTemplate{

	private String xpathFirstNameField = "//input[@id='order_bill_address_attributes_firstname']";
	private String xpathLastNameField = "//input[@id='order_bill_address_attributes_lastname']";
	private String xpathStreetAddressField = "//input[@id='order_bill_address_attributes_address1']";
	private String xpathAddressField = "//input[@id='order_bill_address_attributes_address2']";
	private String xpathCityField = "//input[@id='order_bill_address_attributes_city']";
	private String xpathCountrySelect = "//input[@id='order_bill_address_attributes_country_id']";
	private String xpathStateSelect = "//input[@id='order_bill_address_attributes_state_id']";
	private String xpathZipField = "//input[@id='order_bill_address_attributes_zipcode']";
	private String xpathPhoneField = "//input[@id='order_bill_address_attributes_phone']";
	private String xpathContinueButton = "//input[@name='commit']";
	public static final String URL = "https://demosite.appvance.com/checkout";
	
	public Page_Address(WebDriver driver) {
		super(driver);
	}
	
	public void insertAddress(String firstName, String lastName, String streetAddress, String streetAddressCont, String city, String country, String state, String zipCode, String phone) {
		Keywords.writeElement(driver, By.xpath(xpathFirstNameField), firstName);
		Keywords.writeElement(driver, By.xpath(xpathLastNameField), lastName);
		Keywords.writeElement(driver, By.xpath(xpathStreetAddressField), streetAddress);
		Keywords.writeElement(driver, By.xpath(xpathAddressField), streetAddressCont);
		Keywords.writeElement(driver, By.xpath(xpathCityField), city);
		Keywords.selectElement(driver, By.xpath(xpathCountrySelect), country);
		Keywords.selectElement(driver, By.xpath(xpathStateSelect), state);
		Keywords.writeElement(driver, By.xpath(xpathZipField), zipCode);
		Keywords.writeElement(driver, By.xpath(xpathPhoneField), phone);
		Keywords.clickElement(driver, By.xpath(xpathContinueButton));
	}
}
