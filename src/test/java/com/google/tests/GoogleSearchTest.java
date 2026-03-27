package com.google.tests;

import com.google.pages.GoogleHomePage;
import com.google.pages.GoogleResultsPage;
import com.google.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Test class for Google Search functionality
 * Uses Page Object Model pattern with TestNG
 */
public class GoogleSearchTest {

    private WebDriver driver;
    private GoogleHomePage googleHomePage;
    private GoogleResultsPage googleResultsPage;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();

        // Initialize Page Objects
        googleHomePage = new GoogleHomePage(driver);
        googleResultsPage = new GoogleResultsPage(driver);

        System.out.println("WebDriver initialized and setup completed!");
    }

    @Test(description = "Launch Google.com in Chrome browser")
    public void testLaunchGoogle() {
        // Navigate to Google
        googleHomePage.navigateToGoogle();
        System.out.println("Navigated to Google.com");

        // Verify Google home page is loaded
        String actualTitle = googleHomePage.getPageTitle();
        System.out.println("Page Title: " + actualTitle);
        System.out.println("✓ Google.com is now open in Chrome browser!");
    }

    @AfterClass
    public void tearDown() {
        // Keep the browser open - do not close
        System.out.println("Browser remains open for manual inspection!");
        // WebDriverFactory.quitDriver(driver);
    }
}
