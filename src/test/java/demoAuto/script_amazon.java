package demoAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class script_amazon extends Base {

	@Test
	public void amazon_test() {
		driver.get("https://www.amazon.com/");
		WebElement searchTextBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchTextBox.sendKeys("Iphone 6");
		searchTextBox.sendKeys(Keys.ENTER);
		
		WebElement iphoneLevel = driver.findElement(By.xpath("//span[contains(text(),'Simple Mobile Prepaid - Apple iPhone 6s (32GB) - S')]"));
		iphoneLevel.click();
		
		WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
		addToCartButton.click();
		
		String actCartVerificationLevel = "Cart subtotal";
		
		WebElement cartLabel = driver.findElement(By.xpath("//*[@id=\'attach-accessory-cart-total-string\']/b"));
		
		String expCartVerificationLevel = cartLabel.getText();
		
		Assert.assertEquals(actCartVerificationLevel ,expCartVerificationLevel );
		
		
		System.exit(0);
		
	}
	

	
}
