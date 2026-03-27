# Selenium Google Search - POM Project

This is a Java-based Selenium automation project using the **Page Object Model (POM)** design pattern with **Maven** and **TestNG**.

## Project Structure

```
SeleniumGoogleSearch/
├── pom.xml                                    # Maven configuration
├── src/
│   ├── main/java/com/google/
│   │   ├── pages/
│   │   │   ├── GoogleHomePage.java           # POM for Google home page
│   │   │   └── GoogleResultsPage.java        # POM for Google results page
│   │   └── utilities/
│   │       └── WebDriverFactory.java         # WebDriver management utility
│   └── test/
│       ├── java/com/google/tests/
│       │   └── GoogleSearchTest.java         # Test class
│       └── resources/
│           └── testng.xml                    # TestNG configuration
└── README.md                                  # This file
```

## Features

- **Page Object Model (POM)**: Separate page classes for better maintainability
- **Maven**: Build and dependency management
- **TestNG**: Testing framework with assertions
- **WebDriverManager**: Automatic ChromeDriver management
- **Chrome Browser**: Launches Google.com, searches for "Clause", and hits Enter

## Technologies Used

- Selenium WebDriver 4.15.0
- TestNG 7.9.0
- Maven 3.x
- Java 11+
- WebDriverManager 5.6.3

## Prerequisites

- Java 11 or higher installed
- Maven installed and configured
- Chrome browser installed
- Maven settings properly configured

## How to Run

### Run via Maven

```bash
cd SeleniumGoogleSearch
mvn clean test
```

### Run specific test

```bash
mvn clean -Dtest=GoogleSearchTest test
```

## Test Execution Flow

1. **Setup Phase**:
   - Initializes Chrome WebDriver
   - Maximizes browser window
   - Initializes Page Objects

2. **Test Phase**:
   - Navigates to https://www.google.com
   - Verifies Google home page loads
   - Types "Clause" in the search box
   - Presses Enter to search
   - Waits for results to load
   - Verifies search results are displayed
   - Prints search statistics

3. **Teardown Phase**:
   - Closes the browser
   - Releases WebDriver resources

## Test Details

**Test Name**: `testGoogleSearchForClause`

**What it does**:
- Launches Google.com in Chrome browser
- Types "Clause" in the search box
- Presses Enter to execute the search
- Verifies that search results are displayed
- Captures and prints result statistics

## Logging

The test will output logs to the console showing:
- WebDriver initialization
- Navigation steps
- Search keyword
- Results verification
- Statistics
- WebDriver closure

## Extensions/Future Enhancements

- Add page wait strategies (Explicit/Implicit waits)
- Add screenshot capture on test failure
- Add test data parameterization
- Add cross-browser testing
- Add API testing integration
- Add performance metrics collection

## Author Notes

This project follows POM best practices:
- Separate concerns (Page objects, utilities, tests)
- Reusable components
- Easy to maintain and scale
- Clear test flow and assertions
