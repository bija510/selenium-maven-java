package com.selenium.webbrowser.v4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.emulation.Emulation;
import org.openqa.selenium.devtools.v131.network.model.ConnectionType;
import org.openqa.selenium.devtools.v131.performance.Performance;
import org.openqa.selenium.devtools.v131.performance.model.Metric;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.devtools.v131.network.Network;

import com.aventstack.extentreports.model.Log;
//import com.google.common.graph.Network;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test06ChromeDevTools {

/*****************************************************************************************
Selenium 3:- ChromeDriver<===extends==RemoteWebDriver 
Seleinum 4:- ChromeDriver<===ChromiumDriver<===extends==RemoteWebDriver
******************************************************************************************
Summary
As you can see, Selenium has become a lot more powerful with the addition of the CDP APIs.
We can now enhance our tests to [capture HTTP network traffic], [collect performance metrics],
[handle authentication], and [emulate geolocations, time zones and device modes]. 
As well as [anything else that is possible within Chrome DevTools!]
******************************************************************************************/
	ChromeDriver driver;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	
	@Test
	public void test_set_device_mode() {
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
		driver.get("http://demo.automationtesting.in/Register.html");
	}

	/*******************************************************************************
	 * Many users access web applications via handheld devices which are connected
	 * to wifi or cellular networks. It�s not uncommon to reach a weak network
	 * signal, and therefore a slower internet connection.
	 * 
	 * It may be important to test how your application behaves under such
	 * conditions where the internet connection is slow (2G) or goes offline
	 * intermittently.
	 ********************************************************************************/
	@Test
	public void test_set_network_or_stimulate_network_speed() {
		 // Setup ChromeDriver with ChromeOptions (make sure you specify path if needed)
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(
				false,
				20,
				20,
				50, Optional.of(ConnectionType.CELLULAR2G), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
		driver.get("https://www.google.com");
	}

	/**********************************************************************************
	 * Some applications have different features and functionalities across
	 * different locations. Automating such applications is difficult because it is
	 * hard to emulate the geo locations in the browser using Selenium. But with the
	 * help of Devtools, we can easily emulate them. Below code snippet demonstrates
	 * that.
	 **********************************************************************************/
	@Test
	public void test_mocking_geolocation() {
		 DevTools devTools = driver.getDevTools();
	        devTools.createSession();
	        devTools.send(Emulation.setGeolocationOverride(
	                Optional.of(35.8235),
	                Optional.of(-78.8256),
	                Optional.of(100)));
	        driver.get("https://mycurrentlocation.net/");
	}

		
	@Test
	public void testCaptureNetworkTraffic_or_Capture_HTTP_Requests() {	
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

	
	/************************************************************************************************
	  Poor performing websites and slower loading pages make unhappy customers.
	  Can we validate these metrics along with our functional regression on every build? Yes, we can!
	  The CDP command to capture performance metrics
	 ************************************************************************************************/
	@Test
	public void capturing_performance_metrics() {
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Performance.enable(Optional.empty()));

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
