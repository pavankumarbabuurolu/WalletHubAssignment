package com.wallethub.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wallethub.qa.base.TestBase;

public class HomePage extends TestBase {
	// Menu icon
	@FindBy(xpath = "//div[@class='bx45vsiw']//div[@role='button']")
	WebElement menu;
	// Post Icon
	@FindBy(xpath = "//i[@class='hu5pjgll lzf7d6o1']//preceding::div//following::div[1]//span[text()='Post']")
	WebElement post;
	// Create post text field
	@FindBy(xpath = "//div[@class='_1mf _1mj']")
	WebElement createpost;
	// post btn
	@FindBy(xpath = "//span[text()='Post']")
	WebElement postbutton;

	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public void PostStatus() {
		menu.click();
		WebDriverWait wait = new WebDriverWait(driver, 70);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//i[@class='hu5pjgll lzf7d6o1']//preceding::div//following::div[1]//span[text()='Post']")));
		post.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_1mf _1mj']")));
		createpost.sendKeys("Hello World");
		postbutton.click();

	}
}
