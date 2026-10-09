package com.qa.automation.mobile.driver;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import io.appium.java_client.android.options.UiAutomator2Options;
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
        options.setUdid(getDeviceUDID());

        AndroidDriver driver = new AndroidDriver(
                URI.create(resolveServerUrl()).toURL(), options);

        return driver;
    }

    private static String resolveServerUrl() {
        String appiumServerUrl = System.getenv("APPIUM_URL");
        if (appiumServerUrl == null) {
            return SERVER_URL;
        } else {
            return appiumServerUrl;
        }
    }

    private static String getDeviceUDID() {
        String deviceUDID = System.getenv("DEVICE_UDID");
        if (deviceUDID == null) {
            return DEVICE_UDID;
        } else {
            return deviceUDID;
        }
    }
}

