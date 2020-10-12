package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilites_library.Base;

public class S06_DropdownList_DDL extends Base{
	@Test
	public void test_dropdown() throws InterruptedException {
	driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
	WebElement DDL = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
	Select selectDDL = new Select(DDL);
	//selectDDL.selectByVisibleText("Option2");
	selectDDL.selectByIndex(2);
	Thread.sleep(2000);
		
	//selectDDL.selectByVisibleText("Option1");
	selectDDL.selectByIndex(1);
	Thread.sleep(2000);
	
	//selectDDL.selectByVisibleText("Option3");
	selectDDL.selectByIndex(3);
	Thread.sleep(2000);
		
	}
}
