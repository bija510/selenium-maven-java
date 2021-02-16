package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class S04_absoluteVSRelativePath {
	
	public static void main(String[] args) throws InterruptedException {
	/***************************************************************************************************
	 1. Absolute path = "C:\\Users\\Bijaya Chhetri\\eclipse-workspace\\subi\\Driver\\chromedriver.exe"
	 2. Relative path = System.getProperty("user.dir")+"\\subi\\Driver\\chromedriver.exe" 
	 3. Relative path [Easy way] = "../subi/Driver/chromedriver.exe"
	 4. Don't use hard coded path is framework instead use dynamic relative path
	 ****************************************************************************************************/
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bijaya Chhetri\\eclipse-workspace\\Maven_Seleniums\\Driver\\chromedriver.exe");
	//System.setProperty("webdriver.chrome.driver", "../Maven_Seleniums/Driver/chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Driver\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
		
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/signup");
	
	WebElement firstName = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div[1]/form/div[1]/div[1]/div[1]/div[1]/div/div[1]/input"));
	firstName.sendKeys("David");
	
	WebElement lastName = driver.findElement(By.xpath("//input[@id='u_0_p']"));
	lastName.sendKeys("lee");
	

	Thread.sleep(3000);
	driver.close();	
			
		
	}

}
