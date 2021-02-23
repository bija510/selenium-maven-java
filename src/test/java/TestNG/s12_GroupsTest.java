package TestNG;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class s12_GroupsTest extends aBase{

	
	@Test(groups = "Smoke")
	public void Method1() {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("David");
	}
	
	@Test(groups = "Smoke")
	public void Method2() {
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Johnson");
	}
	
	@Test(groups = "Regression")
	public void Method3() {
		driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
	}
	
	@Test(groups = "Regression")
	public void Method4() {
		driver.findElement(By.xpath("//input[@value='Male']")).click();
	}
	
}
