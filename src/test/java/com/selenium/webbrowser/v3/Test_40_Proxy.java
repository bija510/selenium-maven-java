package com.selenium.webbrowser.v3;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/******************************************************************************
 * This site provide the proxy server for public for free ie 83.238.13.109:8080
 * https://www.proxynova.com/proxy-server-list/
 *******************************************************************************/
public class Test_40_Proxy {

	@Test(description = "From selenium docs https://www.selenium.dev/documentation/en/webdriver/http_proxies/")
	public void example1_fromSeleniumOfficialDocs_proxyTest() {
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("<83.238.13.109:8080>");
		ChromeOptions options = new ChromeOptions();
		options.setCapability("proxy", proxy);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/documentation/en/webdriver/http_proxies/");
		
	}

	@Test(description = "This is very fast so this is Recommended")
	public void example2_proxyTest() {
		String proxyIPaddress = "83.238.13.109", proxyPort = "8080";
		String proxyServer = proxyIPaddress + ":" + proxyPort;

		Proxy p = new Proxy();
		p.setHttpProxy(proxyServer);

		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PROXY, p);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/documentation/en/webdriver/http_proxies/");
		System.out.println(">>>>" + driver.getCurrentUrl());
	}

	@Test(description = "This is very slow NOT RECOMMENDED")
	public void example3_proxyTest() {
		String proxyIPaddress = "83.238.13.109", proxyPort = "8080";
		String proxyServer = proxyIPaddress + ":" + proxyPort;

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--proxy-server=http://" + proxyServer);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/documentation/en/webdriver/http_proxies/");
		System.out.println(">>>>" + driver.getCurrentUrl());
	}

}
