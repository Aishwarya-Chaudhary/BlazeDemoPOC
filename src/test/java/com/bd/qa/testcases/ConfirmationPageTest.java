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

public class ConfirmationPageTest extends TestBase {

	WelcomePage welcomepage;
	ReservePage reservepage;
	PurchasePage purchasepage;
	SoftAssert softAssert = new SoftAssert();
	ConfirmationPage confirmationPage;

	public ConfirmationPageTest() {
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
		
		reservepage=new ReservePage();
		// Click on Find Flights button
		reservepage = welcomepage.clickButtonFindFlights();
		
		purchasepage=new PurchasePage();
		// Click on Choose this flight button
		purchasepage = reservepage.clickButtonChooseThisFlights(prop.getProperty("FlightNumber"));
		// Enter Name
		purchasepage.validateInputFieldName(prop.getProperty("Name"));
		// Enter Address
		purchasepage.validateInputFieldAddress(prop.getProperty("Address"));
		// Enter City
		purchasepage.validateInputFieldCity(prop.getProperty("City"));
		// Enter State
		purchasepage.validateInputFieldState(prop.getProperty("State"));
		// Enter ZipCode
		purchasepage.validateInputFieldZipCode(prop.getProperty("ZipCode"));
		// Enter CardType
		purchasepage.validateCardType(prop.getProperty("CardType"));
		// Enter CreditCardNumber
		purchasepage.validateInputFieldCreditCardNumber(prop.getProperty("CreditCardNumber"));
		// Enter CreditCardMonth
		purchasepage.validateInputFieldCreditCardMonth(prop.getProperty("CreditCardMonth"));
       //Enter CreditCardYear
		purchasepage.validateInputFieldCreditCardYear(prop.getProperty("CreditCardYear"));
        //Enter NameOnCard
		purchasepage.validateInputFieldCreditNameOnCard(prop.getProperty("NameOnCard"));
		
		confirmationPage = new ConfirmationPage();
		//Click on PurchaseFligh
		confirmationPage=purchasepage.clickButtonPurchaseFlight();

	}

	// Actions
	// Validate that Purchase Page Header is correct
	@Test(priority = 1, enabled = true)
	public void validateConfirmationPageHeaderTest() {
		String header = confirmationPage.validateConfirmationPageHeader();
		softAssert.assertEquals(header, prop.getProperty("ConfirmationHeader"),
				"Confirmation Page Header is incorrect");
	}

	// Validate that Status is correct
	@Test(priority = 2, enabled = true)
	public void validateStatusTest() {
		String status = confirmationPage.validateStatus();
		softAssert.assertEquals(status, prop.getProperty("Status"), "Status is incorrect");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
