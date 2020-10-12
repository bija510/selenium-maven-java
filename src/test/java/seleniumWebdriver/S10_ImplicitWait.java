package seleniumWebdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S10_ImplicitWait {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivertesting\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
			
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //used only if needed-->soft wait
		
		driver.get("https://www.facebook.com/");
		
		Thread.sleep(2000); //always wait upto --->hard wait
		
		driver.findElement(By.id("u_0_m")).sendKeys("subi");

	}

}
