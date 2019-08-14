package support;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

    // waits until an element is displayed and returns the element, or null
    protected WebElement waitForElementVisible(By elementSelector) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element;

        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementSelector));
            return element;
        } catch (TimeoutException te) {
            return null;
        }
    }

    // waits until a list of elements is displayed and returns the list, or null
    protected List<WebElement> waitForElementsVisible(By elementSelector) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        List<WebElement> elements;

        try {
            elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementSelector));
            return elements;
        } catch (TimeoutException te) {
            return null;
        }
    }

}
