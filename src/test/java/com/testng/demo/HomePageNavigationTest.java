package com.testng.demo;

import com.qa.utils.ExtentReportManager;
import com.qa.webui.core.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

@Listeners(ExtentReportManager.class)

public class HomePageNavigationTest {

    WebDriver driver;
    WebUI webUI;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        webUI = new WebUI(driver);
    }

    @Test
    public void verifyPageTitle() {
        webUI.openBrowser("https://www.facebook.com/signup");
        webUI.waitForPageLoad();

        String title = webUI.getText("Page Title", By.tagName("h2"));
        System.out.println("Title : " + title);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
