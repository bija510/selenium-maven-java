package com.file.upload;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class SendKeysFileUploadTest extends Base{

	@Test
	public void FileUpload() throws InterruptedException {	
		driver.navigate().to("http://demo.automationtesting.in/FileUpload.html");
		
        String uploadFilePath = System.getProperty("user.dir")+"\\Include\\Upload file.pdf";
        driver.findElement(By.xpath("//*[@id=\"input-4\"]")).sendKeys(uploadFilePath);        
        Thread.sleep(2000);
              
        
	}

}
