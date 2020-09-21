package Temp;

import org.apache.tools.ant.taskdefs.War;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import demoAuto.Base;


public class p3waltmart extends Base {

	String act_TestValidationTitle = ""; //Global Variable
	String expt_TestValidationTitle = "";
	
	public void click3LineMenu() {
		WebElement threeLineMenuBtn = driver.findElement(By.xpath("//button[@id='header-Header-sparkButton']//img"));
		threeLineMenuBtn.click();
	}
	
	public void openWalmart() {
		driver.get("https://www.walmart.com/");
	}
	
	@Test(priority =3)
	public void test_verifyFanSearch() throws InterruptedException  {
		openWalmart();
		WebElement serchTxtBx =	driver.findElement(By.xpath("//input[@id='global-search-input']"));
		serchTxtBx.sendKeys("fan");	
		serchTxtBx.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		 act_TestValidationTitle = "fan - Walmart.com";
		 expt_TestValidationTitle = driver.getTitle();
		Assert.assertEquals(act_TestValidationTitle, expt_TestValidationTitle);
	}
	
	
	@Test(priority = 2)
	public void test_verifyTrackOder() throws InterruptedException {
		openWalmart();
		click3LineMenu();
		WebElement trackOderBtn = driver.findElement(By.xpath("//div[@class='o_a o_o bm_b']//a[1]"));
		trackOderBtn.click();
		Thread.sleep(3000);
		 act_TestValidationTitle = "Account";
		 expt_TestValidationTitle = driver.getTitle();
		Assert.assertEquals(act_TestValidationTitle, expt_TestValidationTitle);
				
	}
	
	@Test(priority =1 )
	public void test_verifyReorder() throws InterruptedException {
		openWalmart();
		click3LineMenu();
		WebElement reorderBtn = driver.findElement(By.xpath("//div[@id='header-spark-menu-content']//a[2]//div[1]//img[1]"));
		reorderBtn.click();
		Thread.sleep(3000);
		act_TestValidationTitle = "Easy Reorder - Walmart.com";
		expt_TestValidationTitle = driver.getTitle();
		Assert.assertEquals(act_TestValidationTitle, expt_TestValidationTitle);	
		
	}
	
	
	@Test
	public void test_verifyMyList() throws InterruptedException {
		openWalmart();
		click3LineMenu();
		WebElement listButton = driver.findElement(By.xpath("//div[@class='o_a o_o bm_b']//a[3]"));
		listButton.click();
		Thread.sleep(3000);
		act_TestValidationTitle = "My Lists";
		act_TestValidationTitle = driver.getTitle();
		Assert.assertEquals(act_TestValidationTitle, act_TestValidationTitle);

	}
	@Test
	public void test_verifyWalmartPlus() throws InterruptedException {
		openWalmart();
		click3LineMenu();
		WebElement walmartPlusBtn = driver.findElement(By.xpath("//div[@class='w_a w_i'][contains(text(),'Walmart+')]"));
		walmartPlusBtn.click();
		Thread.sleep(3000);
		act_TestValidationTitle = "Free 15-Day Trial | Walmart+ membership";
		act_TestValidationTitle = driver.getTitle();
		System.out.println(act_TestValidationTitle);
		Assert.assertEquals(act_TestValidationTitle, act_TestValidationTitle);
		
		
		
		
		
	}
	
	
	
	
	
	
	
}