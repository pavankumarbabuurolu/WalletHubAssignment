package com.wallethub.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wallethub.qa.base.TestBase;
import com.wallethub.qa.pages.TestInsuranceCompanyPage;
import com.wallethub.qa.pages.TestInsuranceReviewPage;
import com.wallethub.qa.pages.TestInsuranceReviewconfirmationPage;
import com.wallethub.qa.pages.TestInsuraneceLoginPage;

public class TestInsuranceReview extends TestBase {

	TestInsuranceCompanyPage TestInsuranceCompany;
	TestInsuraneceLoginPage TestInsuranceLogin;
	TestInsuranceReviewPage ReviewPage;
	TestInsuranceReviewconfirmationPage ConfirmationPage;

	public TestInsuranceReview() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("url"));
		TestInsuranceCompany = new TestInsuranceCompanyPage();

	}

	@Test(priority = 1)
	public void writeReview() {
		TestInsuranceLogin = TestInsuranceCompany.testLogin();
		// Provide usernamewallet and passwordwallet fields values in config.properties
		// file
		TestInsuranceLogin.testInsuranceLogin(prop.getProperty("usernamewallet"), prop.getProperty("passwordwallet"));
		ReviewPage = TestInsuranceCompany.clickOnFourthstar();
		// Provide review messsage in config.properties file
		ConfirmationPage = ReviewPage.review(prop.getProperty("review"));
		Assert.assertEquals(ConfirmationPage.validateConfirmationMessage(), "Your review has been posted.");
		ConfirmationPage.reviewContinue();
		Assert.assertTrue(TestInsuranceCompany.validateUpdatedReview(prop.getProperty("review")));

	}

	@Test(priority = 2)
	public void verifyReview() {

		Assert.assertTrue(TestInsuranceCompany.validateUpdatedReview(prop.getProperty("review")));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
