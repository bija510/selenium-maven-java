package com.testng.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.utils.ExtentReportManager;

@Listeners(ExtentReportManager.class)

public class DropdownSelectionTest {

    private WebDriver driver;
    private com.qa.webui.core.WebUI webUI;

    @Test
    public void verifyDropdownLabel() {

        driver = new ChromeDriver();
        webUI = new com.qa.webui.core.WebUI(driver);

        webUI.openBrowser("https://www.rahulshettyacademy.com/AutomationPractice/");
        webUI.maximizeWindow();

        webUI.selectByText(
                "Dropdown Example",
                By.id("dropdown-class-example"),
                "Option2"
        );
    }

    @AfterMethod
    public void cleanUp() {
        System.out.println("Class TestDemo2 Executed....");
        if (driver != null) {
            driver.quit();
        }
    }
}
