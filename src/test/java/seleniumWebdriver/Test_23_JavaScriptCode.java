package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class Test_23_JavaScriptCode extends Base{

	@Test
	public void allJSFunction() throws InterruptedException {
		
        JavascriptExecutor JS = (JavascriptExecutor)driver;
        
        // 1.open Browser URL
        JS.executeScript(("window.location = 'http://demo.automationtesting.in/Register.html';"));
        
        // 2.setText()
        String fname = "David";
        WebElement firstNameTxtBx = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        JS.executeScript("arguments[0].value='"+ fname +"';", firstNameTxtBx);
        
        // 3.getText()
        WebElement pageHeader = driver.findElement(By.xpath("//h2[contains(text(),'Register')]"));
        System.out.println(JS.executeScript("return (arguments[0].innerHTML).toString();", pageHeader));
        
        // 4.click()
        WebElement movieChkBx = driver.findElement(By.xpath("//input[@id='checkbox2']"));
        JS.executeScript("arguments[0].click();", movieChkBx);
        
        // 5.Scroll Down
        Thread.sleep(2000);
        JS.executeScript("window.scrollBy(0,1000)"); 
        
        // 6.Scroll UP
        Thread.sleep(2000);
        JS.executeScript("window.scrollBy(0,-1000)"); 
        
        // 7.Scroll to element
        Thread.sleep(2000);
        WebElement element1 = driver.findElement(By.xpath("//button[@id='submitbtn']"));
        JS.executeScript("arguments[0].scrollIntoView(true);", element1);     
	}

}
