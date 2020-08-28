package Temp;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilites_library.Xls_Reader;

public class p2 {
	Xls_Reader subi = new Xls_Reader("../Maven_Seleniums/Data/InputTestData.xlsx");
	String lastName = subi.getCellData("Sheet1", "LastName", 2);
	
	WebDriver driver = null;
	@BeforeTest
	public void openMethod() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);    
	}	

	@Test
	public void Test1() {
		driver.get("http://demo.automationtesting.in/Register.html"); 
		//===>  //input[@placeholder='last Name']
		
		WebElement lastNameTextBox = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
		lastNameTextBox.sendKeys(lastName);
		
		
		
		
	}
	
	
    @AfterTest
	public void close() {
	
}
	
	
	
	
	
	
}
