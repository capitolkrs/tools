package helper;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;

public class LinkHelper extends StartWebDriver{
	
	public static void clickLink(String linkText){
		if(driver.findElements(By.id(linkText)).size()==1){
			driver.findElement(By.id(linkText)).click();
		}
		else if(driver.findElements(By.partialLinkText(linkText)).size()==1){
			driver.findElement(By.partialLinkText(linkText)).click();
		}
		else if(driver.findElements(By.name(linkText)).size()==1){
			driver.findElement(By.name(linkText)).click();
		}
		else if(driver.findElements(By.linkText(linkText)).size()==1){
			driver.findElement(By.linkText(linkText)).click();
		}
		else if(driver.findElements(By.xpath(linkText)).size()==1){
			driver.findElement(By.xpath(linkText)).click();
		}
		else if(driver.findElements(By.cssSelector(linkText)).size()==1){
			driver.findElement(By.cssSelector(linkText)).click();
		}else
		throw new NoSuchElementException("Your Link text not found");
	}

}
