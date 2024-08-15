package com.bd.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bd.qa.base.TestBase;

public class ConfirmationPage extends TestBase{
	@FindBy(xpath="//h1[text ()='Thank you for your purchase today!']")
	WebElement textThankYouHeader;
	@FindBy(xpath="//td[text()='Status']/following-sibling::td[text()='PendingCapture']")
	WebElement textStatusPendingCapture;
	
	// Page factory Initialization
		public ConfirmationPage() {
			PageFactory.initElements(driver, this);
		}
		//Actions
		// Validate the Confirmation Header Name
		public String validateConfirmationPageHeader() {
			return textThankYouHeader.getText();
		}
		// Validate the Status
		public String validateStatus() {
					return textStatusPendingCapture.getText();
				}
		
		
}
