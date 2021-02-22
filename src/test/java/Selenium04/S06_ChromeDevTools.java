package Selenium04;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v89.network.Network;
import org.openqa.selenium.devtools.v89.network.model.ConnectionType;
import org.openqa.selenium.devtools.v89.network.model.LoadingFailed;
import org.openqa.selenium.devtools.v89.network.*;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S06_ChromeDevTools {

	private static WebDriver driver;
	@Test
	public void devToolDemo() {
		/* Selenium 3:- ChromeDriver<===extends==RemoteWebDriver
		 * Seleinum 4:- ChromeDriver<===ChromiumDriver<===extends==RemoteWebDriver
		 */
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		
		DevTools devTools = ((ChromiumDriver)driver).getDevTools();
		devTools.createSession();
		
		//We need to send 2 different type of request [API means we can send some Request and we get some Response]
		devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
		
//		devTools.send(emulateNetworkCondations(true, 100, 1000, 2000, Optional.of(ConnectionType.WIFI)));
//		devTools.addListener(loadingFailed(),loadingFailed -> assertEquals(loadingFailed.getErrorText(), "net::ERR_INTERNET_DISCONNECTED"));
		
		driver.get("https://www.facebook.com");
		
	}
}
