# appium-mobile-learning-java

Appium test automation for the Sauce Labs My Demo App (Android), written in Java with JUnit 5 and the Page Object Model.

## What it covers

- Login flow, including the empty-username validation error
- Opening a product from the catalog
- Scrolling the catalog to a product below the fold
- On-screen keyboard behavior on the login screen

Screens (`LoginScreen`, `MenuScreen`, `CatalogScreen`, `ProductDetailScreen`) extend a shared `BaseScreen` that holds the explicit-wait logic. Tests contain only assertions and use screens for all interaction.

## Prerequisites

- JDK (the project compiles with `maven.compiler.release` 25)
- Maven 3.9+
- Appium server 3.x with the UiAutomator2 driver
- An Android emulator or device, visible in `adb devices`

## Getting the app

Download the My Demo App APK (Android) from the project's releases page:
https://github.com/saucelabs/my-demo-app-android/releases

The tests were written against version 2.2.0 (`mda-2.2.0-25.apk`). Other versions may change element locators.

Either install it once on your device or emulator:

```
adb install mda-2.2.0-25.apk
```

or let Appium install it at session start by setting `APP_PATH` (see below).

## Configuration

All settings are optional environment variables. The app package and activity are fixed in code.

| Variable | Purpose | Default |
|---|---|---|
| `DEVICE_UDID` | Device or emulator to run on | `emulator-5554` |
| `APPIUM_URL` | Appium server address | `http://127.0.0.1:4723` |
| `APP_PATH` | Path to the APK; if set, Appium installs it before the session starts | not set (app must already be installed) |

Example:

```
APP_PATH=/path/to/mda-2.2.0-25.apk DEVICE_UDID=emulator-5554 mvn test
```

## Running the tests

1. Start the emulator and confirm it appears in `adb devices`.
2. Start the Appium server.
3. Run:

```
mvn clean test
```

## Notes

- Tests run locally. There is no CI job running them, because that would need an Android emulator in the pipeline, which was judged not worth the boot time and flakiness for a project of this size.
- The demo app accepts any username and password; the only validation is the required username.
