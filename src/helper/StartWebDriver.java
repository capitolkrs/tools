package helper;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class StartWebDriver {

	public static WebDriver driver = null;

	@BeforeSuite
	public void setUp() {
		ReadConfigProperty file = new ReadConfigProperty();
		
	//get Browser
		
			//FireFox
		if ("firefox".equalsIgnoreCase(file.getBrowser())) {
			driver = new FirefoxDriver();
			
			//Chrome
		} else if ("chrome".equalsIgnoreCase(file.getBrowser())) {
			System.setProperty("webdriver.chrome.driver", StartWebDriver.class
					.getClassLoader().getResource("/resources/chromedriver")
					.getPath());
			driver = new ChromeDriver();
			
			//HtmlUnitDriver
		} else {
			driver = new HtmlUnitDriver();
		}
		
		
	//get url
		
		driver.get(file.getUrl());
		
		

	}
	
	public static WebElement getElement(String locator){
		
		if(driver.findElements(By.id(locator)).size()==1){
			return driver.findElement(By.id(locator));
		}else if(driver.findElements(By.className(locator)).size()==1){
			return driver.findElement(By.className(locator));
		}else if (driver.findElements(By.name(locator)).size()==1){
			return driver.findElement(By.name(locator));
		}else if (driver.findElements(By.xpath(locator)).size()==1){
			return driver.findElement(By.xpath(locator));
		}else if(driver.findElements(By.cssSelector(locator)).size()==1){
			return driver.findElement(By.cssSelector(locator));
		}else 
			throw new NoSuchElementException("No such Element: "+locator);
		
		
	}
	
	@AfterSuite
	public void tearDown(){
		try {
			driver.close();
			driver.quit();
			if(driver !=null)
				driver=null;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
