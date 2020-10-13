package seleniumWebdriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import utilites_library.Base;

public class S21_Screenshot extends Base{

	@Test
	public void screeenShottDemo() throws IOException {
		
		driver.get("http://demo.automationtesting.in/Register.html");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("../Maven_Seleniums/Screenshot/"+ "DemoScreenShot" +".png"));
	}
}
