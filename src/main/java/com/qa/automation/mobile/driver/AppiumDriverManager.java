package com.qa.automation.mobile.driver;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

public class AppiumDriverManager {
    private static final ThreadLocal<AndroidDriver> DRIVER = new ThreadLocal<>();

    private AppiumDriverManager() {
    }

    public static void start() throws MalformedURLException {
        DRIVER.set(DriverFactory.createAndroidDriver());
    }

    public static AndroidDriver getDriver() {
        return DRIVER.get();
    }

    public static void quit() {
        AndroidDriver driver = DRIVER.get();
        if (driver != null) {
            driver.quit();
            DRIVER.remove();
        }
    }
}
