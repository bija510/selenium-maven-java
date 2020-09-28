package demoAuto;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class autoitFileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/FileUpload.html"); 

		WebElement fileUpload = driver.findElement(By.xpath("//div[@class='btn btn-primary btn-file']"));
		fileUpload.click();
		Runtime.getRuntime().exec("../Maven_Seleniums/Autoit/autoit.exe");
	
		
	}

}
