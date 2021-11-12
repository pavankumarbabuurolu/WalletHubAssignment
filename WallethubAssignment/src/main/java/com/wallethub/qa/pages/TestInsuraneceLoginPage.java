package com.wallethub.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.qa.base.TestBase;

public class TestInsuraneceLoginPage extends TestBase {
	// Email text box
	@FindBy(xpath = "//input[@name='em']")
	WebElement email;

	// Password text box
	@FindBy(xpath = "//input[@name='pw']")
	WebElement password;
	// login btn
	@FindBy(xpath = "//span[contains(text(),'Login')]")
	WebElement login;

	public TestInsuraneceLoginPage() {
		PageFactory.initElements(driver, this);
	}

	public TestInsuranceCompanyPage testInsuranceLogin(String usr, String pas) {

		email.sendKeys(usr);
		password.sendKeys(pas);
		login.click();
		return new TestInsuranceCompanyPage();
	}

}
