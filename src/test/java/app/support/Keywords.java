package app.support;

import java.util.List;

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

	public static void clearElement(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		element.clear();
	}

	public static void clearSelect(WebDriver driver, By by) {
		Select element = new Select(driver.findElement(by));
		element.selectByValue("");
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

	public static List<WebElement> getListOfElements(WebDriver driver, By by) {
		List<WebElement> elements = driver.findElements(by);
		return elements;
	}
}
