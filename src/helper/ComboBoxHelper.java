package helper;

import org.openqa.selenium.support.ui.Select;

public class ComboBoxHelper extends StartWebDriver {
	private static Select sel=null;
	
	public static void selectElement(String locator, int index){
		sel=new Select(getElement(locator));
		sel.selectByIndex(index);
		
	}
	public static void selectElement(String locator,String value){
		sel=new Select(getElement(locator));
		sel.selectByValue(value);
	}
	

	
	public static void selectByvisibleText(String locator,String visibleText){
		sel=new Select(getElement(locator));
		sel.selectByVisibleText(visibleText);
	}
	
}
