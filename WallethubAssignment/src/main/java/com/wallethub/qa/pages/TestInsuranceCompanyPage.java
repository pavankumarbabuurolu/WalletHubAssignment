package com.wallethub.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.qa.base.TestBase;

public class TestInsuranceCompanyPage extends TestBase {
	// login btn
	@FindBy(xpath = "//span[contains(text(),'Login')]")
	WebElement login;
	// Review star
	@FindBy(xpath = "//div[@class='rating-box-wrapper' and @style='height: 35px;']//*[@class='rvs-star-svg'][4]")
	WebElement star4;
	// Updated Review
	@FindBy(xpath = "//*[contains(text(),'WalletHubAssignment WalletHubAssignment WalletHubAssignment')]")
	WebElement reviewupdated;

	public TestInsuranceCompanyPage() {
		PageFactory.initElements(driver, this);
	}

	public TestInsuraneceLoginPage testLogin() {
		login.click();
		return new TestInsuraneceLoginPage();
	}

	public TestInsuranceReviewPage clickOnFourthstar() {
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		for (int i = 1; i <= 4; i++) {
			action.moveToElement(driver.findElement(
					By.xpath("//div[@class='rating-box-wrapper' and @style='height: 35px;']//*[@class='rvs-star-svg']["
							+ i + "]")))
					.build().perform();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Action starclick = action.moveToElement(star4).click().build();
		starclick.perform();

		return new TestInsuranceReviewPage();
	}

	public boolean validateUpdatedReview(String txt) {
		return driver.findElement(By.xpath("//*[contains(text(),'" + txt + "')]")).isDisplayed();
	}

}
