package com.wallethub.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.qa.base.TestBase;

public class TestInsuranceReviewconfirmationPage extends TestBase {
	// Text field
	@FindBy(xpath = "//div[contains(@class,'rvc-header')]//h4")
	WebElement confirmMessage;
	// Continue btn
	@FindBy(xpath = "//*[@class='btn rvc-continue-btn' and text()='Continue']")
	WebElement continuebtn;

	public TestInsuranceReviewconfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateConfirmationMessage() {

		return confirmMessage.getText();

	}

	public TestInsuranceCompanyPage reviewContinue() {
		continuebtn.click();
		return new TestInsuranceCompanyPage();

	}

}
