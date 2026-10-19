package com.qa.automation.mobile.pages;

import com.qa.automation.mobile.driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class CatalogScreen extends BaseScreen {
    private static final By PRODUCT_TITLE = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"" + DriverFactory.APP_PACKAGE + ":id/productTV\")"
    );
    private static final By PRODUCT_LIST = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"" + DriverFactory.APP_PACKAGE + ":id/productRV\")"
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

    private static By productTitle(String productName) {
        return AppiumBy.androidUIAutomator(String.format(
                "new UiSelector().resourceId(\"%s:id/titleTV\").text(\"%s\")",
                DriverFactory.APP_PACKAGE, productName
        ));
    }

    public void tapProductByName(String productName) {
        waitUntilVisible(productImage(productName)).click();
    }

    private boolean isProductVisible(String productName) {
        List<WebElement> matches = driver.findElements(productTitle(productName));
        return !matches.isEmpty() && matches.get(0).isDisplayed();
    }

    private boolean scrollListDown() {
        WebElement list = waitUntilVisible(PRODUCT_LIST);
        String listId = ((RemoteWebElement) list).getId();
        boolean canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", Map.of(
                "elementId", listId,
                "direction", "down",
                "percent", 0.75
        ));
        return canScrollMore;
    }

    public boolean scrollToProduct(String productName, int maxAttempts) {
        for (int i = 0; i < maxAttempts; i++) {
            if (isProductVisible(productName)) {
                return true;
            }
            boolean canScrollMore = scrollListDown();
            if (!canScrollMore) {
                return isProductVisible(productName);
            }
        }
        return isProductVisible(productName);
    }
}
