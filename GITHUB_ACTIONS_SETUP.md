# GitHub Actions Setup Guide

This project is configured to run Selenium tests automatically on GitHub Actions.

## Workflow Details

The workflow is defined in `.github/workflows/test.yml` and performs the following steps:

### Trigger Events
- **Push**: Automatically runs tests when code is pushed to `main`, `master`, or `develop` branches
- **Pull Request**: Automatically runs tests on pull requests targeting these branches

### Workflow Steps

1. **Checkout Code**: Clones the repository
2. **Setup JDK 11**: Installs Java 11 using the Temurin distribution
3. **Install Chrome**: Installs Chrome browser for Selenium tests
4. **Cache Maven Dependencies**: Caches Maven packages to speed up builds
5. **Run Tests**: Executes Maven tests with `CI=true` environment variable
6. **Upload Test Results**: Saves test artifacts and reports
7. **Publish Test Report**: Publishes TestNG results as a GitHub check

## Environment Variables

When running in GitHub Actions, the workflow automatically sets:
```
CI=true
```

This enables **headless mode** in the WebDriver configuration, allowing tests to run without a display.

## Test Execution in CI

### Headless Configuration
When `CI=true` is detected, ChromeDriver runs with:
- `--headless=new`: Headless mode
- `--no-sandbox`: Sandbox disabled (required for CI)
- `--disable-dev-shm-usage`: Disables shared memory usage
- `--window-size=1920,1080`: Sets window size for consistent rendering

### Local vs CI Execution

**Local Machine** (headed mode):
```bash
mvn clean test
```
Browser window will be visible.

**GitHub Actions** (headless mode):
```bash
CI=true mvn clean test
```
Browser runs in headless mode without display.

## Viewing Test Results

### In GitHub
1. Go to **Actions** tab in your repository
2. Click on the workflow run to see details
3. View **Test Results** under the job summary
4. Download **test-results** artifact for detailed reports

### Test Report Files
- `target/surefire-reports/` - XML test reports
- `target/surefire-reports/index.html` - HTML test report

## Artifacts

The workflow uploads the following artifacts:
- **test-results**: Complete TestNG XML reports for all test runs

## Debugging Workflow

To debug workflow issues:

1. **Check Workflow Logs**:
   - Go to Actions → Select workflow run
   - Expand each step to see logs

2. **Common Issues**:
   - Chrome installation failure: Workflow automatically handles this
   - Java version mismatch: Ensure JDK 11 is specified
   - Dependency issues: Maven cache helps, but can be cleared if needed

3. **Enable Debug Logging**:
   Add `--debug` flag to Maven command in workflow

## Schedule Tests (Optional)

To run tests on a schedule, add to `.github/workflows/test.yml`:

```yaml
on:
  schedule:
    - cron: '0 2 * * *'  # Daily at 2 AM UTC
```

## Setup Instructions

1. **Push Code to GitHub**:
   ```bash
   git init
   git add .
   git commit -m "Initial commit"
   git branch -M main
   git remote add origin https://github.com/YOUR-USERNAME/SeleniumGoogleSearch.git
   git push -u origin main
   ```

2. **Enable Actions** (if needed):
   - Go to repository Settings → Actions
   - Ensure "Allow all actions and reusable workflows" is selected

3. **View Workflow Runs**:
   - Go to Actions tab
   - All workflow runs are listed with status

## Next Steps

- Monitor workflow runs after each push
- Fix any failing tests promptly
- Review test reports in artifacts
- Consider adding more tests to the suite
