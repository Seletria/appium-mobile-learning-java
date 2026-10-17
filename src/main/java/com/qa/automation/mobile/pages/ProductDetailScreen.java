package com.qa.automation.mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import com.qa.automation.mobile.driver.DriverFactory;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class ProductDetailScreen extends BaseScreen {
    private static final By ADD_TO_CART_BUTTON = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"" + DriverFactory.APP_PACKAGE + ":id/cartBt\")"
    );

    public ProductDetailScreen(AndroidDriver driver) {
        super(driver);
    }

    public void waitForScreen() {
        waitUntilVisible(ADD_TO_CART_BUTTON);
    }
}
