package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class s12_GroupsTest{
WebDriver driver;
	//=============NOTE:- Base class extends Not Working for Suite Level run==================
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(10));
	}

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
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		driver =null;
	}
}
