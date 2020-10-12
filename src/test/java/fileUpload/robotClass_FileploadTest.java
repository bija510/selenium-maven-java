package fileUpload;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilites_library.Base;

public class robotClass_FileploadTest extends Base {
	
		@Test
		public void uploadFileRC() throws InterruptedException, AWTException {
			driver.get("https://pdf2jpg.net/");			
	        String uploadFilePath = System.getProperty("user.dir")+"\\Include\\Upload file.pdf";
	        
	        driver.findElement(By.id("advanced_pdf_file")).click();
			Thread.sleep(3000);  //Delay after click on Browser Button
			StringSelection ss = new StringSelection(uploadFilePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			Thread.sleep(3000); //Delay after paste the text
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			System.exit(0);
		}

	}


