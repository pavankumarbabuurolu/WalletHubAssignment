package com.wallethub.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.qa.base.TestBase;

public class FacebookLoginPage extends TestBase {
	// Email text box
	@FindBy(xpath = "//input[contains(@id,'email')]")
	WebElement email;
	// Password text box
	@FindBy(xpath = "//input[@id='pass']")
	WebElement password;
	// login btn
	@FindBy(css = "button[name='login']")
	WebElement login;

	public FacebookLoginPage() {

		PageFactory.initElements(driver, this);

	}

	public String validateLoginPageTitle() {

		return driver.getTitle();
	}

	public HomePage Login(String username, String pass) {

		email.sendKeys(username);
		password.sendKeys(pass);
		login.click();
		return new HomePage();
	}

}
