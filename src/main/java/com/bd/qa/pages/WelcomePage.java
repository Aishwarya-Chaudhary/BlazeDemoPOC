package com.bd.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bd.qa.base.TestBase;
import com.bd.qa.util.TestUtil;

public class WelcomePage extends TestBase {

	// Page Factory / Object Repository
	@FindBy(xpath = "//h1[text ()='Welcome to the Simple Travel Agency!']")
	private WebElement textWelcomePageHeader;

	@FindBy(name = "fromPort")
	private WebElement dropdownDepartureCity;
	
	@FindBy(xpath = "//select[@name='fromPort']/option")
	private List<WebElement>  dropdownExample;

	@FindBy(name = "toPort")
	private WebElement dropdownDestinationCity;

	@FindBy(xpath = "//input[@value='Find Flights']")
	private WebElement buttonFindFlights;

	// Page factory Initialization
	public WelcomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	// Validate the Welcome Header Name

	public String validateWelcomeHeader() {
		return textWelcomePageHeader.getText();
	}

	// Validating DepartureCity
	public String validateDepartureCity(String departureCity) {
		TestUtil.selectFromDropDown(departureCity, dropdownDepartureCity);
		return TestUtil.getSelectedDropDownValue(dropdownDepartureCity);
	}

	// Validating DestinationCityCity
	public String validateDestinationCity(String destinationCity) {
		TestUtil.selectFromDropDown(destinationCity, dropdownDestinationCity);
		return TestUtil.getSelectedDropDownValue(dropdownDestinationCity);
	}

	// Validating FindFlights button is clickable
	public ReservePage clickButtonFindFlights() {
		TestUtil.clickElement(buttonFindFlights);
		return new ReservePage();
	}

	// Validating FindFlights button is clickable
	public Boolean validatebuttonFindFlights(String ExpectedUrl) {
		return TestUtil.validateCurrentUrl(ExpectedUrl);
	}
	
	//example
	 public void selectOptionByText(String optionText) {
		 TestUtil.clickElement(dropdownDepartureCity);
	        for (WebElement option : dropdownExample) {
	            if (option.getText().equalsIgnoreCase(optionText)) {
	                option.click();
	                break;
	            }
	        }
	    }

}
