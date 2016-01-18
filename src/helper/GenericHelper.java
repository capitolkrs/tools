package helper;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class GenericHelper extends StartWebDriver{

	
	public static void takeScreenShot(String fileName){
		try {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//use Java File util class to copy the screen shoot from memory to a file
			FileUtils.copyFile(src, new File("/screenshot/"+fileName+"myScreen.jpg"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
