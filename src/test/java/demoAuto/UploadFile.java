package demoAuto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UploadFile extends Base {

	@Test
	public void uploadTest() throws InterruptedException {
	    //Just a comment
		driver.navigate().to("http://demo.automationtesting.in/FileUpload.html");        
        String uploadFilePath = System.getProperty("user.dir")+"\\Include\\Upload file.pdf";

        WebElement uploadPath = driver.findElement(By.xpath("//*[@id=\"input-4\"]"));
        uploadPath.sendKeys(uploadFilePath);
        
        
	}
}
