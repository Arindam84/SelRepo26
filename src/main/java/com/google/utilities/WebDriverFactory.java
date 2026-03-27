package com.google.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Factory class to manage WebDriver initialization
 */
public class WebDriverFactory {

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        
        // Check if running in CI environment (GitHub Actions)
        String ciEnvironment = System.getenv("CI");
        if (ciEnvironment != null && ciEnvironment.equalsIgnoreCase("true")) {
            // Enable headless mode for CI/GitHub Actions
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            System.out.println("Running in headless mode (CI Environment)");
        } else {
            // Normal mode for local execution
            System.out.println("Running in headed mode (Local)");
        }
        
        return new ChromeDriver(options);
    }

    public static void quitDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
