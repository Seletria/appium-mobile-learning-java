package com.qa.automation.mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public abstract class BaseScreen {

    protected final AndroidDriver driver;
    protected static final Duration WAIT_TIMEOUT = Duration.ofSeconds(5);

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitUntilVisible(By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}