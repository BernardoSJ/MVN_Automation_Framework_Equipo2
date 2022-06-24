package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import app.support.Keywords;
import templates.PageTemplate;

public class Page_Home extends PageTemplate {
	
	// It's not the best way to access to brand and category but there isn't other option 23/06/2022
	private String xpathCategoriesMenu = "//nav[@id='taxonomies']//div[1]";
	private String xpathBrandsMenu = "//nav[@id='taxonomies']//div[2]";
	private String xpathBaseItems = "//div[@data-hook='products_list_item']";
	private String xpathResultsItems = "//div[@id='products']//div[@data-hook='products_list_item']";
	public static final String URL = "https://demosite.appvance.com/"; // We can access to this from excel file or from here

	public Page_Home(WebDriver driver) {
		super(driver);
	}
	
	public void goToCategory(String name) {
		String finalXPathMenu = xpathCategoriesMenu + "//a[text()='" + name +"']";
		Keywords.clickElement(driver, By.xpath(finalXPathMenu));
	}
	
	public void goToBrand(String name) {
		String finalXPathmenu = xpathBrandsMenu + "//a[text()='" + name +"']";
		Keywords.clickElement(driver, By.xpath(finalXPathmenu));
	}
	
	public int numberOfItems() {
		return Keywords.getListOfElements(driver, By.xpath(xpathResultsItems)).size();
	}
	
	public void clickOnItem(String title) {
		String finalXPathItem = xpathBaseItems + "//span[@title='" + title + "']//ancestor::a";
		Keywords.clickElement(driver, By.xpath(finalXPathItem));
	}
	
}
