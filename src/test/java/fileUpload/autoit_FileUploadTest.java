package fileUpload;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import demoAuto.Base;

public class autoit_FileUploadTest extends Base{

	@Test
	public void autoItFileUpload() throws InterruptedException, IOException {
		driver.get("http://demo.automationtesting.in/FileUpload.html"); 
		
		WebElement fileUpload = driver.findElement(By.xpath("//div[@class='btn btn-primary btn-file']"));
		fileUpload.click();
		Runtime.getRuntime().exec("../Maven_Seleniums/Autoit/autoit.exe");
	
		
	}

}
