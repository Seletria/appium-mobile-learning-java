package com.qa.automation.mobile;

import io.appium.java_client.android.AndroidDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.mobile.driver.DriverFactory;
import com.qa.automation.mobile.pages.LoginScreen;
import com.qa.automation.mobile.pages.MenuScreen;

import java.net.MalformedURLException;
import java.time.Duration;

class LoginFlowTest {

    private static final String USERNAME = "bod@example.com";
    private static final String PASSWORD = "10203040";
    private static final By PRODUCTS_TITLE = By.id(DriverFactory.APP_PACKAGE + ":id/productTV");

    private AndroidDriver driver;

    @BeforeEach
    void setUp() throws MalformedURLException {
        driver = DriverFactory.createAndroidDriver();
    }

    @Test
    void openMenuAndLogIn() {
        MenuScreen menuScreen = new MenuScreen(driver);
        menuScreen.openMenu();
        menuScreen.tapLogIn();

        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.logIn(USERNAME, PASSWORD);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        assertTrue(
                wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCTS_TITLE)).isDisplayed(),
                "Login sonrasinda urunler ekrani gorunur olmali"
        );
    }

    @Test
    void loginWithEmptyUsernameReturnsError() {
        MenuScreen menuScreen = new MenuScreen(driver);
        menuScreen.openMenu();
        menuScreen.tapLogIn();

        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.logIn("", PASSWORD);
        loginScreen.waitForUsernameError();

    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
