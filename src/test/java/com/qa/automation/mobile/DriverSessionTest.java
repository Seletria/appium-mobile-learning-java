package com.qa.automation.mobile;

import io.appium.java_client.android.AndroidDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import com.qa.automation.mobile.driver.AppiumDriverManager;
import com.qa.automation.mobile.driver.DriverFactory;

import java.net.MalformedURLException;

class DriverSessionTest {

    @BeforeEach
    void setUp() throws MalformedURLException {
        AppiumDriverManager.start();
    }

    @Test
    void launchesTargetApp() {
        AndroidDriver driver = AppiumDriverManager.getDriver();
        assertEquals(DriverFactory.APP_PACKAGE, driver.getCurrentPackage());
    }

    @AfterEach
    void tearDown() {
        AppiumDriverManager.quit();
    }
}
