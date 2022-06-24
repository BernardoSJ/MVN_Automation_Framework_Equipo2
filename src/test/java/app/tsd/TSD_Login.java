package app.tsd;
/**
 * Copyright: Softtek. Description: In this file contains a basic test case of
 * demosite application especifally the login part.
 * 
 * @author Bernardo Salinas Jaquez<b.salinas>
 *
 */


import org.testng.annotations.Test;

import app.support.ExcelPropertyLoader;
import app.support.Keywords;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TSD_Login {

	public String baseUrl = "https://demosite.appvance.com/";
	String driverPath = "C:\\Academia2206\\libs\\webdrivers\\chromedriver-102.0.5.exe";
	String excelPath = "C:\\Academia2206\\libs\\demosite_parameters.xlsx";
	public WebDriver driver;
	ExcelPropertyLoader excelData;
	
	
	@Test(description = "Log in the user", priority = 1)
	public void logInUser() {
		System.out.println("Test Case Log in the user");
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
