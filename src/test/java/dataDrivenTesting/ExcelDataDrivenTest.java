package dataDrivenTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilites_library.Base;
import utilites_library.Xls_Reader;

public class ExcelDataDrivenTest extends Base {

	@Test
	public void readingDataFromExcel() {
	Xls_Reader reader = new Xls_Reader("../Maven_Seleniums/Data/InputTestData.xlsx"); // objectName  || xPath
	String sheetName = "Sheet1";

	/**************************************************************************
	 * object Reading from Excel file and storing in the String 
	 **************************************************************************/
	String firstName = reader.getCellData(sheetName, "FirstName", 2); //start from [2]
	String lastName = reader.getCellData(sheetName, "LastName", 2);
	String address = reader.getCellData(sheetName, "Address", 2);
	
	System.out.println(firstName );
	System.out.println(lastName );
	System.out.println(address );
	

	driver.get("http://demo.automationtesting.in/Register.html"); 

	WebElement lastNameTextBox = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
	lastNameTextBox.sendKeys(lastName);

	  }
	
	}

