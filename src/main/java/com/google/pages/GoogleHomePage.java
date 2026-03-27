package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model class for Google Home Page
 */
public class GoogleHomePage {

    private WebDriver driver;

    // Locators
    @FindBy(name = "q")
    private WebElement searchBox;

    // Constructor
    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods
    public void navigateToGoogle() {
        driver.navigate().to("https://www.google.com");
    }

    public void searchFor(String keyword) {
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(keyword);
    }

    public void pressEnter() {
        searchBox.submit();
    }

    public void searchAndSubmit(String keyword) {
        searchFor(keyword);
        pressEnter();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
