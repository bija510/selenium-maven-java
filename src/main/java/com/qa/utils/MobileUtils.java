package com.qa.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;

public class MobileUtils {

	public ChromeOptions capInjector(String deviceName) {
		// Setting up device = iPhone X
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", deviceName);// Nexus 5 //Galaxy S5
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		return chromeOptions;
	}
}
