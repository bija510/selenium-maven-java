package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S05_Click_Sendkeys_GetText {

	@Test
	public void methodDemo() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
		//driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("John");
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstName.sendKeys("John");
		Thread.sleep(2000);
		firstName.sendKeys(Keys.chord(Keys.CONTROL, "a"), "David"); //This will clear and write David
		
		//driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
		WebElement movieChkBx = driver.findElement(By.xpath("//input[@id='checkbox1']"));
		movieChkBx.click();

		//driver.findElement(By.xpath("//h2[contains(text(),'Register')]")).getText();
		WebElement pageLabel = driver.findElement(By.xpath("//h2[contains(text(),'Register')]"));
		System.out.println("====>"+ pageLabel.getText());
		
		Thread.sleep(3000);
		driver.quit();
		

	}
}
