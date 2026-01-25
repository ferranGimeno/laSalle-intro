package com.lasalle.automation.vueling.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
        LOGGER.debug("start testWebDrive");
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
        // TODO go to url https://the-internet.herokuapp.com
        // TODO get the title
        // TODO get the current url
        // TODO get the page source
        // TODO navigate to https://the-internet.herokuapp.com/abtest
        // TODO navigate back
        // TODO navigate forward
        // TODO navigate refresh
        // TODO assert the current url is https://the-internet.herokuapp.com/abtest
        LOGGER.debug("Finish testWebDriveNavigation");
    }
}
