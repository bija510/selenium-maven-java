package demoAuto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Log4jDemoTest{
	
	private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(Log4jDemoTest.class);
	static WebDriver driver = null;
	
	@BeforeMethod
	public static void start() {
		
		WebDriverManager.firefoxdriver().setup();
		logger.info("We are trying to open Firefox driver");	
		driver = new FirefoxDriver();
		
		logger.info("Firefox browser open successfully");
		
		driver.manage().window().maximize();
		logger.info("Window just got Maximize");
		
	}
	@Test
	public static void test() {
		driver.get("https://www.amazon.com/");
        logger.info("Amazon.com website got open");
	}

	@AfterMethod
	public  static void end() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
        logger.info("--Passed Successfully--");
	}

















}
