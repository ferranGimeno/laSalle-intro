package com.lasalle.automation.vueling.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * - Window: get, getTitle, getCurrentUrl, getPageSource, close, quit
 * - Navigate: to, back, forward, refresh
 * - FindElement & FindElements
 * switchTo: frame, alert, window…
 * WebElement: click, clear, findElement/s, getAttribute, getText, sendkeys…
 * Locators según preferencia:
 * By Id
 * By name
 * By css: <a href="https://saucelabs.com/resources/articles/selenium-tips-css-selectors">...</a>
 * By xpath
 * Wait: implicitlyWait vs explicitWait (expected conditions)
 */
public class WebDriverOptionsTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        LOGGER.debug("Start testWebDrive");
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        LOGGER.debug("Driver closed");
    }

    @Test
    public void testExplicitWaitWithFluentWait() {
        LOGGER.debug("Start testExplicitWaitWithFluentWait");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("#checkbox-example > button")).click();
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.of(60, ChronoUnit.SECONDS))
                .pollingEvery(Duration.of(2, ChronoUnit.SECONDS))
                .ignoring(Exception.class);
        WebElement fluentElement = fluentWait.until(webDriver -> webDriver.findElement(By.id("message")));
        Assertions.assertThat(fluentElement.isDisplayed()).isTrue();
        String fluentElementText = fluentElement.getText();
        Assertions.assertThat(fluentElementText).isEqualTo("It's gone!");
        LOGGER.debug("Finish element, fluentElementText:[{}]", fluentElementText);
    }

     @Test
    public void testImplicitWait(){
         // TODO add driver manage implicit wait 60''
         //     Go to https://the-internet.herokuapp.com/dynamic_controls
         //     findElement(By.cssSelector("#checkbox-example > button")).click
         //     implicitWaitElement.getText
     }

}
