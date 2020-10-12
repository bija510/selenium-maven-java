package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S11_ExplicitWait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C://Drivertesting//chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();


		WebDriverWait ExplicitWait = new WebDriverWait(driver,10);
		
		driver.get("https://www.facebook.com/");

		WebElement firstName = ExplicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("u_0_m")));
				
		firstName.sendKeys("John");
		
		driver.quit();

	}

}
