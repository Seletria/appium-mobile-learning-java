package com.qa.automation.mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import com.qa.automation.mobile.driver.DriverFactory;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MenuScreen {

    private static final By MENU_ICON = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"" + DriverFactory.APP_PACKAGE + ":id/menuIV\")"
    );

    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(5);

    private final AndroidDriver driver;

    public MenuScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void openMenu() {
        waitUntilVisible(MENU_ICON).click();
    }

    public void tapLogIn() {
        tapMenuItem("Log In");
    }

    private void tapMenuItem(String itemText) {
        waitUntilVisible(menuItem(itemText)).click();
    }

    private static By menuItem(String itemText) {
        return AppiumBy.androidUIAutomator(String.format(
                "new UiSelector().resourceId(\"%s:id/itemTV\").text(\"%s\")",
                DriverFactory.APP_PACKAGE, itemText
        ));
    }

    private WebElement waitUntilVisible(By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}