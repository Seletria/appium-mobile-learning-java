package com.qa.automation.mobile;

import com.qa.automation.mobile.driver.DriverFactory;
import com.qa.automation.mobile.pages.CatalogScreen;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ScrollFlowTest {
    private static final String TARGET_PRODUCT = "Sauce Labs Bolt T-Shirt";
    private static final int MAX_ATTEMPTS = 10;

    private AndroidDriver driver;

    @BeforeEach
    void setUp() throws MalformedURLException {
        driver = DriverFactory.createAndroidDriver();
    }

    @Test
    void scrollingCatalogRevealsProductBelowTheFold() {
        CatalogScreen catalogScreen = new CatalogScreen(driver);

        catalogScreen.waitForScreen();
        boolean found = catalogScreen.scrollToProduct(TARGET_PRODUCT, MAX_ATTEMPTS);

        assertTrue(found,
                String.format("\"%s\" should be found within %d scroll attempts", TARGET_PRODUCT, MAX_ATTEMPTS));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
