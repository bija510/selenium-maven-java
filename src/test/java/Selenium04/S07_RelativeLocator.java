package Selenium04;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.ChromeDriverManager;


public class S07_RelativeLocator {

	/*
	 * This are the 5 different locator supported in Selenium 4 this are called
	 * friendly locator below(), toLeftOf(), toRightOf(), above(), near()
	 */
	private static WebDriver driver;

	@BeforeClass
	public void setUp() {
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://automationbookstore.dev/");
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test(description = "Test books is left of book6 & below Book1")
	public void frendlyOrRelativeLocator() {
		WebElement book5 = driver.findElement(RelativeLocator.withTagName("li").toLeftOf(By.id("pid6")).below(By.id("pid1")));
		Assert.assertEquals("pid5", book5.getAttribute("id"));
	}
}
