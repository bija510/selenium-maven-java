package com.selenium.webbrowser.v3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test35FindBrokenLinks {

	WebDriver driver = null;
	String URL = "https://www.lambdatest.com/blog";
	
	String url = "";
	HttpURLConnection urlconnection = null;
	int responseCode = 200;

	@BeforeClass
	public void testSetUp() throws MalformedURLException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test
	public void test_Selenium_Broken_Links() throws InterruptedException {
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> link = links.iterator();

		/* For skipping email address */
		String mail_to = "mailto";
		String tel = "tel";
		String LinkedInPage = "https://www.linkedin.com";
		int valid_links = 0;
		int broken_links = 0;
		Boolean bLinkedIn = false;
		int LinkedInStatus = 999;

		while (link.hasNext()) {
			url = link.next().getAttribute("href");
			// System.out.println(url);
			bLinkedIn = false;

			if ((url == null) || (url.isEmpty())) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			/* String str="mailto:support@LambdaTest.com"; */
			if ((url.startsWith(mail_to)) || (url.startsWith(tel))) {
				System.out.println("Email address or Telephone detected");
				continue;
			}

			if (url.startsWith(LinkedInPage)) {
				System.out.println("URL starts with LinkedIn, expected status code is 999");
				bLinkedIn = true;
			}

			try {
				urlconnection = (HttpURLConnection) (new URL(url).openConnection());
				urlconnection.setRequestMethod("HEAD");
				urlconnection.connect();
				responseCode = urlconnection.getResponseCode();
				if (responseCode >= 400) {
					/*
					 * https://stackoverflow.com/questions/27231113/999-error-code-on-head-request-
					 * to-linkedin
					 */
					if ((bLinkedIn == true) && (responseCode == LinkedInStatus)) {
						System.out.println(url + " ["+responseCode +"] is a LinkedIn Page and is not a broken link");
						valid_links++;
					} else {
						System.err.println(url + " [" + responseCode +"] is a broken link");
						broken_links++;
					}
				} else {
					System.out.println(url + " [" + responseCode +"] OK is a valid link");
					valid_links++;
				}
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println("\nDetection of broken links completed with [" + broken_links + "] broken links and ["
				+ valid_links + "] valid links\n");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {		
			driver.quit();
		}
	}
}
