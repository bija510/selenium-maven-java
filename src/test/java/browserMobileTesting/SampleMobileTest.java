package browserMobileTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilites_library.mobileTestingSetup;

public class SampleMobileTest {
	/*******************************************************************
	 * Conclusion:- Iphone x and Galaxy S5 script not Working in I pad 
	 * Need a lot of 
	 * 1.Scroll to Element and 
	 * 2. wait 
	 ******************************************************************/

	@Test
	public void justTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(new mobileTestingSetup().CapInjector("iPhone X"));
		driver.manage().window().maximize();

		String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"); // navigator.appVersion
		System.out.println("Executed Device Name:- " + uAgent.substring(13, 37));

		driver.get("http://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//input[@type='text']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ram");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("sharma");
		driver.findElement(By.xpath("//form[@id='basicBootstrapForm']/div[2]/div/textarea")).click();
		driver.findElement(By.xpath("//form[@id='basicBootstrapForm']/div[2]/div/textarea")).clear();
		driver.findElement(By.xpath("//form[@id='basicBootstrapForm']/div[2]/div/textarea")).sendKeys("123 drive");
		driver.findElement(By.xpath("//section[@id='section']/div/div/div[3]")).click();
		driver.findElement(By.xpath("//input[@type='tel']")).click();
		driver.findElement(By.xpath("//input[@type='tel']")).clear();
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("12345678");
		driver.findElement(By.name("radiooptions")).click();

		new Select(driver.findElement(By.id("yearbox"))).selectByVisibleText("1929");
		driver.findElement(By.id("yearbox")).click();
		driver.findElement(By.xpath("(//select[@type='text'])[4]")).click();
		new Select(driver.findElement(By.xpath("(//select[@type='text'])[4]"))).selectByVisibleText("September");
		driver.findElement(By.xpath("(//select[@type='text'])[4]")).click();
		driver.findElement(By.id("daybox")).click();
		new Select(driver.findElement(By.id("daybox"))).selectByVisibleText("14");
		driver.findElement(By.id("daybox")).click();
		driver.findElement(By.id("firstpassword")).click();
		driver.findElement(By.id("firstpassword")).clear();
		driver.findElement(By.id("firstpassword")).sendKeys("Admin123");
		driver.findElement(By.id("secondpassword")).click();
		driver.findElement(By.id("secondpassword")).clear();
		driver.findElement(By.id("secondpassword")).sendKeys("Admin123");
		driver.findElement(By.id("submitbtn")).click();

		driver.quit();

	}

	@Test
	public void walmart() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(new mobileTestingSetup().CapInjector("iPhone X"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Verify desired device open in Browser
		String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"); // navigator.appVersion
		System.out.println("Executed Device Name:- " + uAgent.substring(13, 37));

		driver.get("https://www.walmart.com/");
		driver.findElement(By.id("global-search-input")).sendKeys("fan");
		Thread.sleep(2000);
		driver.findElement(By.id("global-search-input")).sendKeys(Keys.ENTER);
	
		WebElement element = driver.findElement(By.xpath("(//*[contains(text(),'Lasko Cool Colors 20')])[1]"));
		new Actions(driver).moveToElement(element).perform();
		element.click();
		
		WebElement addToCartBtn = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
		new Actions(driver).moveToElement(addToCartBtn).perform();
		addToCartBtn.click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//span[contains(text(),'Go to cart')])")).click();
		
		driver.close();
	}
}
