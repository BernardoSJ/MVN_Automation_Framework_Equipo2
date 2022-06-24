package app.tsd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import app.support.ExcelPropertyLoader;

/**
 * Copyright: Softtek. Description: In this file contains a basic test case of
 * demosite application especifally how to create an account.
 * 
 * @author Bernardo Salinas Jaquez<b.salinas>
 *
 */
public class TSD_CreateAccount {

	public String baseUrl = "https://demosite.appvance.com/";
	String driverPath = "C:\\Academia2206\\libs\\webdrivers\\chromedriver-102.0.5.exe";
	String excelPath = "C:\\Academia2206\\libs\\demosite_parameters.xlsx";
	public WebDriver driver;
	ExcelPropertyLoader excelData;
	
	@Test(description = "Create a new account", priority = 1)
	public void createAnAccount() {
		System.out.println("Test Case Create a new Account");
	}
	
	@BeforeClass
	public void beforeClass() {
		// Load test data required
		excelData = new ExcelPropertyLoader();
		excelData.LoadFile(excelPath);
		baseUrl = excelData.getValue("baseUrl");
		driverPath = excelData.getValue("driverPath");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
