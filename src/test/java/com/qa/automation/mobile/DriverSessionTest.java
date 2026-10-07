package com.qa.automation.mobile;

import io.appium.java_client.android.AndroidDriver;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import com.qa.automation.mobile.driver.DriverFactory;

class DriverSessionTest {

    private AndroidDriver driver;

    @BeforeEach
    void setUp() throws Exception{
        driver = DriverFactory.createAndroidDriver();
    }

    @Test
    void createsDriver(){
        assertNotNull(driver.getSessionId());
    }

    @AfterEach
    void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
