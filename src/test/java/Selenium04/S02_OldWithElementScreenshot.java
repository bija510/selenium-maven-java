package Selenium04;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class S02_OldWithElementScreenshot {
	
	private static WebDriver driver;
	
	@Test
	public void testOnly() throws IOException {
		//WebDriverManager.chromedriver().setup();
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement skillsDDL = driver.findElement(By.xpath("//select[@id='Skills']"));
		
		//takeElementScreenShot(skillsDDL, "skillsDDLelement2");
		takeFullPagescreenShot("FullPage1");
	}
	
	
	/*===============This take screenshot of Specific Element====================*/
	public static void takeElementScreenShot(WebElement element ,String fileName) throws IOException { //Type Casting [WebElement] instead of [driver]
		File src = ((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("../Maven_Seleniums/Screenshot/"+ fileName +".png"));
	}
	
	/*===============This take screenshot of Full Page old library====================*/
	public static void takeFullPagescreenShot(String fileName) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("../Maven_Seleniums/Screenshot/"+ fileName +".png"));
	}
}
