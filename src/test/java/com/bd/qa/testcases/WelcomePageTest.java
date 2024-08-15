package com.bd.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bd.qa.base.TestBase;
import com.bd.qa.pages.ReservePage;
import com.bd.qa.pages.WelcomePage;
import com.bd.qa.util.TestUtil;

public class WelcomePageTest extends TestBase {
	WelcomePage welcomepage;
	ReservePage reservePage;
	SoftAssert softAssert = new SoftAssert();
	TestUtil testutil;

	public WelcomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		welcomepage = new WelcomePage();
		reservePage= new ReservePage();
	}

	// Validate that Welcome Page Header is correct
	@Test(priority = 1, enabled = true)
	public void validateWelcomePageHeaderTest() {
		String header = welcomepage.validateWelcomeHeader();
		softAssert.assertEquals(header, prop.getProperty("WelcomeHeader"),"Welcome Page Header is incorrect");
	}

//Validate that correct Departure City is selected
	@Test(priority = 2)
	public void validateDepartureCityTest() {
		String departurecity = welcomepage.validateDepartureCity(prop.getProperty("DepartureCity"));
		softAssert.assertEquals(departurecity, prop.getProperty("DepartureCity"),"Departure City is selected is incorrect");
	}

//Validate that correct Destination City is selected
	@Test(priority = 3)
	public void validateDestinationCityTest() {
		String destinationcity = welcomepage.validateDestinationCity(prop.getProperty("DestinationCity"));
		softAssert.assertEquals(destinationcity, prop.getProperty("DestinationCity"),"Destination City is selected is incorrect");
	}

//Validate that Find Flights button is clickable
	@Test(priority = 4)
	public void validatebuttonFindFlightsTest() {
		// Select DepartureCity
		welcomepage.validateDepartureCity(prop.getProperty("DepartureCity"));
		// Select Destination City
		welcomepage.validateDestinationCity(prop.getProperty("DestinationCity"));
		// Click on Find Flights button
		reservePage=welcomepage.clickButtonFindFlights();
		// Verify Find Flights button redirected to ReservePageUrl
		Boolean flag = welcomepage.validatebuttonFindFlights(prop.getProperty("ReservePageUrl"));
		softAssert.assertTrue(flag,"Find Flights button is clickable");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
