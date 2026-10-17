package com.qa.automation.mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import com.qa.automation.mobile.driver.DriverFactory;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class CatalogScreen extends BaseScreen {
    private static final By PRODUCT_TITLE = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"" + DriverFactory.APP_PACKAGE + ":id/productTV\")"
    );

    public CatalogScreen(AndroidDriver driver) {
        super(driver);
    }

    public void waitForScreen() {
        waitUntilVisible(PRODUCT_TITLE);
    }

    private static By productImage(String productName) {
        return AppiumBy.androidUIAutomator(String.format(
                "new UiSelector().resourceId(\"%1$s:id/titleTV\").text(\"%2$s\")"
                        + ".fromParent(new UiSelector().resourceId(\"%1$s:id/productIV\"))",
                DriverFactory.APP_PACKAGE, productName
        ));
    }

    public void tapProductByName(String productName) {
        waitUntilVisible(productImage(productName)).click();
    }
}
