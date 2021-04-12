package Selenium04;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;


public class S04_getRect_Dimen_Point {

private static WebDriver driver;
	
	@Test
	public void getWebElementSizeAndArea() throws IOException {
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().fullscreen();
		
		WebElement languageTxt = driver.findElement(By.xpath("//div[@id='msdd']"));
		
		/*=============Selenium 3============*/
		Dimension d = languageTxt.getSize();
		System.out.println(d.getHeight());
		System.out.println(d.getWidth());
		
		Point p = languageTxt.getLocation();
		System.out.println(p.getX());
		System.out.println(p.getY());
		
		/*=============Selenium 4============*/
		Rectangle d1 = languageTxt.getRect();
		System.out.println(d1.getHeight());
		System.out.println(d1.getWidth());
		
		System.out.println(d1.getX());
		System.out.println(d1.getY());
	
//		This doesnot work but can be work in browser console
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("document.getElementById('msdd').getBoundingClientRect();").toString(); 
		
	}
		
}
