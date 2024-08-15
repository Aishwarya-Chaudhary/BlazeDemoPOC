package com.bd.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bd.qa.base.TestBase;
import com.bd.qa.util.TestUtil;

public class ReservePage extends TestBase {

	@FindBy(xpath = "//h3[text ()='Flights from Boston to London: ']")
	private WebElement textReservePageHeader;

	// Page factory Initialization
	public ReservePage() {
		PageFactory.initElements(driver, this);
	}
	// Actions

	// Validate the Reserve Header Name
	public String validateReservePageHeader() {
		return textReservePageHeader.getText();
	}

	// Validating FindFlights button is clickable
	public PurchasePage clickButtonChooseThisFlights(String FlightNumber) {
		// TestUtil.clickElement(buttonChooseThisFlight);
		WebElement buttonChooseThisFlights = driver.findElement(
				By.xpath("//td[text()='" + FlightNumber + "']/parent::tr//input[@value='Choose This Flight']"));
		TestUtil.clickElement(buttonChooseThisFlights);
		return new PurchasePage();
	}

	// Validating FindFlights button is clickable
	public Boolean validatebuttonChooseThisFlight(String ExpectedUrl) {
		return TestUtil.validateCurrentUrl(ExpectedUrl);
	}

}
