package seleniumWebdriver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utilites_library.Base;

public class S23_WindowAuthPopUpTest  extends Base {

	@Test
	public void setPopUpUserNamePwd() {
		driver.get("http://the-internet.herokuapp.com/");
		
//		driver.get("http://admin:admin@the-internet.herokuapp.com/"); //this is the window authentication popUp
//		driver.findElement(By.linkText("Basic Auth")).click();
		
		
	}
}
