package zTemp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilites_library.Base;

public class Test01 extends Base {

	@Test
	public void pagetab() {
		driver.get("https://www.facebook.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("==>"+links.size());
		int a = 1;
		for(WebElement link : links) {
			if(link.getText().length()>0) {
				System.out.println(a++ + " "+ link.getText()+ "==>"+link.getAttribute("href"));
			}
		}
		
	}
}
