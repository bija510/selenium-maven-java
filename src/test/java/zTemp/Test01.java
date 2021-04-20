package zTemp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import seleniumWebdriver.S01_openCloseBrowser;
import utilites_library.Base;

public class Test01 extends Base {

	@Test
	public void pagetab() throws InterruptedException {
		driver.get("https://learn.letskodeit.com/p/practice");
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0, 500)");
		
		  WebElement table = driver.findElement(By.cssSelector("table[id='product']"));
		  List<WebElement> table_row = table.findElements(By.tagName("td"));
		  
				
		for(WebElement rows :table_row) {
			System.out.println(rows.getText());
			if (rows.getText().equalsIgnoreCase("35")) {
				break;
			}
			
		}
		
		
		
		
		
	}
}
