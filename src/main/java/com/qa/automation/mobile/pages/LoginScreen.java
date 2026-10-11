package com.qa.automation.mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import com.qa.automation.mobile.driver.DriverFactory;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class LoginScreen {

    private static final By USERNAME_INPUT = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"" + DriverFactory.APP_PACKAGE + ":id/nameET\")"
    );
    private static final By PASSWORD_INPUT = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"" + DriverFactory.APP_PACKAGE + ":id/passwordET\")"
    );
    private static final By LOGIN_BUTTON = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"" + DriverFactory.APP_PACKAGE + ":id/loginBtn\")"
    );

    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(5);

    private final AndroidDriver driver;

    public LoginScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void logIn(String username, String password) {
        waitUntilVisible(USERNAME_INPUT).sendKeys(username);
        waitUntilVisible(PASSWORD_INPUT).sendKeys(password);
        waitUntilVisible(LOGIN_BUTTON).click();
    }

    private WebElement waitUntilVisible(By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}