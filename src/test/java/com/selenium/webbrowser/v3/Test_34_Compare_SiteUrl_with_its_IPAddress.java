package com.selenium.webbrowser.v3;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

public class Test_34_Compare_SiteUrl_with_its_IPAddress {

	/**Use this url to find ip address of URL
	 * https://www.ipvoid.com/find-website-ip/
	 * @throws MalformedURLException 
	 */
	@Test
	public void compare_site_url_with_its_ip_address() {
		
		try {
			System.out.println(new URL("https://naveenautomationlabs.com").equals(new URL("https://45.130.228.5")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
