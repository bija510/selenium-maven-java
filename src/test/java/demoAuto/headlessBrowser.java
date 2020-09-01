package demoAuto;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class headlessBrowser {
	/****************************************************************************
	 * Advantage >>-->Fast and usually good in CICD Jenkin it got performed
	 * Disadvantage >>--> hard to debug no UI, no user used App without UI,
	 *              >>-->managing to take screenshot
	 ****************************************************************************/
	@Test
	public void headlessBrowserExecution() throws IOException {
	
	/********************************************
	WebDriverManager.chromedriver().setup();
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--headless");
   //option.setHeadless(true);
	WebDriver driver = new ChromeDriver(option);
	***********************************************/
	WebDriverManager.firefoxdriver().setup();
	FirefoxOptions option = new FirefoxOptions();
	option.addArguments("--headless");
	//option.setHeadless(true);
	WebDriver driver = new FirefoxDriver(option);
	
	driver.get("https://www.google.com/");
	WebElement googlePageLebel = driver.findElement(By.xpath("//a[contains(text(),'About')]"));	
	System.out.println(googlePageLebel.getText());
	
	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("../Maven_Seleniums/Screenshot/"+ "googlescr.png"));//result+result.getName()
	
				
	}
	
}
