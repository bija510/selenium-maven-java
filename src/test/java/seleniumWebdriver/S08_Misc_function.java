package seleniumWebdriver;

import java.util.Date;
import org.testng.annotations.Test;
import utilites_library.Base;

public class S08_Misc_function extends Base{

	@Test
	public void miscFunct() throws InterruptedException {
	/**********************************************************************
	 * From here no more Writing ChromeDriver setUp instead extends to Base 
	 **********************************************************************/
		
	driver.get("http://demo.automationtesting.in/Register.html");
	
	driver.manage().deleteAllCookies();
	
	System.out.println( "Current Url:- " + driver.getCurrentUrl() );
	System.out.println( "Current page title:- " + driver.getTitle() );
	System.out.println( "Current window Number(handles):- " + driver.getWindowHandle() );
	
	System.out.println( new Date() );
	
	}
}
