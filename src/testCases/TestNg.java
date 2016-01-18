package testCases;

import helper.ReadConfigProperty;
import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNg {

	private static WebDriver driver = null;

	@BeforeClass
	public static void startWebDriver() {

		ProfilesIni prof = new ProfilesIni();
		FirefoxProfile profile = prof.getProfile("default");
		// setting firefox preferences here or by goint to ff browser and typing
		// about:config
		
		
		profile.setPreference("browser.startup.homepage", "homedepot.com");
		// driver=new FirefoxDriver(profile);

		System.setProperty("webdriver.chrome.driver",
				"/Users/Dev/resources/chromedriver");
		ChromeOptions opt = new ChromeOptions();
		

		//driver = new ChromeDriver(opt);
		driver=new HtmlUnitDriver();

	}

	@Test
	public void testCase() {
		driver.get("http://www.homedepot.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals("http://www.homedepot.com/", driver.getCurrentUrl());
		
		ReadConfigProperty config=new ReadConfigProperty();
		System.out.println("the url is "+ config.getBrowser());
		System.out.println(config.getUrl());
		System.out.println(config.getUserName());
		System.out.println(config.getPassword());
		System.out.println("test completed");
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close(); // close the browser currently in focus
		driver.quit(); // close all the browser instance and stop webdriver
						// gracefully
	}

	@AfterClass
	public static void stopWebDriver() {
		if (driver != null)
			driver = null;
	}

}
