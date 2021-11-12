package com.wallethub.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wallethub.qa.base.TestBase;
import com.wallethub.qa.pages.FacebookLoginPage;
import com.wallethub.qa.pages.HomePage;

public class HomePageTest extends TestBase {

	FacebookLoginPage facebookloginpage;
	HomePage homepage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		driver.get(prop.getProperty("url1"));
		facebookloginpage = new FacebookLoginPage();
		Assert.assertEquals(facebookloginpage.validateLoginPageTitle(), "Facebook – log in or sign up");
		// Provide username and password fields values in config.properties file
		homepage = facebookloginpage.Login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@Test
	public void PostStatusmess() {
		
		homepage.PostStatus();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
