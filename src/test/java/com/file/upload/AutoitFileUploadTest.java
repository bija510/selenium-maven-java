package com.file.upload;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class AutoitFileUploadTest extends Base{

	/**
	  Setup Note: 
	 1. Need to install Autoit3
	 2. Go to C:\Program Files (x86)\AutoIt3\SciTE\SciTE.exe 
	 3. Open SciTE.exe file, it will lunch editer
	 4. Write this script in the editer and save as autoit.au3
	 
	 ---------For CHROME & EDGE---------- Open window by chrome & edge Window title is open that why?
	    ControlFocus("Open", "", "Edit1")
		ControlSetText("Open", "", "Edit1", "C:\Users\Bijaya Chhetri\eclipse-workspace\selenium-maven-java\Include\Upload file.pdf")
		ControlClick("Open", "", "Button1")
		
	 ---------For FIREFOX---------- Replace with [" Open "] with [" File Upload "]
	 Open window by firefox Window title is FIle Upload that why?
	 
	 4. Open the Autoit folder and Right click the autoit.au3 file ==> click Compile Script (x64)
	 5. It will create the autoit.exe file, which we run from the script
	 */
	@Test
	public void autoItFileUpload() throws InterruptedException, IOException {
		driver.get("http://demo.automationtesting.in/FileUpload.html"); 
		
		WebElement fileUpload = driver.findElement(By.xpath("//div[@class='btn btn-primary btn-file']"));
		fileUpload.click();
		Runtime.getRuntime().exec("../selenium-maven-java/Autoit/autoit.exe");
	
		
	}

}
