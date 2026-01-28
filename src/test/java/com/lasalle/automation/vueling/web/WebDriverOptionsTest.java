package com.lasalle.automation.vueling.web;

import org.assertj.core.api.Assertions;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 * - Window: get, getTitle, getCurrentUrl, getPageSource, close, quit
 * - Navigate: to, back, forward, refresh
 * - FindElement & FindElements
 * switchTo: frame, alert, window…
 * WebElement: click, clear, findElement/s, getAttribute, getText, sendkeys…
 * Locators según preferencia:
 * By Id
 * By name
 * By css: <a href="https://saucelabs.com/resources/articles/selenium-tips-css-selectors">selenium-tips-css-selectors</a>
 * By xpath
 * Wait: implicitlyWait vs explicitWait (expected conditions)
 */
public class WebDriverOptionsTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        LOGGER.debug("Start testWebDrive");
        // FirefoxOptions options = new FirefoxOptions();
        // We should be sure that we have the executable
        // see file $(which firefox)
        // options.setBinary("/usr/lib/firefox/firefox");
        // driver = new FirefoxDriver(options);
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        LOGGER.debug("driver closed");
    }

    @Test
    public void testWebDrives() {
        LOGGER.debug("Start testWebDrives");
        driver.manage().window().maximize();
        LOGGER.debug("driver starter");
        driver.navigate().to("https://www.selenium.dev/ecosystem");
        Assertions.assertThat(driver).isNotNull();
        LOGGER.debug("Finish testWebDrives");
    }

    @Test
    public void testWebDriveNavigation() {
        LOGGER.debug("Start testWebDriveNavigation");

        // Go to url https://the-internet.herokuapp.com
        driver.get("https://the-internet.herokuapp.com");

        // Get the title
        String title = driver.getTitle();
        LOGGER.debug("Title: " + title);

        // Get the current url
        String currentUrl = driver.getCurrentUrl();
        LOGGER.debug("Current url: " + currentUrl);

        // Get the page source
        String pageSource = driver.getPageSource();
        LOGGER.debug("Page source: " + pageSource);

        // Navigate to https://the-internet.herokuapp.com/abtest
        driver.navigate().to("https://the-internet.herokuapp.com/abtest");

        // Navigate back
        driver.navigate().back();

        // Navigate forward
        driver.navigate().forward();

        // Navigate refresh
        driver.navigate().refresh();

        // Assert the current url is https://the-internet.herokuapp.com/abtest
        String url = driver.getCurrentUrl();
        Assertions.assertThat(url).isEqualTo("https://the-internet.herokuapp.com/abtest");

        LOGGER.debug("Finish testWebDriveNavigation");
    }
}
