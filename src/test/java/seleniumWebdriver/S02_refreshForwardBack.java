package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S02_refreshForwardBack {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().maximize();
        
        WebElement forgetPassword =driver.findElement(By.linkText("Forgot account?"));
        forgetPassword.click();
        
        WebElement games =driver.findElement(By.linkText("Games"));
        games.click();
        
        driver.navigate().refresh();
        
        driver.navigate().back();

        driver.navigate().forward();
   
	}

}
