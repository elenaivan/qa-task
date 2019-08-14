package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.AbstractPageObject;

public class JobDescriptionPageObject extends AbstractPageObject {

    private By sectionDescriptionSelector = By.id("SectionApplication");

    private By jobTitleSelector = By.xpath("//*[@id=\"SectionDetails\"]/section[1]/div/h1");
    private By jobDescriptionSelector = By.xpath("//*[@id=\"SectionDetails\"]/section[2]/div/section[1]");

    private By responsibilitiesListSelector = By.xpath("//*[@id=\"SectionDetails\"]/section[2]/div/section[2]/ul/li");
    private By candidateRequirementsListSelector = By.xpath("//*[@id=\"SectionDetails\"]/section[2]/div/section[3]/ul/li");

    private By applyNowButton = By.cssSelector("#SectionApplication > div > a");

    public JobDescriptionPageObject(WebDriver driver, StringBuilder steps) {
        super(driver, steps);
    }

    public boolean isJobDescriptionPageLoaded() {
        return isPageLoaded(sectionDescriptionSelector);
    }

    public String getJobTitle() {
        logTestStepDetail("User is verifying the job title.");
        return waitForElementVisible(jobTitleSelector).getText();
    }

    public String getJobDescription() {
        logTestStepDetail("User is verifying the job description.");
        return waitForElementVisible(jobDescriptionSelector).getText();
    }

    public int getJobResponsibilities() {
        int totalResponsibilities = waitForElementsVisible(responsibilitiesListSelector).size();
        logTestStepDetail("There are " + totalResponsibilities + " for this job.");
        return totalResponsibilities;
    }

    public int getCandidateRequirementsList() {
        int totalRequirements = waitForElementsVisible(candidateRequirementsListSelector).size();
        logTestStepDetail("There are " + totalRequirements + " for this job.");
        return totalRequirements;
    }

    public void applyToJob() {
        logTestStepDetail("User wants to apply to the job!");
        waitForElementVisible(applyNowButton).click();
        switchToNewTab();
    }
}
