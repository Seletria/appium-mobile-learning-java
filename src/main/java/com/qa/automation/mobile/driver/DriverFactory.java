package com.qa.automation.mobile.driver;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URI;

public class DriverFactory{

    private static final String SERVER_URL = "http://127.0.0.1:4723";

    public static AndroidDriver createAndroidDriver() throws MalformedURLException{
        UiAutomator2Options options = new UiAutomator2Options();

        AndroidDriver driver = new AndroidDriver(
                URI.create(SERVER_URL).toURL(), options);

        return driver;
    }

}

