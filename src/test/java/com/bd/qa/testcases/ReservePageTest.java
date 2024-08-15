package com.bd.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bd.qa.base.TestBase;
import com.bd.qa.pages.PurchasePage;
import com.bd.qa.pages.ReservePage;
import com.bd.qa.pages.WelcomePage;
import com.bd.qa.util.TestUtil;

public class ReservePageTest extends TestBase {
	WelcomePage welcomepage;
	ReservePage reservepage;
	PurchasePage purchasePage;
	SoftAssert softAssert = new SoftAssert();
	TestUtil testutil;

	public ReservePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testutil= new TestUtil();
		
		welcomepage = new WelcomePage();
		// Select DepartureCity
		welcomepage.validateDepartureCity(prop.getProperty("DepartureCity"));
		// Select Destination City
		welcomepage.validateDestinationCity(prop.getProperty("DestinationCity"));
		// Click on Find Flights button
		reservepage=welcomepage.clickButtonFindFlights();
		purchasePage=new PurchasePage();
	}
	// Actions

	// Validate that Reserve Page Header is correct

	@Test(priority = 1, enabled = true)
	public void validateReservePageHeaderTest() {
		String header = reservepage.validateReservePageHeader();
		softAssert.assertEquals(header, prop.getProperty("ReserveHeader"),"Reserve Page Header is incorrect");
	}

	// Validate that Choose This Flight button is clickable
	@Test(priority = 2)
	public void validatebuttonFindFlightsTest() {
		// Click on Choose This Flights button
		purchasePage=reservepage.clickButtonChooseThisFlights(prop.getProperty("FlightNumber"));
		// Verify Choose This Flight button redirected to Purchase Page url
		Boolean flag = reservepage.validatebuttonChooseThisFlight(prop.getProperty("PurchasePageUrl"));
		softAssert.assertTrue(flag,"Choose This Fligh button is not clickable");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
