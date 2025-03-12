package com.selenium.webbrowser.v3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class Test21Screenshot extends Base{

/*********************************************************************************************************************************************
===================Screenshot using Chrome DevTools=======================
Screenshot without any browser extension of full-page,any specific node or any area using Dev tools in Chrome?
1. Open a Chrome browser.
2. Open Dev Tools (Press F12).
3. Press CTRL+SHIFT+P (in windows) or cmd+SHIFT+P (in mac).
4. Type �screenshot� into the Command Menu and you will see options like �Capture area screenshot�, �Capture full-size screenshot�,..etc
5. Select your desired option and hit enter. Done�
If you wish to, you can also emulate a device mode first and then take the screenshot- this way it will capture as per the device dimensions.
handy when you want to take the screenshot of the entire page on any device like iPhone X?
*********************************************************************************************************************************************/
	@Test
	public void screeenShottDemo() throws IOException {
		
		driver.get("http://demo.automationtesting.in/Register.html");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("../Maven_Seleniums/Screenshot/"+ "DemoScreenShot" +".png"));
	}
}
