package support;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPageObject {

    protected WebDriver driver;
    protected StringBuilder testStepDetails;

    public AbstractPageObject(WebDriver driver, StringBuilder steps) {
        this.driver = driver;
        this.testStepDetails = steps;
    }

    protected void logTestStepDetail(String message) {
        System.out.println(message);
    }

    public void goToPage(String url) {
        logTestStepDetail("User is trying to open: " + url);
        driver.get(url);
    }

    protected WebElement waitForElementVisible(By elementSelector) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element;

        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementSelector));
            return element;
        } catch (TimeoutException te) {
            return null;
        }
    }

}
