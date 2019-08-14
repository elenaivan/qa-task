package support;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

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

    // checks if a page is loaded by the presence of an selector
    protected boolean isPageLoaded(By selector) {
        return waitForElementVisible(selector) != null;
    }

    // switches to a new tab
    protected void switchToNewTab() {
        Set<String> handles = driver.getWindowHandles();
        if(handles.size() > 1) {
            try {
                String currentHandle = driver.getWindowHandle();

                for (String handle : handles) {
                    if (!handle .equals(currentHandle)) {
                        driver.switchTo().window(handle);
                    }
                }
            } catch(NullPointerException exception) {
                logTestStepDetail("Something didn't work at switching tabs.");
            }
        }
        else {
            logTestStepDetail("No new tab was opened.");
        }
    }
}
