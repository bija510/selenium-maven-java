package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S22_TryCatchFinally {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;

		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Drivertesting\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.get("https://www.facebook.com/");
			WebElement firstName = driver.findElement(By.id("u_0_m"));
			firstName.sendKeys("subi");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			Thread.sleep(3000);
			driver.close();
		}

	}

}
