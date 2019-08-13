package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.AbstractPageObject;

public class OpenPositionsPageObject extends AbstractPageObject {

    private By productEngineeringSection = By.id("product-engineering");

    private By getJobSelector(String job) {
        return By.partialLinkText(job);
    }

    public OpenPositionsPageObject(WebDriver driver, StringBuilder steps) {
        super(driver, steps);
    }

    public boolean isPageLoaded() {
        return waitForElementVisible(productEngineeringSection) != null;
    }

    public JobDescriptionPageObject goToJobDescription(String job) {
        WebElement chooseJobSelector = waitForElementVisible(getJobSelector(job));

        if (chooseJobSelector != null) {
            logTestStepDetail("User is going to the " + job + " job description page");
            chooseJobSelector.click();

            return new JobDescriptionPageObject(driver, testStepDetails);

        } else {
            logTestStepDetail("Job could not be found, please check.");
            return null;
        }
    }

}