package com.wallethub.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		prop = new Properties();
		// Access properties file
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\laxmi\\eclipse-workspace1\\WallethubAssignment\\src"
					+ "\\main\\java\\com\\wallethub\\qa\\configuration\\config.properties");

			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			// disabling chrome notifications
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			// set chrome driver path here
			System.setProperty("webdriver.chrome.driver",
					"C:\\Dev\\Tools\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(ops);
		}

		else if (browserName.equals("IE")) {

			System.setProperty("webdriver.ie.driver",
					":\\Users\\laxmi\\git\\WalletHubAssignment\\WallethubAssignment\\driver\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		// To create reference of TakesScreenshot and Call method to capture screenshot
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		// Copy files to specific location
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
