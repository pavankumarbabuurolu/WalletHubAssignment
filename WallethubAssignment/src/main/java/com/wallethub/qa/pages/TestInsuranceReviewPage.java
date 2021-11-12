package com.wallethub.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wallethub.qa.base.TestBase;

public class TestInsuranceReviewPage extends TestBase {
	// dropdown
	@FindBy(xpath = "//*[contains(@class,'dropdown second')]")
	WebElement dropdown;
	// dropdown value
	@FindBy(xpath = "//*[contains(@class,'dropdown second')]//ul//li[text()='Health Insurance']")
	WebElement dropdown1;
	// review text field
	@FindBy(xpath = "//*[@class='android']//textarea")
	WebElement writereview;
	// submit btn
	@FindBy(xpath = "//*[text()='Submit']")
	WebElement submit;

	public TestInsuranceReviewPage() {

		PageFactory.initElements(driver, this);

	}

	public TestInsuranceReviewconfirmationPage review(String msg) {

		dropdown.click();
		dropdown1.click();
		writereview.click();
		writereview.sendKeys(msg);
		submit.click();

		return new TestInsuranceReviewconfirmationPage();
	}

}
