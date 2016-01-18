package testCases;

import helper.ButtonHelper;
import helper.GenericHelper;
import helper.LinkHelper;
import helper.ReadConfigProperty;
import helper.StartWebDriver;
import helper.TextBoxHelper;
import junit.framework.Assert;

import org.testng.annotations.Test;

public class TestFrameWork extends StartWebDriver{

	@Test
	public void testFrame() throws InterruptedException  {

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		TextBoxHelper.typeInTextBox("q","selenium");
		Thread.sleep(3000);
		ButtonHelper.clickButton("btnG");
		GenericHelper.takeScreenShot(this.getClass().toString());
		

	}

}


