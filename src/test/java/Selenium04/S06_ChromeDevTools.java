package Selenium04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v89.network.Network;
import org.openqa.selenium.devtools.v89.network.model.ConnectionType;
import org.openqa.selenium.devtools.v89.network.model.LoadingFailed;
import org.openqa.selenium.devtools.v89.performance.Performance;
import org.openqa.selenium.devtools.v89.performance.model.Metric;
import org.openqa.selenium.devtools.v89.emulation.Emulation;
import org.openqa.selenium.devtools.v89.log.Log;
import org.openqa.selenium.devtools.v89.network.*;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S06_ChromeDevTools {

	private static WebDriver driver;

	/**************************************************************************************************************************
	 * Some applications have different features and functionalities across
	 * different locations. Automating such applications is difficult because it is
	 * hard to emulate the geo locations in the browser using Selenium. But with the
	 * help of Devtools, we can easily emulate them. Below code snippet demonstrates
	 * that.
	 ***************************************************************************************************************************/

	@Test
	public void test_set_device_mode() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver;
		driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map deviceMetrics = new HashMap() {
			{
				put("width", 600);
				put("height", 1000);
				put("mobile", true);
				put("deviceScaleFactor", 50);
			}
		};
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		driver.get("https://www.google.com");
	}

	/*******************************************************************************
	 * Many users access web applications via handheld devices which are connected
	 * to wifi or cellular networks. It’s not uncommon to reach a weak network
	 * signal, and therefore a slower internet connection.
	 * 
	 * It may be important to test how your application behaves under such
	 * conditions where the internet connection is slow (2G) or goes offline
	 * intermittently.
	 ********************************************************************************/
	@Test
	public void test_set_network_or_stimulate_network_speed() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver;
		driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 20, 20, 50, Optional.of(ConnectionType.CELLULAR2G)));
		driver.get("https://www.google.com");

	}

	@Test
	public void test_mocking_geolocation() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver;
		driver = new ChromeDriver();

		 DevTools devTools = driver.getDevTools();
	        devTools.createSession();
	        devTools.send(Emulation.setGeolocationOverride(
	                Optional.of(35.8235),
	                Optional.of(-78.8256),
	                Optional.of(100)));
	        driver.get("https://mycurrentlocation.net/");

	}

	
    private static DevTools chromeDevTools;
	
	@Test
	public void testCaptureNetworkTraffic() {
		/*
		 * Selenium 3:- ChromeDriver<===extends==RemoteWebDriver Seleinum 4:-
		 * ChromeDriver<===ChromiumDriver<===extends==RemoteWebDriver
		 */
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();


		DevTools chromeDevTools = driver.getDevTools();
		chromeDevTools.createSession();

		chromeDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		chromeDevTools.addListener(Network.requestWillBeSent(),
				entry -> {
					System.out.println("Request URI : " + entry.getRequest().getUrl()+"\n"
							+ " With method : "+entry.getRequest().getMethod() + "\n");
					entry.getRequest().getMethod();
				});
		driver.get("https://www.google.com");
		chromeDevTools.send(Network.disable());
			
	}

	@Test
	public void CaptureConsoleLogs() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools chromeDevTools = driver.getDevTools();
		chromeDevTools.createSession();

		chromeDevTools.send(Log.enable());
		chromeDevTools.addListener(Log.entryAdded(),
				logEntry -> {
					System.out.println("log: "+logEntry.getText());
					System.out.println("level: "+logEntry.getLevel());
				});
		driver.get("https://testersplayground.herokuapp.com/console-5d63b2b2-3822-4a01-8197-acd8aa7e1343.php");
	}
	
	@Test
	public void capturing_performance_metrics() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
//		devTools.send(Performance.enable());

		driver.get("https://www.google.org");

		List<Metric> metrics = devTools.send(Performance.getMetrics());
		List<String> metricNames = metrics.stream()
				.map(o -> o.getName())
				.collect(Collectors.toList());

		devTools.send(Performance.disable());

		List<String> metricsToCheck = Arrays.asList(
				"Timestamp", "Documents", "Frames", "JSEventListeners",
				"LayoutObjects", "MediaKeySessions", "Nodes",
				"Resources", "DomContentLoaded", "NavigationStart");

		metricsToCheck.forEach( metric -> System.out.println(metric +
				" is : " + metrics.get(metricNames.indexOf(metric)).getValue()));
	}

}
