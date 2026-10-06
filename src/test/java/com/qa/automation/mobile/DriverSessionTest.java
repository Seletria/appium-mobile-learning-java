package com.qa.automation.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.net.URI;

class DriverSessionTest {

    private AndroidDriver driver;

    @Test
    void createsDriver() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();

        driver = new AndroidDriver(
                URI.create("http://127.0.0.1:4723").toURL(), options);

        assertNotNull(driver.getSessionId());
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
