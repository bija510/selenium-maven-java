package com.selenium.webbrowser.v3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_37_Handle_Cookies {
	int a = 0;
	int b = 0;
	Set<Cookie> cookies;
	Iterator<Cookie> cookie;
	
	@Test
	public void cookieMethods() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.amazon.com");
		driver.manage().window().maximize();
		
		//1.addCookie()
		driver.manage().addCookie(new Cookie("userName", "David"));
		driver.findElement(By.xpath("//*[@id='nav-signin-tooltip']/a")).click();
		
		//2.getCookieNamed()
		System.out.println(driver.manage().getCookieNamed("userName"));
		
		//3.getCookies()
		cookies = driver.manage().getCookies();
		cookie = cookies.iterator();
		while(cookie.hasNext()){
			System.out.println(++a + " "+cookie.next());
		}
		System.out.println("\nCookies Size = "+cookies.size()+"\n");
		
		//4. deleteCookieNamed()
		driver.manage().deleteCookieNamed("userName");
		
		//5. deleteAllCookies()
		driver.manage().deleteAllCookies();
		
		// Verifying after deleting the cookie
		cookies = driver.manage().getCookies();
		cookie = cookies.iterator();
		while(cookie.hasNext()){
			System.out.println(++b + " "+cookie.next());
		}
		System.out.println("\nCookies Size = "+cookies.size()+"\n");
	}



	@Test
	public void storingCookie() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/pim/viewMyDetails");

		// Input Email id and Password If you are already Register
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		// create file named Cookies to store Login Information
		File file = new File("Cookies.data");
		try {
			// Delete old file if exists
			file.delete();
			file.createNewFile();
			FileWriter fileWrite = new FileWriter(file);
			BufferedWriter Bwrite = new BufferedWriter(fileWrite);
			// loop for getting the cookie information

			// loop for getting the cookie information
			for (Cookie ck : driver.manage().getCookies()) {
				Bwrite.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
						+ ck.getExpiry() + ";" + ck.isSecure()));
				Bwrite.newLine();
			}

			Bwrite.close();
			fileWrite.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings({ "resource", "deprecation" })
	@Test
	public void using_stored_cookie_to_login() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		try {

			File file = new File("Cookies.data");
			FileReader fileReader = new FileReader(file);
			BufferedReader Buffreader = new BufferedReader(fileReader);
			String strline;

			while ((strline = Buffreader.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(strline, ";");
				while (token.hasMoreTokens()) {
					String name = token.nextToken();
					String value = token.nextToken();
					String domain = token.nextToken();
					String path = token.nextToken();
					Date expiry = null;

					String val;
					if (!(val = token.nextToken()).equals("null")) {
						expiry = new Date(val);
					}
					Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
					Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
					System.out.println(ck);
					driver.manage().addCookie(ck); // This will add the stored cookie to your current session
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/pim/viewMyDetails");

	}
}
