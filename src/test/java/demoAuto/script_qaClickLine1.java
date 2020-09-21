package demoAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class script_qaClickLine1 extends Base {

	public void openURL() {
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
	}
	
	public void clickAnyCheckbox(String chkNum) {
		//WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='checkBoxOption".concat(chkNum).concat("']")));
		WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='checkBoxOption"+ chkNum+"']")); 
	    checkbox1.click();                                 
	}
		
	@Test
	public void test_radioButton() throws InterruptedException  {
		//driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		openURL();
		String actualTitle = "Practice Page";
		String expTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expTitle);
		
		WebElement radioButton1 = driver.findElement(By.xpath("//div[@id='radio-btn-example']//label[1]//input[1]"));
		radioButton1.click();
		Thread.sleep(2000);
	
		WebElement radioButton2 = driver.findElement(By.xpath("//div[@id='radio-btn-example']//label[2]//input[1]"));
		radioButton2.click();
		Thread.sleep(2000);
		
		WebElement radioButton3 = driver.findElement(By.xpath("//div[@id='radio-btn-example']//label[3]//input[1]"));
		radioButton3.click();
		Thread.sleep(2000);
	}
	
		@Test
		public void test_autoSuggest() throws InterruptedException {
			//driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
			openURL();
			WebElement autoSuggestTextBox = driver.findElement(By.xpath("//input[@id='autocomplete']"));
			autoSuggestTextBox.sendKeys("nep");
			autoSuggestTextBox.sendKeys(Keys.ARROW_DOWN);
			autoSuggestTextBox.sendKeys(Keys.ENTER);
						
		}
		@Test
		public void test_dropdown() throws InterruptedException {
		openURL();	
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
	    @Test
		public void checkbox() {
	    openURL();
	    clickAnyCheckbox("1");
	    clickAnyCheckbox("2");
	    clickAnyCheckbox("3");
	    
		/*
		 * WebElement checkbox1 =driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
		 * checkbox1.click();
		 * WebElement checkbox2 =driver.findElement(By.xpath("//input[@id='checkBoxOption2']"));
		 * checkbox2.click();
		 * WebElement checkbox3 =driver.findElement(By.xpath("//input[@id='checkBoxOption3']"));
		 * checkbox3.click();
		 */    
		}
		
		
		
	
	
	
	
	
	
	
	
	
	
}
