package Temp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class p1 {

	WebDriver driver = null;
	@BeforeTest
	public void openMethod () {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    
	   
	}
	@Test
     public void testMethod () {
		try {
		driver.get("http://demo.automationtesting.in/Register.html");
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,600)");
	    
		WebElement days = driver.findElement(By.cssSelector("#daybox"));
		List<WebElement> dd=days.findElements(By.cssSelector("select#daybox option"));
		for(int i=0; i<dd.size();i++) {
			if(dd.get(i).getText().equals("6")) {
				dd.get(i).click();
				break;
			}
			System.out.println(dd.get(i).getText());
			}
		
		}
	    catch(Exception e) {
			System.out.println(e.getMessage());
	
	    }
		
		
		
		System.exit(0);
		
		
		
		
		
		
		
		
		
	}


	@AfterTest
     public void closeMethod () throws InterruptedException {
	Thread.sleep(3000);
	driver.quit();
    }
}
