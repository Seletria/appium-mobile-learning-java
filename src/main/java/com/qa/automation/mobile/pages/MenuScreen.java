package com.qa.automation.mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import com.qa.automation.mobile.driver.DriverFactory;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class MenuScreen {

    private static final By MENU_ICON = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"" + DriverFactory.APP_PACKAGE + ":id/menuIV\")"
    );

    private final AndroidDriver driver;

    public MenuScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void openMenu() {
        driver.findElement(MENU_ICON).click();
    }

    public void tapLogin() {
        tapMenuItem("Log In");
    }

    private void tapMenuItem(String itemText) {
        driver.findElement(menuItem(itemText)).click();
    }

    private static By menuItem(String itemText) {
        return AppiumBy.androidUIAutomator(String.format(
                "new UiSelector().resourceId(\"%s:id/itemTV\").text(\"%s\")",
                DriverFactory.APP_PACKAGE, itemText
        ));
    }

}