package com.qa.automation.mobile;

import com.qa.automation.mobile.driver.AppiumDriverManager;
import com.qa.automation.mobile.pages.CatalogScreen;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ScrollFlowTest extends BaseTest {
    private static final String TARGET_PRODUCT = "Sauce Labs Bolt T-Shirt";
    private static final int MAX_ATTEMPTS = 10;

    @Test
    void scrollingCatalogRevealsProductBelowTheFold() {
        AndroidDriver driver = AppiumDriverManager.getDriver();
        CatalogScreen catalogScreen = new CatalogScreen(driver);

        catalogScreen.waitForScreen();
        boolean found = catalogScreen.scrollToProduct(TARGET_PRODUCT, MAX_ATTEMPTS);

        assertTrue(found,
                String.format("\"%s\" should be found within %d scroll attempts", TARGET_PRODUCT, MAX_ATTEMPTS));
    }
}
