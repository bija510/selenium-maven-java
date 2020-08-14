package demoAuto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register extends Base { // extends Base ===> This is called Inheritance
 
	
	@Test
	public void pagetab() {
	driver.get("http://demo.automationtesting.in/Register.html");
	WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
	firstNameTextBox.sendKeys("ram");
	
	WebElement lastNameTextBox = driver.findElement(By.cssSelector("input[placeholder='Last Name'"));
	lastNameTextBox.sendKeys("sharma");
	
	WebElement femaleRadioButton = driver.findElement(By.xpath("//label[2]//input[1]"));
	femaleRadioButton.click();
	
	WebElement movieCheckBox = driver.findElement(By.cssSelector("input[id='checkbox2']"));
	movieCheckBox.click();
	
	Select skillsDDL = new Select(driver.findElement(By.cssSelector("aa")));
	skillsDDL.selectByVisibleText("CSS");
	
	Select countryDDL = new Select(driver.findElement(By.cssSelector("select[id='countries']")));
	countryDDL.selectByVisibleText("Australia");
	
	Select yearDDL = new Select(driver.findElement(By.cssSelector("select[id='yearbox']")));
	yearDDL.selectByVisibleText("1918");
	
	Select monthDDL = new Select(driver.findElement(By.cssSelector("select[placeholder='Month']")));
	monthDDL.selectByVisibleText("February");
	
	Select dayDDL = new Select(driver.findElement(By.cssSelector("select[id='daybox']")));
	dayDDL.selectByVisibleText("12");
	
	}
		
	
}










