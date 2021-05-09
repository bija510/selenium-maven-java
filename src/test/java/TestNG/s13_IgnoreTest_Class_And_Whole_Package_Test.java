package TestNG;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * By using @Ignore we can igonre both class & method
 * To ignore whole package R-click-->new-->package-->give a name TestNG-->check package-info.java checkbox--> and finished 
 * Then add @ @org.testng.annotations.Ignore on top 
 * Now if we run any any thing under that package nothing run.
 */
//@Ignore
public class s13_IgnoreTest_Class_And_Whole_Package_Test {
	WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
	}

	@Test()
	public void methodA() {
		driver.get("https://www.facebook.com/");
	}

	@Test()
	@Ignore
	public void methodC() {
		driver.get("https://www.amazon.com/");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}
