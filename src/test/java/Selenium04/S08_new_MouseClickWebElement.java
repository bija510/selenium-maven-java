package Selenium04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utilites_library.Base;

public class S08_new_MouseClickWebElement extends Base {

	@Test
	public void MouseclickWebELement() throws InterruptedException {

		/**********************************************************************************
		 1. click(WebElement) == is a replacement of== moveToElement(onElement).click() method.
		 2. doubleClick(WebElement) == is a replacement of== moveToElement(element).doubleClick() 
		 3. contextClick(WebElement)== is a replacement of== moveToElement(onElement).contextClick()
		 4. clickAndHold(WebElement) == is a replacement of== moveToElement(Element).clickAndHold()
		 5. release() method, which is used for releasing the pressed mouse button,
		  has been a part of the org.openqa.selenium.interactions.ButtonReleaseAction class. In Selenium 4,
		 **********************************************************************************/
		driver.navigate().to("https://www.amazon.in/");

		Actions action = new Actions(driver);
		WebElement elementToType = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		action.sendKeys(elementToType, "iphone").build().perform();
		WebElement elementToClick = driver.findElement(By.xpath("//input[@value='Go']"));
		Thread.sleep(3000);
		
		//action.moveToElement(elementToClick).click().build().perform(); // Selenium-3
		action.click(elementToClick).build().perform(); //moveToElement got Removed in Selenium-4 
		System.exit(0);

	}
}
