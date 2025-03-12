package Selenium04;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Headers;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.qa.utils.Base;

public class S07_ChromeDevTools_WindowAuthPopUpTest_More extends Base {

	private static final String username = "admin";
	private static final String password = "admin";

/********************************************************************************
1. Selenium 4 much awaited native support for Chrome DevTools Protocol through �DevTools� interface.
2. This helps us getting Chrome Development properties such as Application Cache, Fetch, Network,
Performance, Profiler, Resource Timing, Security and Target CDP domains etc.
3. Chrome DevTools is a set of web developer tools built directly into the Google Chrome browser. 
4. It help to edit pages on-the-fly and diagnose problems quickly, 
which ultimately helps you build better websites, faster.doesn't work for Edge browser.
If there is username with @ then this will not work.
*******************************************************************************/
	@Test
	public void wind_auth_popup() {
		// driver.get("http://the-internet.herokuapp.com/basic_auth");

		driver.get("http://" + username + ":" + password + "@" + "the-internet.herokuapp.com/"); // this is the window																							// authentication																							// popUp
		driver.findElement(By.linkText("Basic Auth")).click();
	}

	/******************************************************************************
	 1. This is a better way. 2. This only work for Chrome & Edge [==don't work
	 2. For Safari & Firefox==]. 3. if We Have any [==username with @==] then we use
	 3. This old style don't work.
	 *******************************************************************************/
	@Test
	public void wind_auth_popup_selenium4_only_chrome_and_edge() throws InterruptedException {
		// DevTools devTools = ((ChromeDriver)driver).getDevTools();

		DevTools devTools = ((EdgeDriver) driver).getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		// send auth header
		Map<String, Object> headers = new HashMap<>();
		String basicAuth = "Basic "+ new String(new Base64().encode(String.format("%s:%s", username, password).getBytes()));
		headers.put("Authorization", basicAuth);

		devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
		driver.get("http://the-internet.herokuapp.com/basic_auth");

		System.exit(0);

	}
}
