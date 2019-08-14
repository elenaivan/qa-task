package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.AbstractPageObject;

public class ApplicationPageObject extends AbstractPageObject {

    private By jobTitleSelector = By.cssSelector("div .section .page-centered .posting-header > h2");

    public ApplicationPageObject(WebDriver driver, StringBuilder steps) {
        super(driver, steps);
    }

    public boolean isPageLoaded() {
        return waitForElementVisible(jobTitleSelector) != null;
    }

    public String getJobTitle() {
        return waitForElementVisible(jobTitleSelector).getText();
    }


}
