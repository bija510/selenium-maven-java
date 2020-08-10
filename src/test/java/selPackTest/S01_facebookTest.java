package selPackTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class S01_facebookTest {

	@Test
	public void facebook() throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bijaya Chhetri\\eclipse-workspace\\subi\\Driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
		
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	
	WebElement firstName = driver.findElement(By.id("u_0_m"));
	firstName.sendKeys("David");
	
	WebElement lastName = driver.findElement(By.id("u_0_o"));
	lastName.sendKeys("lee");
	
	WebElement mobileNumber = driver.findElement(By.id("u_0_r"));
	mobileNumber.sendKeys("123456");
	
	WebElement newPassword = driver.findElement(By.xpath("//input[@id='password_step_input']"));
	newPassword.sendKeys("abc234");
	
	WebElement singUp = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div[1]/h2"));
	System.out.println(singUp.getText());
	
	Thread.sleep(2000);
		
	Select ab = new Select(driver.findElement(By.id("month")));
	ab.selectByVisibleText("Apr");
	
	Select b =new Select(driver.findElement(By.xpath("//select[@id='day']")));
	b.selectByVisibleText("5");
	
	Select s =new Select(driver.findElement(By.xpath("//select[@id='year']")));
	s.selectByVisibleText("1986");

	Thread.sleep(3000);
	driver.findElement(By.linkText("Forgot account?")).click();
	Thread.sleep(3000);
	
	driver.close();	
	}	
		
		
		
	}


