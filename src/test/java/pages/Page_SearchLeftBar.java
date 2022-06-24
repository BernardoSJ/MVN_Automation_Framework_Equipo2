package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app.support.Keywords;
import templates.PageTemplate;

public class Page_SearchLeftBar extends PageTemplate {
	private String xpathPriceRange = "//input[@type='checkbox' and @id='~KEYPRICERANGE~']";
	private String xpathBrands = "//input[@type='checkbox' and @id='~KEYBRAND~']";
	private String xpathSearchButton = "//form[@id='sidebar_products_search']//input[@type='submit' and @value='Search']";
	public static final String URL = "https://demosite.appvance.com/";

	public Page_SearchLeftBar(WebDriver driver) {
		super(driver);
	}

	// We receive a list of ids like this id1~COMMA~id2~COMMA~id3
	public void selectPriceRange(String ids) {
		String[] listKeys = ids.split("~COMMA~");
		for (String key : listKeys) {
			String finalXPathPriceRange = xpathPriceRange.replace("~KEYPRICERANGE~", key);
			Keywords.clickElement(driver, By.xpath(finalXPathPriceRange));
		}
	}

	// We receive a list of ids like this id1~COMMA~id2~COMMA~id3
	public void selectBrands(String ids) {
		String[] listKeys = ids.split("~COMMA~");
		for (String key : listKeys) {
			String finalXPathBrand = xpathBrands.replace("~KEYBRAND~", key);
			Keywords.clickElement(driver, By.xpath(finalXPathBrand));
		}
	}

	public void searchClick() {
		Keywords.clickElement(driver, By.xpath(xpathSearchButton));
	}

}
