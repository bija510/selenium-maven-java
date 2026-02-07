package com.testng.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.utils.ExtentReportManager;
import com.qa.webui.core.WebUI;

@Listeners(ExtentReportManager.class)

public class AutoCompleteInputTest {

    private WebDriver driver;
    private WebUI webUI;

    @Test
    public void verifyAutoCompleteTxtBx() {

        driver = new ChromeDriver();
        webUI = new WebUI(driver);

        webUI.openBrowser("https://www.rahulshettyacademy.com/AutomationPractice/");
        webUI.maximizeWindow();

        webUI.setText(
                "Auto Complete Input",
                By.id("autocomplete"),
                "Chin"
        );
    }

    @AfterMethod
    public void cleanUp() {
        System.out.println("Class TestDemo3 Executed....");
        if (driver != null) {
            driver.quit();
        }
    }
}
