package app.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keywords {
	public static void writeElement(WebDriver driver, By by, String text) {
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(text);
	}

	public static void clickElement(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.click();
	}
	
	public static String getText(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element.getText();
	}

	public static void selectElement(WebDriver driver, By by, String value) {
		Select select = new Select(driver.findElement(by));
		select.selectByValue(value);
	}
}
