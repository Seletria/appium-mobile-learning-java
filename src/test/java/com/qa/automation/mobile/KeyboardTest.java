package com.qa.automation.mobile;

import com.qa.automation.mobile.driver.AppiumDriverManager;
import com.qa.automation.mobile.pages.LoginScreen;
import com.qa.automation.mobile.pages.MenuScreen;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class KeyboardTest extends BaseTest {
    private LoginScreen loginScreen;

    @BeforeEach
    void setUp() {
        AndroidDriver driver = AppiumDriverManager.getDriver();
        MenuScreen menuScreen = new MenuScreen(driver);
        loginScreen = new LoginScreen(driver);

        menuScreen.openMenu();
        menuScreen.tapLogIn();
        loginScreen.waitForScreen();
    }

    @Test
    void keyboardIsHiddenOnLoginScreenBeforeTapping() {
        assertFalse(AppiumDriverManager.getDriver().isKeyboardShown(), "Keyboard should be hidden before tapping the username field");
    }

    @Test
    void keyboardAppearsAfterTappingUsernameField() {
        loginScreen.tapUsernameInput();
        loginScreen.waitForKeyboard();
    }
}
