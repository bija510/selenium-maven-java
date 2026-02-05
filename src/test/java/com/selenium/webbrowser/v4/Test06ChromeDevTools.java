package com.selenium.webbrowser.v4;

import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v144.emulation.Emulation;
import org.openqa.selenium.devtools.v144.network.Network;
import org.openqa.selenium.devtools.v144.performance.Performance;
import org.openqa.selenium.devtools.v144.performance.model.Metric;
import org.openqa.selenium.devtools.v144.network.model.ConnectionType;
import org.testng.annotations.*;


public class Test06ChromeDevTools {

    ChromeDriver driver;
    DevTools devTools;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        devTools = driver.getDevTools();
        devTools.createSession();
    }

    @Test
    public void test_set_device_mode() {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 600);
        deviceMetrics.put("height", 1000);
        deviceMetrics.put("mobile", true);
        deviceMetrics.put("deviceScaleFactor", 50);

        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
        driver.get("http://demo.automationtesting.in/Register.html");
    }

    @SuppressWarnings("deprecation")
	@Test
    public void test_set_network_speed() {
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.send(Network.emulateNetworkConditions(
                false,
                200,
                50000,
                50000,
                Optional.of(ConnectionType.CELLULAR3G), Optional.empty(), Optional.empty(), Optional.empty()));

        driver.get("https://www.google.com");
    }

    @Test
    public void test_mocking_geolocation() {
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(35.8235),
                Optional.of(-78.8256),
                Optional.of(100), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

        driver.get("https://mycurrentlocation.net/");
    }

    @Test
    public void test_capture_http_requests() {
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), request -> {
            System.out.println(
                    "Request URI : " + request.getRequest().getUrl() +
                    " | Method : " + request.getRequest().getMethod()
            );
        });

        driver.get("https://www.google.com");

        devTools.send(Network.disable());
    }

    @Test
    public void capturing_performance_metrics() {

        devTools.send(Performance.enable(Optional.empty()));

        driver.get("https://www.google.org");

        List<Metric> metrics = devTools.send(Performance.getMetrics());

        Map<String, Number> metricMap = metrics.stream()
                .collect(Collectors.toMap(Metric::getName, Metric::getValue));

        List<String> metricsToCheck = Arrays.asList(
                "Timestamp", "Documents", "Frames", "JSEventListeners",
                "LayoutObjects", "Nodes", "Resources");

        metricsToCheck.forEach(m ->
                System.out.println(m + " : " + metricMap.get(m)));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
