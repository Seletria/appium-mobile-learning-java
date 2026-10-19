package com.qa.automation.mobile;

import com.qa.automation.mobile.driver.DriverFactory;
import com.qa.automation.mobile.pages.LoginScreen;
import com.qa.automation.mobile.pages.MenuScreen;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertFalse;

class KeyboardTest {
    private AndroidDriver driver;

    @BeforeEach
    void setUp() throws MalformedURLException {
        driver = DriverFactory.createAndroidDriver();
    }

    @Test
    void keyboardIsHiddenOnLoginScreenBeforeTapping() {
        MenuScreen menuScreen = new MenuScreen(driver);
        LoginScreen loginScreen = new LoginScreen(driver);

        menuScreen.openMenu();
        menuScreen.tapLogIn();
        loginScreen.waitForScreen();

        assertFalse(driver.isKeyboardShown(), "Keyboard should be hidden before tapping the username field");
    }

    @Test
    void keyboardAppearsAfterTappingUsernameField() {
        MenuScreen menuScreen = new MenuScreen(driver);
        LoginScreen loginScreen = new LoginScreen(driver);

        menuScreen.openMenu();
        menuScreen.tapLogIn();
        loginScreen.waitForScreen();

        loginScreen.tapUsernameInput();
        loginScreen.waitForKeyboard();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}