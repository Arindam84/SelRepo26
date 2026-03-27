package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

/**
 * Page Object Model class for Google Results Page
 */
public class GoogleResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    @FindBy(xpath = "//div[@id='result-stats']")
    private WebElement resultStats;

    // Constructor
    public GoogleResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Methods
    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isResultsDisplayed() {
        try {
            // Wait for result stats to be visible
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("result-stats")));
            WebElement stats = driver.findElement(By.id("result-stats"));
            return stats.isDisplayed();
        } catch (Exception e) {
            // Alternative: Check for search result containers
            try {
                return !driver.findElements(By.xpath("//div[@data-sokoban-container]")).isEmpty();
            } catch (Exception e2) {
                return false;
            }
        }
    }

    public String getResultStats() {
        try {
            return resultStats.getText();
        } catch (Exception e) {
            return "Stats not found";
        }
    }
}
