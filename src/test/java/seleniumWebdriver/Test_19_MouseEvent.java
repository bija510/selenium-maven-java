package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utilites_library.Base;

public class Test_19_MouseEvent extends Base {

	@Test
	public void doubleClick() throws InterruptedException {
		driver.get("http://api.jquery.com/dblclick/");

		driver.switchTo().frame(0);
		WebElement aaa = driver.findElement(By.xpath("/html/body/div"));
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.doubleClick(aaa).build().perform();
		Thread.sleep(3000);
		act.doubleClick(aaa).build().perform();	
	}
	
	@Test
	public void slider() throws InterruptedException {
		driver.get("https://jqueryui.com/slider/");
		
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement slider=driver.findElement(By.xpath("//div[@id='slider']//span"));
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		act.moveToElement(slider).dragAndDropBy(slider, 900, 0).build().perform();
	
	}
	
	@Test
	public void dragAndDrop() throws InterruptedException {
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		WebElement sourceElement = driver.findElement(By.id("box6"));
		WebElement targetElement = driver.findElement(By.id("box106"));
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.dragAndDrop(sourceElement, targetElement).build().perform();
	     
	}
	
	@Test
	public void mouseHovering() {
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();

		WebElement Admin=driver.findElement(By.xpath("//b[contains(text(),'Admin')]"));		
		WebElement usermgt=driver.findElement(By.xpath("//a[contains(text(),'User Management')]"));		
		WebElement users=driver.findElement(By.xpath("//a[contains(text(),'Users')]"));
				
		Actions act=new Actions(driver);
		act.moveToElement(Admin).moveToElement(usermgt).moveToElement(users).click().build().perform();
	}
	
	@Test
	public void moveToElement() throws InterruptedException {
		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submitbtn']"));
		Thread.sleep(2000);
		new Actions(driver).moveToElement(submitBtn).perform();
		//submitBtn.click();
		Thread.sleep(2000);
	}
	
	@Test
	public void seriesOfAction() {
		driver.get("https://www.facebook.com/login/");
		WebElement txtUsername = driver.findElement(By.xpath("//input[@id='email']"));

		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(txtUsername)
			.click()
			.keyDown(txtUsername, Keys.SHIFT)
			.sendKeys(txtUsername, "hello")
			.keyUp(txtUsername, Keys.SHIFT)
			.doubleClick(txtUsername)
			.contextClick()
			.build();
			
		seriesOfActions.perform() ;
		
	}
}
