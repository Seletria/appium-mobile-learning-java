package com.qa.automation.mobile;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import com.qa.automation.mobile.driver.DriverFactory;
import com.qa.automation.mobile.pages.CatalogScreen;
import com.qa.automation.mobile.pages.ProductDetailScreen;

import java.net.MalformedURLException;

class ProductFlowTest {
    private AndroidDriver driver;

    @BeforeEach
    void setUp() throws MalformedURLException {
        driver = DriverFactory.createAndroidDriver();
    }

    @Test
    void tapProductOpensProductDetail() {
        CatalogScreen catalogScreen = new CatalogScreen(driver);
        ProductDetailScreen productDetailScreen = new ProductDetailScreen(driver);

        catalogScreen.waitForScreen();
        catalogScreen.tapProductByName("Sauce Labs Backpack");
        productDetailScreen.waitForScreen();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
