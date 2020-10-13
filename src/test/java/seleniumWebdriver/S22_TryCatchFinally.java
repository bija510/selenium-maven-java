package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilites_library.Base;

public class S22_TryCatchFinally extends Base{

	@Test
	public void tryCatch() throws InterruptedException {

		try {
			driver.get("https://www.facebook.com/signup");
			WebElement firstName = driver.findElement(By.xpath("//input[@id='u_0_n']"));
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
