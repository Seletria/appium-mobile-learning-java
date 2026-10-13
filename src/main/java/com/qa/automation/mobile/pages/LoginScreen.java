package com.qa.automation.mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import com.qa.automation.mobile.driver.DriverFactory;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class LoginScreen extends BaseScreen {

    private static final By USERNAME_INPUT = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"" + DriverFactory.APP_PACKAGE + ":id/nameET\")"
    );
    private static final By PASSWORD_INPUT = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"" + DriverFactory.APP_PACKAGE + ":id/passwordET\")"
    );
    private static final By LOGIN_BUTTON = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"" + DriverFactory.APP_PACKAGE + ":id/loginBtn\")"
    );
    private static final By USERNAME_ERROR = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"" + DriverFactory.APP_PACKAGE + ":id/nameErrorTV\")"
                    + ".text(\"Username is required\")"
    );

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    public void logIn(String username, String password) {
        waitUntilVisible(USERNAME_INPUT).sendKeys(username);
        waitUntilVisible(PASSWORD_INPUT).sendKeys(password);
        waitUntilVisible(LOGIN_BUTTON).click();
    }

    public void waitForUsernameError() {
        waitUntilVisible(USERNAME_ERROR);
    }
}