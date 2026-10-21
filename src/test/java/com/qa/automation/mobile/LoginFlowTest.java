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
    private LoginScreen loginScreen;

    @BeforeEach
    void setUp() throws MalformedURLException {
        AppiumDriverManager.start();
        AndroidDriver driver = AppiumDriverManager.getDriver();
        MenuScreen menuScreen = new MenuScreen(driver);
        loginScreen = new LoginScreen(driver);

        menuScreen.openMenu();
        menuScreen.tapLogIn();
    }

    @Test
    void openMenuAndLogIn() {
        loginScreen.logIn(USERNAME, PASSWORD);

        CatalogScreen catalogScreen = new CatalogScreen(AppiumDriverManager.getDriver());
        catalogScreen.waitForScreen();
    }

    @Test
    void loginWithEmptyUsernameReturnsError() {
        loginScreen.logIn("", PASSWORD);
        loginScreen.waitForUsernameError();
    }

    @AfterEach
    void tearDown() {
        AppiumDriverManager.quit();
    }
}
