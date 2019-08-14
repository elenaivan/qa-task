package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.AbstractPageObject;

public class ApplicationPageObject extends AbstractPageObject {

    private By jobTitleSelector = By.xpath("/html/body/div[3]/div/div[1]/div/h2");

    public ApplicationPageObject(WebDriver driver, StringBuilder steps) {
        super(driver, steps);
    }

    public boolean isApplicationPageLoaded() {
        logTestStepDetail("User is on the Application form page.");
        return isPageLoaded(jobTitleSelector);
    }

    public String getJobTitle() {
        return waitForElementVisible(jobTitleSelector).getText();
    }
}
