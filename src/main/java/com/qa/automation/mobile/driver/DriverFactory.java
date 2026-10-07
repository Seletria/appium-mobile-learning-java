package com.qa.automation.mobile.driver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URI;

public class DriverFactory{
    public static AndroidDriver createAndroidDriver() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();

        AndroidDriver driver = new AndroidDriver(
                URI.create("http://127.0.0.1:4723").toURL(), options);

        return driver;
    }

}

