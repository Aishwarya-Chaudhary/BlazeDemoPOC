package com.bd.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bd.qa.base.TestBase;
import com.bd.qa.pages.ConfirmationPage;
import com.bd.qa.pages.PurchasePage;
import com.bd.qa.pages.ReservePage;
import com.bd.qa.pages.WelcomePage;
import com.bd.qa.util.TestUtil;

public class PurchasePageTest extends TestBase {
	WelcomePage welcomepage;
	ReservePage reservepage;
	PurchasePage purchasepage;
	SoftAssert softAssert = new SoftAssert();
	ConfirmationPage confirmationPage;
	TestUtil testutil;

	public PurchasePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		welcomepage = new WelcomePage();
		// Select DepartureCity
		welcomepage.validateDepartureCity(prop.getProperty("DepartureCity"));
		// Select Destination City
		welcomepage.validateDestinationCity(prop.getProperty("DestinationCity"));
		// Click on Find Flights button
		reservepage = welcomepage.clickButtonFindFlights();
		// Click on Choose this flight button
		purchasepage = reservepage.clickButtonChooseThisFlights(prop.getProperty("FlightNumber"));
		confirmationPage = new ConfirmationPage();
		testutil = new TestUtil();

	}

	// Actions
	// Validate that Purchase Page Header is correct
	@Test(priority = 1, enabled = true)
	public void validatePurchasePageHeaderTest() {
		String header = purchasepage.validatePurchasePageHeader();
		softAssert.assertEquals(header, prop.getProperty("PurchaseHeader"), "Purchase Page Header is incorrect");
	}

// Validate that Purchase Flight button is clickable after filling details for all 10 fields
	@Test(priority = 2)
	public void validatebuttonPurchaseFlightTest() {

		// Validate that Purchase Page Name is correctly entered
		String name = purchasepage.validateInputFieldName(prop.getProperty("Name"));
		softAssert.assertEquals(name, prop.getProperty("Name"), "Name is incorrect");

		// Validate that Purchase Page Address is correctly entered
		String address = purchasepage.validateInputFieldAddress(prop.getProperty("Address"));
		softAssert.assertEquals(address, prop.getProperty("Address"), "Address is incorrect");

		// Validate that Purchase Page City is correctly entered
		String city = purchasepage.validateInputFieldCity(prop.getProperty("City"));
		softAssert.assertEquals(city, prop.getProperty("City"), "City is incorrect");

		// Validate that Purchase Page State is correctly entered

		String state = purchasepage.validateInputFieldState(prop.getProperty("State"));
		softAssert.assertEquals(state, prop.getProperty("State"), "State is incorrect");

		// Validate that Purchase Page ZipCode is correctly entered

		String zipCode = purchasepage.validateInputFieldZipCode(prop.getProperty("ZipCode"));
		softAssert.assertEquals(zipCode, prop.getProperty("ZipCode"), "ZipCode is incorrect");

		// Validate that Purchase Page Card Type is correctly entered

		String cardType = purchasepage.validateCardType(prop.getProperty("CardType"));
		softAssert.assertEquals(cardType, prop.getProperty("CardType"), "Card Type is incorrect");

		// Validate that Purchase Page Credit Card Number is correctly entered

		String creditCardNumber = purchasepage.validateInputFieldCreditCardNumber(prop.getProperty("CreditCardNumber"));
		softAssert.assertEquals(creditCardNumber, prop.getProperty("CreditCardNumber"),
				"Credit Card Number is incorrect");

		// Validate that Purchase Page Credit Card Month is correctly entered

		String creditCardMonth = purchasepage.validateInputFieldCreditCardMonth(prop.getProperty("CreditCardMonth"));
		softAssert.assertEquals(creditCardMonth, prop.getProperty("CreditCardMonth"), "credit Card Month is incorrect");

		// Validate that Purchase Page Credit Card Year is correctly entered

		String creditCardYear = purchasepage.validateInputFieldCreditCardYear(prop.getProperty("CreditCardYear"));
		softAssert.assertEquals(creditCardYear, prop.getProperty("CreditCardYear"), "Credit Card Year is incorrect");

		// Validate that Purchase Page Name On Card is correctly entered

		String nameOnCard = purchasepage.validateInputFieldCreditNameOnCard(prop.getProperty("NameOnCard"));
		softAssert.assertEquals(nameOnCard, prop.getProperty("NameOnCard"), "Name On Card is incorrect");

		// Click on Purchase Flight button
		confirmationPage = purchasepage.clickButtonPurchaseFlight();
		// Verify Purchase Flight button redirected to ReservePageUrl
		Boolean flag = purchasepage.validatebuttonPurchaseFlight(prop.getProperty("ConfirmationPageUrl"));
		softAssert.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
