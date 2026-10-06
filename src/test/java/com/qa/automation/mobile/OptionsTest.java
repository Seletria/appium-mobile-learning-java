package com.qa.automation.mobile;

import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionsTest {

    @Test
    void shouldBuildOptionsForMyDemoApp() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage("com.saucelabs.mydemoapp.android")
                .setAppActivity(".view.activities.SplashActivity");

        assertEquals("com.saucelabs.mydemoapp.android",
                options.getCapability("appium:appPackage"));

        assertEquals(".view.activities.SplashActivity",
                options.getCapability("appium:appActivity"));
    }
}
