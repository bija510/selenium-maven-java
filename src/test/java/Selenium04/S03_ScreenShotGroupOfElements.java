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

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;


public class S03_ScreenShotGroupOfElements {
private static WebDriver driver;
	
	@Test
	public void testOnly() throws IOException {
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		WebElement allRadioBtnGroup = driver.findElement(By.xpath("//div[@id='radio-btn-example']"));
		
		takeWebElementScreenshot(allRadioBtnGroup, "allRadioBtnGroupEles");
		
	}
	
	/*=========Exactly same library as S01 but Just pass the locator of the groups like upper like WebTable, forms , any Group===========*/
	public static void takeWebElementScreenshot(WebElement element, String fileName) {
		File scrfile = element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrfile, new File("../selenium-maven-java/Screenshot/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
