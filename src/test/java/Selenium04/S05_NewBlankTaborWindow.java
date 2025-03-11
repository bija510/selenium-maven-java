package Selenium04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class S05_NewBlankTaborWindow {
	
	private static WebDriver driver;
	@Test
	public void blankTabWindow() throws IOException {
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		//driver.switchTo().newWindow(WindowType.TAB); //open New Tab
		driver.switchTo().newWindow(WindowType.WINDOW); //open New blank window
		
		driver.get("https://www.facebook.com");
		System.out.println(driver.getTitle());
		
		Set<String> handles = driver.getWindowHandles();
		List<String> ls = new ArrayList<String>(handles);
		String parentWindowID =ls.get(0);
		String childWindowId = ls.get(1);
		
		driver.close();//close the tab Now driver is lost
		
		driver.switchTo().window(parentWindowID);
		System.out.println(driver.getTitle());
		
		
}

}