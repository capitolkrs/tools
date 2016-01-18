package testCases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirstTestCase {

	public static void main(String[] args) {
		// FirefoxDriver driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "/Users/Dev/resources/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.yahoo.com");

	}

}
