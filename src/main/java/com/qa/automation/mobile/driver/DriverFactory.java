package com.qa.automation.mobile.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverFactory {

    private static final String SERVER_URL = "http://127.0.0.1:4723";
    public static final String APP_PACKAGE = "com.saucelabs.mydemoapp.android";
    private static final String APP_ACTIVITY = ".view.activities.SplashActivity";
    private static final String DEVICE_UDID = "emulator-5554";

    public static AndroidDriver createAndroidDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAppPackage(APP_PACKAGE);
        options.setAppActivity(APP_ACTIVITY);
        options.setUdid(envOrDefault("DEVICE_UDID", DEVICE_UDID));

        AndroidDriver driver = new AndroidDriver(
                URI.create(envOrDefault("APPIUM_URL", SERVER_URL)).toURL(), options);

        return driver;
    }

    private static String envOrDefault(String name, String defaultValue) {
        String value = System.getenv(name);
        return (value == null || value.isBlank()) ? defaultValue : value;
    }
}

