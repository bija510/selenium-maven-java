package seleniumWebdriver;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class Test_25_setEncryptedPassword extends Base{

	@Test
	public void setEncryptedPassword() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement userNameTxtBx = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		userNameTxtBx.sendKeys("Admin");
		
		WebElement passwordTxtBx = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		passwordTxtBx.sendKeys(decodeString("YWRtaW4xMjM="));
		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
		loginBtn.click();
				
	}
	
	static String decodeString(String password) {
		byte[] decodedString = Base64.decodeBase64(password);
		return(new String(decodedString));
	}
	@Test
	public void encodedAndDecoded() {
		String str ="admin123";
		
		byte[] encodedString = Base64.encodeBase64(str.getBytes());
		System.out.println("encoded string:-" + new String(encodedString));
		
		byte[] decodedString = Base64.decodeBase64(encodedString);
		System.out.println("decoded string:-" + new String(decodedString));
		
	}
	
}
