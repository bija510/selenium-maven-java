package com.file.upload;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class FileUploadJavaScriptTest extends Base{

    
    @Test
	public void testFileUpload() throws InterruptedException, IOException {
		driver.get("https://pdf2jpg.net/"); 
		Thread.sleep(3000);
		WebElement uploadButton = driver.findElement(By.xpath("//button[@id='advanced_pdf_file']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('type', 'file')", uploadButton);

        // Verify the attribute is added (optional)
        String attributeValue = uploadButton.getAttribute("newAttribute");
        System.out.println("Attribute value: " + attributeValue);

	    String uploadFilePath = System.getProperty("user.dir")+"\\Include\\Upload file.pdf";
	    Thread.sleep(3000);
	    
	    // Send the file path to the input element
	    uploadButton.sendKeys(uploadFilePath);
		
		System.out.println("---Filed uploaded------");
		
		Thread.sleep(4000);
		
	}
}
