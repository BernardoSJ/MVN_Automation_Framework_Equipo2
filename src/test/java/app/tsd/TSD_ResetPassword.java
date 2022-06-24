package app.tsd;

import org.openqa.selenium.WebDriver;

import app.support.ExcelPropertyLoader;

/**
 * Copyright: Softtek. Description: In this file contains a basic test case of
 * demosite application especifally the reset password page.
 * 
 * @author Bernardo Salinas Jaquez<b.salinas>
 *
 */

import app.support.ExcelPropertyLoader;
import app.support.Keywords;
import pages.Page_ForgotPassword;
import pages.Page_Login;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TSD_ResetPassword {
	public String baseUrl = "";
	String driverPath = "C:\\Academia2206\\libs\\webdrivers\\chromedriver-102.0.5.exe";
	String excelPath = "C:\\Academia2206\\libs\\demosite_parameters.xlsx";
	String dataPath = "";
	String sheetData = "";
	private String xpathAcceptAlert = "//div[contains(@class,'alert')]";
	public WebDriver driver;
	ExcelPropertyLoader excelData;

	@DataProvider(name = "excel-data")
	public Object[] excelDP() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[] userObject = getExcelData(dataPath, sheetData);
		return userObject;
	}

	public String[] getExcelData(String fileName, String sheetName) {

		String[] data = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet(sheetName);
			XSSFRow row = sh.getRow(0);
			int noOfRows = 6;
			Cell cell;
			data = new String[noOfRows - 1];
			for (int i = 1; i < noOfRows; i++) {
				row = sh.getRow(i);
				cell = row.getCell(0);
				data[i - 1] = cell.getStringCellValue().toString();
			}
		} catch (Exception e) {
			System.out.println("The exception is: " + e.getMessage());
		}
		return data;
	}

	@Test(dataProvider = "excel-data", description = "Recover password of user", priority = 1)
	public void logInUser(String email) {
		System.out.println("Test Case Recover Password");
		try {
			Page_ForgotPassword newPassword = new Page_ForgotPassword(driver);
			driver.get(newPassword.URL);
			newPassword.resetPassword(email);
			;
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Assert.assertEquals(Keywords.getText(driver, By.xpath(xpathAcceptAlert)),
					"You will receive an email with instructions about how to reset your password in a few minutes.");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@BeforeClass
	public void beforeClass() {
		// Load test data required
		excelData = new ExcelPropertyLoader();
		excelData.LoadFile(excelPath);
		baseUrl = excelData.getValue("baseUrl");
		driverPath = excelData.getValue("driverPath");
		dataPath = excelData.getValue("dataPath");
		sheetData = excelData.getValue("sheetData");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
