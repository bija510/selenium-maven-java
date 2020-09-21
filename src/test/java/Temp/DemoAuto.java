package Temp;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import demoAuto.Base;

public class DemoAuto extends Base {
	public void openURL() {
		driver.get("http://demo.automationtesting.in/Register.html");
	}
	public void selectAnyDDLText(String css,String visibleText ) throws InterruptedException {
		openURL();	
		WebElement selectDDL = driver.findElement(By.cssSelector(css));
		Select select = new Select(selectDDL);
		select.selectByVisibleText(visibleText);
		Thread.sleep(3000);		 
		 
	}
	
	@Test
	public void test_selectSkills() throws InterruptedException {
		selectAnyDDLText("select[id='Skills']", "Android");
		
	}
	@Test
	public void test_selectCountry() throws InterruptedException {
		selectAnyDDLText("select[id='countries']", "Australia");
		
		
	}
	@Test
	 public void test_selectYear() throws InterruptedException {
		selectAnyDDLText("select[id='yearbox']", "1920");
			 
		 
	}
	@Test
	public void test_fileUpload() {
		driver.get("http://demo.automationtesting.in/FileUpload.html");
		String path = System.getProperty(("user.dir")+"\\Include\\Upload file.pdf");
		WebElement chooseFileBtn = driver.findElement(By.xpath("//*[@id=\"input-4\"]"));
		chooseFileBtn.sendKeys(path);
		System.exit(0);
		
		
		
		
	}
	
	
	
	
}
