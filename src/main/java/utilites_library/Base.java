package utilites_library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Base {
	protected WebDriver driver;
	public Properties prop;

	@BeforeClass(alwaysRun = true)
	public void initialize() throws IOException {
		// Reading data_properties file from Data Folder
		prop = new Properties();
		FileInputStream fis = new FileInputStream("../selenium-maven-java/Configurations/Config.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser"); // CHROME

		if (browserName.equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FIREFOX")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("EDGE")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("SAFARI")) {
			driver = new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterMethod
	public void closeLast(ITestResult result) throws IOException {
		String monthAndDate = CommonUtil.getMonthAndDate();
		String digit6TimeStamp = CommonUtil.get6DigitTimeStamp();

		if (ITestResult.FAILURE == result.getStatus()) {
			String failScreenShotName = result.getMethod().getMethodName() + monthAndDate + "_Failed_"
					+ digit6TimeStamp;
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("../Maven_Seleniums/Screenshot/" + failScreenShotName + ".png"));// result+result.getName()
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		if (driver != null) {
			driver.quit();
		}
	}
}
