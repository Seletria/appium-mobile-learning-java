package com.qa.automation.mobile;

import com.qa.automation.mobile.driver.AppiumDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;

abstract class BaseTest {

    @BeforeEach
    void startDriver() throws MalformedURLException {
        AppiumDriverManager.start();
    }

    @AfterEach
    void quitDriver() {
        AppiumDriverManager.quit();
    }
}
