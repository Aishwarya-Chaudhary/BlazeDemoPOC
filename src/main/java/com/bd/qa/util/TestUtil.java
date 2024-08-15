package com.bd.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bd.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long Page_Load_Timeout = 20;
	public static long Impicite_Wait = 10;


	// Page factory Initialisation
	public TestUtil() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	// Click any Web Element
	public static void clickElement(WebElement a) {
		a.click();
	}

	// Validate the new URL or page title
	public static Boolean validateCurrentUrl(String givenUrlValue) {
		String expectedUrl = givenUrlValue;
		String actualUrl = driver.getCurrentUrl();

		if (actualUrl.equals(expectedUrl)) {
			System.out.println("Button click validated, navigated to correct URL.");
			return true;
		} else {
			System.out.println("Navigation failed, expected URL: " + expectedUrl + ", but got: " + actualUrl);
			return false;
		}
	}

	// Select option from drop down
	public static void selectFromDropDown(String choosenvlaue, WebElement allOptionsLocation) {
		Select dropdown = new Select(allOptionsLocation);
		dropdown.selectByVisibleText(choosenvlaue);
	}

	// Fetch the drop down selected value
	public static String getSelectedDropDownValue(WebElement allOptionsLocation) {
		Select dropdown = new Select(allOptionsLocation);
		WebElement selectedOption = dropdown.getFirstSelectedOption();
		String selectedValue = selectedOption.getText();
		return selectedValue;
	}

	// Enter String into field
	public static void enterString(WebElement fielLocator, String input) {
		fielLocator.sendKeys(input);
	}

	// To switch to Main Panel
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	// Validate Input Field value
	public String validateInputFieldName(WebElement webElement, String string) {
		enterString(webElement, string);
		return webElement.getText();
	}
//To take screenshot
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
