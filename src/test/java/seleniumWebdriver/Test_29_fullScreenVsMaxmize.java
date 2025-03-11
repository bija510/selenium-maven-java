package seleniumWebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_29_fullScreenVsMaxmize {
/*****************************************************************************************
 * When ==maximize()==the title bar & Task Manager etc. of the window is still displayed. 
 * In ===fullscreen()== mode the title bar is not displayed.
 * We can maxmize window by 3 ways
 ****************************************************************************************/
	@Test
	public void TestA() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
 //Automation doesn't use Manually created userProfile profile
	}
	
	@Test
	public void TestB() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
	}
	
	@Test
	public void TestC() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("start-fullscreen"));
		//WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
		
		
	}

}
