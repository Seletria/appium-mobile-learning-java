package com.qa.automation.mobile;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.qa.automation.mobile.driver.AppiumDriverManager;
import com.qa.automation.mobile.pages.MenuScreen;
import com.qa.automation.mobile.pages.LoginScreen;
import com.qa.automation.mobile.pages.CatalogScreen;
import com.qa.automation.mobile.pages.ProductDetailScreen;

import java.net.MalformedURLException;

class ProductFlowTest {
    private static final String USERNAME = "bod@example.com";
    private static final String PASSWORD = "10203040";

    @BeforeEach
    void setUp() throws MalformedURLException {
        AppiumDriverManager.start();
    }

    @Test
    void tapProductOpensProductDetail() {
        AndroidDriver driver = AppiumDriverManager.getDriver();
        CatalogScreen catalogScreen = new CatalogScreen(driver);
        ProductDetailScreen productDetailScreen = new ProductDetailScreen(driver);

        catalogScreen.waitForScreen();
        catalogScreen.tapProductByName("Sauce Labs Backpack");
        productDetailScreen.waitForScreen();
    }

    @Test
    void loginWithValidCredentialsShowsLogOutOption() {
        AndroidDriver driver = AppiumDriverManager.getDriver();
        MenuScreen menuScreen = new MenuScreen(driver);
        LoginScreen loginScreen = new LoginScreen(driver);
        CatalogScreen catalogScreen = new CatalogScreen(driver);

        catalogScreen.waitForScreen();
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
        AppiumDriverManager.quit();
    }
}
