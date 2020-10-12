package seleniumWebdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S23_JavaScriptCode {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivertesting\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        
        Thread.sleep(3000);
        
        JavascriptExecutor JS = (JavascriptExecutor)driver;
        JS.executeScript("window.scrollBy(0,1000)"); //Scroll Down
        
        Thread.sleep(3000);
        JS.executeScript("window.scrollBy(0,-1000)"); // Scroll UP

	}

}
