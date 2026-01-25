package com.lasalle.automation.vueling.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

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
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        LOGGER.debug("Driver closed");
    }

    @Test
    public void testWebDriveNavigation() {
        LOGGER.debug("Start testWebDriveNavigation");
        driver.get("https://the-internet.herokuapp.com");
        driver.getTitle();
        driver.getCurrentUrl();
        driver.getPageSource();
        driver.navigate().to("https://the-internet.herokuapp.com/abtest");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo("https://the-internet.herokuapp.com/abtest");
        LOGGER.debug("Finish testWebDriveNavigation");
    }

    @Test
    public void testWebDriveSelectors() {
        LOGGER.debug("Start testWebDriveSelectors");
        driver.navigate().to("https://the-internet.herokuapp.com");
        driver.findElement(By.id("page-footer"));
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
        driver.switchTo().alert().dismiss();
        List<WebElement> buttons = driver.findElements(By.cssSelector("button"));
        Assertions.assertThat(buttons.size()).isEqualTo(3);
        LOGGER.debug("Finish testWebDriveSelectors");
    }
}
