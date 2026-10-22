package com.qa.automation.mobile;

import io.appium.java_client.android.AndroidDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.qa.automation.mobile.driver.AppiumDriverManager;
import com.qa.automation.mobile.driver.DriverFactory;

class DriverSessionTest extends BaseTest {

    @Test
    void launchesTargetApp() {
        AndroidDriver driver = AppiumDriverManager.getDriver();
        assertEquals(DriverFactory.APP_PACKAGE, driver.getCurrentPackage());
    }
}
