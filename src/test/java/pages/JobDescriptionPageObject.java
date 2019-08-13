package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.AbstractPageObject;

public class JobDescriptionPageObject extends AbstractPageObject {

    private By sectionDescriptionSelector = By.id("SectionApplication");

    private By responsibilitiesList = By.cssSelector("#SectionDetails > section._3jhK2kfTM6Xm > div > section:nth-child(2) > ul li");
    private By candidateRequirementsList = By.cssSelector("#SectionDetails > section._3jhK2kfTM6Xm > div > section:nth-child(3) > ul li");

    public JobDescriptionPageObject(WebDriver driver, StringBuilder steps) {
        super(driver, steps);
    }

    public boolean isPageLoaded() {
        return driver.findElement(sectionDescriptionSelector).isDisplayed();
    }

    public int getJobResponsibilities() {
        return driver.findElements(responsibilitiesList).size();
    }

    public int getCandidateRequirementsList() {
        return driver.findElements(candidateRequirementsList).size();
    }


}
