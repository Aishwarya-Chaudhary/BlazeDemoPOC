package com.bd.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bd.qa.base.TestBase;
import com.bd.qa.util.TestUtil;

public class PurchasePage extends TestBase {

	@FindBy(xpath = "//h2[text ()='Your flight from TLV to SFO has been reserved.']")
	private WebElement textPurchasePageHeader;

	@FindBy(id = "inputName")
	public static WebElement inputFieldName;

	@FindBy(id = "address")
	public static WebElement inputFieldAddress;

	@FindBy(id = "city")
	public static WebElement inputFieldCity;

	@FindBy(id = "state")
	public static WebElement inputFieldState;

	@FindBy(id = "zipCode")
	public static WebElement inputFieldZipCode;

	@FindBy(name = "cardType")
	public static WebElement dropdownCardType;

	@FindBy(id = "creditCardNumber")
	public static WebElement inputFieldCreditCardNumber;

	@FindBy(id = "creditCardMonth")
	public static WebElement inputFieldCreditCardMonth;

	@FindBy(id = "creditCardYear")
	public static WebElement inputFieldCreditCardYear;

	@FindBy(id = "nameOnCard")
	public static WebElement inputFieldNameOnCard;

	@FindBy(xpath = "//input[@value='Purchase Flight']")
	private WebElement buttunPurchaseFlight;

	// Page factory Initialization
	public PurchasePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	
	// Validate the Purchase Header Name
	public String validatePurchasePageHeader() {
		return textPurchasePageHeader.getText();
	}

	// Validate Input Field Name
		public String validateInputFieldName(String name) {
			TestUtil.enterString(inputFieldName, name);
			return inputFieldName.getText();
		}

	// Validate Input Field Address
	public String validateInputFieldAddress(String address) {
		TestUtil.enterString(inputFieldAddress, address);
		return inputFieldAddress.getText();
	}

	// Validate Input Field City
	public String validateInputFieldCity(String city) {
		TestUtil.enterString(inputFieldCity, city);
		return inputFieldCity.getText();
	}

	// Validate Input Field State
	public String validateInputFieldState(String state) {
		TestUtil.enterString(inputFieldState, state);
		return inputFieldState.getText();
	}

	// Validate Input Field ZipCode
	public String validateInputFieldZipCode(String zipCode) {
		TestUtil.enterString(inputFieldZipCode, zipCode);
		return inputFieldZipCode.getText();
	}

	// Validating Card Type correct selection
	public String validateCardType(String cardType) {
		TestUtil.selectFromDropDown(cardType, dropdownCardType);
		return TestUtil.getSelectedDropDownValue(dropdownCardType);
	}

	// Validate Input Field Credit Card Number
	public String validateInputFieldCreditCardNumber(String creditCardNumber) {
		TestUtil.enterString(inputFieldCreditCardNumber, creditCardNumber);
		return inputFieldCreditCardNumber.getText();
	}

	// Validate Input Field Credit Card Month
	public String validateInputFieldCreditCardMonth(String creditCardMonth) {
		TestUtil.enterString(inputFieldCreditCardMonth, creditCardMonth);
		return inputFieldCreditCardMonth.getText();
	}

	// Validate Input Field CreditCardYear
	public String validateInputFieldCreditCardYear(String creditCardYear) {
		TestUtil.enterString(inputFieldCreditCardYear, creditCardYear);
		return inputFieldCreditCardYear.getText();
	}

	// Validate Input Field Name On Card
	public String validateInputFieldCreditNameOnCard(String nameOnCard) {
		TestUtil.enterString(inputFieldNameOnCard, nameOnCard);
	return inputFieldNameOnCard.getText();
	}

	// Validating Purchase Flight button is clickable
	public ConfirmationPage clickButtonPurchaseFlight() {
		TestUtil.clickElement(buttunPurchaseFlight);
		return new ConfirmationPage();
	}

	// Validating Purchase Flight button redirects to correct url
	public Boolean validatebuttonPurchaseFlight(String ExpectedUrl) {
		return TestUtil.validateCurrentUrl(ExpectedUrl);
	}

}
