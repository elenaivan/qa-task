package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.AbstractPageObject;

public class CareersPageObject extends AbstractPageObject {

    private By teamsSectionId = By.id("SectionTeams");

    public CareersPageObject(WebDriver driver, StringBuilder steps) {
        super(driver, steps);
    }

    public boolean isCareersPageLoaded() {
        return waitForElementVisible(teamsSectionId);
    }
}
