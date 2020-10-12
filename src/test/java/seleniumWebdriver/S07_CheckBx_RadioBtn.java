package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_CheckBx_RadioBtn {

	@Test
	public void CheckBxAndRadioBtn() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("http://demo.automationtesting.in/Register.html");
	
	//driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
	WebElement movieChkBx = driver.findElement(By.xpath("//input[@id='checkbox1']"));
	movieChkBx.click();
		
	//driver.findElement(By.xpath("//input[@value='Male']")).click();
	WebElement maleRadBtn = driver.findElement(By.xpath("//input[@value='Male']"));
	maleRadBtn.click();

	
	Thread.sleep(3000);
	driver.quit();
	

}
}
