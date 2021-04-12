package Selenium04;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.utils.FileUtil;

import io.github.bonigarcia.wdm.WebDriverManager;


public class S01_TakeWebElementSshot {

	private static WebDriver driver;

	@Test
	public void ScreenShotDemo() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement skillsDDL = driver.findElement(By.xpath("//select[@id='Skills']"));
		takeWebElementScreenshot(skillsDDL, "skillsDDLele");

	}


	/*=========This take screenshot for Any WebElement like texttBox, link, button, DDL etc===========*/
	
	public static void takeWebElementScreenshot(WebElement element, String fileName) {
		File scrfile = element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrfile, new File("../Maven_Seleniums/Screenshot/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
