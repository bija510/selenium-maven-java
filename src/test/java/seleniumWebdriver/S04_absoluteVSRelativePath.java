package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class S04_absoluteVSRelativePath {
	
	public static void main(String[] args) throws InterruptedException {
	/***************************************************************************************************
	 We can do Path in 3 ways 
	 1. Absolute path = "C:\\Users\\Bijaya Chhetri\\eclipse-workspace\\subi\\Driver\\chromedriver.exe"
	 2. Relative path = System.getProperty("user.dir")+"\\subi\\Driver\\chromedriver.exe" 
	 3. Relative path [Easy way] = "../subi/Driver/chromedriver.exe"
	 ****************************************************************************************************/
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bijaya Chhetri\\eclipse-workspace\\subi\\Driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
		
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/signup");
	
	WebElement firstName = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
	firstName.sendKeys("David");
	
	WebElement lastName = driver.findElement(By.xpath("//input[@id='u_0_n']"));
	lastName.sendKeys("lee");
	
	WebElement singUp = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div[1]/h2"));
	System.out.println(singUp.getText());
	
	Thread.sleep(2000);
		
	Select ab = new Select(driver.findElement(By.id("month")));
	ab.selectByVisibleText("Apr");

	Thread.sleep(3000);
	
	driver.close();	
			
		
	}

}
