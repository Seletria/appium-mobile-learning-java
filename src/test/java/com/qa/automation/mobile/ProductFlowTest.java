package com.qa.automation.mobile;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.qa.automation.mobile.driver.DriverFactory;
import com.qa.automation.mobile.pages.MenuScreen;
import com.qa.automation.mobile.pages.LoginScreen;
import com.qa.automation.mobile.pages.CatalogScreen;
import com.qa.automation.mobile.pages.ProductDetailScreen;

import java.net.MalformedURLException;

class ProductFlowTest {
    private static final String USERNAME = "bod@example.com";
    private static final String PASSWORD = "10203040";

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

    @Test
    void loggedInUserSeesLogOutOption() {
        MenuScreen menuScreen = new MenuScreen(driver);
        LoginScreen loginScreen = new LoginScreen(driver);
        CatalogScreen catalogScreen = new CatalogScreen(driver);
        ProductDetailScreen productDetailScreen = new ProductDetailScreen(driver);

        catalogScreen.waitForScreen();
        catalogScreen.tapProductByName("Sauce Labs Backpack");
        productDetailScreen.waitForScreen();

        menuScreen.openMenu();
        menuScreen.tapLogIn();

        loginScreen.waitForScreen();
        loginScreen.logIn(USERNAME, PASSWORD);

        catalogScreen.waitForScreen();

        menuScreen.openMenu();

        assertTrue(menuScreen.isLogOutDisplayed(), "Log Out should be visible after login");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
