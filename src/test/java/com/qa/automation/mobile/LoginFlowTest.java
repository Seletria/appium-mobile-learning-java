package com.qa.automation.mobile;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import com.qa.automation.mobile.driver.AppiumDriverManager;
import com.qa.automation.mobile.pages.LoginScreen;
import com.qa.automation.mobile.pages.MenuScreen;
import com.qa.automation.mobile.pages.CatalogScreen;

import java.net.MalformedURLException;

class LoginFlowTest {

    private static final String USERNAME = "bod@example.com";
    private static final String PASSWORD = "10203040";

    @BeforeEach
    void setUp() throws MalformedURLException {
        AppiumDriverManager.start();
    }

    @Test
    void openMenuAndLogIn() {
        AndroidDriver driver = AppiumDriverManager.getDriver();
        MenuScreen menuScreen = new MenuScreen(driver);
        menuScreen.openMenu();
        menuScreen.tapLogIn();

        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.logIn(USERNAME, PASSWORD);

        CatalogScreen catalogScreen = new CatalogScreen(driver);
        catalogScreen.waitForScreen();
    }

    @Test
    void loginWithEmptyUsernameReturnsError() {
        AndroidDriver driver = AppiumDriverManager.getDriver();
        MenuScreen menuScreen = new MenuScreen(driver);
        menuScreen.openMenu();
        menuScreen.tapLogIn();

        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.logIn("", PASSWORD);
        loginScreen.waitForUsernameError();

    }

    @AfterEach
    void tearDown() {
        AppiumDriverManager.quit();
    }
}
