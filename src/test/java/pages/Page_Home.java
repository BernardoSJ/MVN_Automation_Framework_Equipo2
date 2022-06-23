package pages;

import org.openqa.selenium.WebDriver;
import templates.PageTemplate;

public class Page_Home extends PageTemplate {
	
	public static final String URL = "https://demosite.appvance.com/"; // We can access to this from excel file or from here

	public Page_Home(WebDriver driver) {
		super(driver);
	}
	
}
