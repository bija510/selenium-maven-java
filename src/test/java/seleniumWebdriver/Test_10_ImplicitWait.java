package seleniumWebdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utilites_library.Base;

public class Test_10_ImplicitWait extends Base{

	@Test
	public void ImpliWait() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //used only if needed-->soft wait	
		driver.get("http://demo.automationtesting.in/Register.html");
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Thread.sleep(2000); //always wait upto --->hard wait		
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("subi");

	}

}
