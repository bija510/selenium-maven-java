package com.qa.webui.core;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

public class WebUI {

    private final WebDriver driver;
    private int defaultTimeout = 10;

    public static ExtentTest extentTest;

    public WebUI(WebDriver driver) {
        this.driver = driver;
    }

    // ---------- LOGGING ----------
    private void log(String msg) {
        System.out.println("[WebUI] " + msg);
        if (extentTest != null) {
            extentTest.info(msg);
        }
    }

    private void logError(String name, By by, String action, Exception ex) {
        String locator = (by == null) ? "N/A" : by.toString();
        String msg = "[ERROR] [" + name + "] → " + action + " (" + locator + ") : " + ex.getMessage();
        System.err.println(msg);

        if (extentTest != null) {
            extentTest.fail(msg);
        }
        throw new RuntimeException(ex);
    }

    private WebDriverWait wait(int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    // ---------- BROWSER ----------
    public void openBrowser(String url) {
        try {
            driver.get(url);
            log("Opened URL: " + url);
        } catch (Exception e) {
            logError("OpenBrowser", null, url, e);
        }
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
        log("Window maximized");
    }

    // ---------- WAIT ----------
    public void waitForElementVisible(By by) {
        try {
            wait(defaultTimeout)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            logError("WaitForElementVisible", by, "Visibility wait", e);
        }
    }

    public void waitForPageLoad() {
        try {
            wait(defaultTimeout).until(d ->
                    ((JavascriptExecutor) d)
                            .executeScript("return document.readyState")
                            .equals("complete"));
            log("Page loaded completely");
        } catch (Exception e) {
            logError("WaitForPageLoad", null, "Page load", e);
        }
    }

    // ---------- ACTIONS ----------
    public void click(String name, By by) {
        try {
            waitForElementVisible(by);
            driver.findElement(by).click();
            log(name + " clicked " + by);
        } catch (Exception e) {
            logError(name, by, "Click", e);
        }
    }

    public void clickUsingJS(String name, By by) {
        try {
            WebElement el = driver.findElement(by);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click()", el);
            log(name + " clicked using JS");
        } catch (Exception e) {
            logError(name, by, "JS Click", e);
        }
    }

    public void setText(String name, By by, String text) {
        try {
            WebElement el = driver.findElement(by);
            el.clear();
            el.sendKeys(text);
            log(name + " set text: " + text);
        } catch (Exception e) {
            logError(name, by, "SetText", e);
        }
    }

    public String getText(String name, By by) {
        try {
            String text = driver.findElement(by).getText();
            log(name + " text: " + text);
            return text;
        } catch (Exception e) {
            logError(name, by, "GetText", e);
            return "";
        }
    }

    // ---------- DROPDOWN ----------
    public void selectByText(String name, By by, String text) {
        try {
            Select s = new Select(driver.findElement(by));
            s.selectByVisibleText(text);
            log(name + " selected: " + text);
        } catch (Exception e) {
            logError(name, by, "Select dropdown", e);
        }
    }

    // ---------- VERIFY ----------
    public boolean verifyElementPresent(String name, By by) {
        try {
            driver.findElement(by);
            log(name + " present");
            return true;
        } catch (NoSuchElementException e) {
            log(name + " not present");
            return false;
        }
    }

    // ---------- SCREENSHOT ----------
    public String takeScreenshot(String action) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String time = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            File dest = new File("screenshots/" + action + "_" + time + ".png");
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath());
            log("Screenshot saved: " + dest.getAbsolutePath());
            return dest.getAbsolutePath();
        } catch (Exception e) {
            logError(action, null, "Screenshot", e);
            return "";
        }
    }

    // ---------- WINDOW ----------
    public void switchToWindowByIndex(int index) {
        Set<String> handles = driver.getWindowHandles();
        String handle = handles.toArray(new String[0])[index];
        driver.switchTo().window(handle);
        log("Switched to window index " + index);
    }

    // ---------- FRAME ----------
    public void switchToFrame(By by) {
        driver.switchTo().frame(driver.findElement(by));
        log("Switched to frame " + by);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
        log("Switched to default content");
    }

    // ---------- UTIL ----------
    public void delay(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ignored) {
        }
    }

    public void setDefaultTimeout(int seconds) {
        this.defaultTimeout = seconds;
        log("Default timeout set to " + seconds);
    }
}
