package com.selenium.webbrowser.v3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class Test_15_WebTable_HtmlTableTest extends Base{

	@Test
	public void Webtable() {
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("window.scrollBy(0,300)");
		
		//Example:-1 get all text
		List<WebElement> tableTd = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr/td"));
		System.out.println("===========All text from table ===========");	
		for(WebElement ele: tableTd) {
			System.out.println(ele.getText());		
		}
		
		//Example:-2 get only rowOne text
		List<WebElement> row1 = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr[2]/td"));
		System.out.println("=========All info From Row one==========");	
		for(WebElement ele1: row1) {
			System.out.println(ele1.getText());		
		}
		
	}
	
	@Test
	public void runGetAnyText() throws Exception {
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("window.scrollBy(0,300)");
		System.out.println(clickOrGetText("//table[@id='customers']", "Island Trading" ,"Country"));
	}
	
	public String clickOrGetText(String tableXpath, String KeyVal, String colToGet) throws Exception {			
			int colIndex = -1;
			boolean found = false;
			String retVal = "";

			WebElement Table =  driver.findElement(By.xpath(tableXpath));
			List<WebElement> Rows =Table.findElements(By.tagName("tr"));
			List<WebElement> ColHeaders = Rows.get(0).findElements(By.tagName("th"));
			for(int i=0; i < ColHeaders.size(); i++){
				if (ColHeaders.get(i).getText().toLowerCase().contains(colToGet.toLowerCase())){
					//println ColHeaders.get(i).getText();
					colIndex =i;
					break;
				}
			}
			outerLoop:
			for(int i=0; i < Rows.size(); i++){
				List<WebElement> Cols =Rows.get(i).findElements(By.tagName("td"));
				int colSize = Cols.size();
				for(int j = 0; j < Cols.size(); j++){

					if (Cols.get(j).getText().toLowerCase().contains(KeyVal.toLowerCase())){
						//return Cols.get(colIndex).click();
						return Cols.get(colIndex).getText();

					}

				}
			}
			if(found){
				return retVal;
			}else{
				throw new Exception(KeyVal +"Was NOt Found");

			}
		}

		
		
	}

