package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.AbstractPageObject;

public class CareersPageObject extends AbstractPageObject {

    private By teamsSectionId = By.id("SectionTeams");

    // these selectors can be reused for any team
    private By chooseTeamSelector(String type) {
        return By.cssSelector("a[href=\"#"+type+"\"]");
    }
    private By getTeamOpenPositionsLinkSelector(String type) {
        return By.cssSelector("#"+type+" > div > a");
    }

    public CareersPageObject(WebDriver driver, StringBuilder steps) {
        super(driver, steps);
    }

    public boolean isCareersPageLoaded() {
        return isPageLoaded(teamsSectionId);
    }

    public void goToTeamOpenPositions(String teamType) {
        WebElement chooseTeamLink = waitForElementVisible(chooseTeamSelector(teamType));

        if (chooseTeamLink != null) {
            logTestStepDetail("User is going to the " + teamType + " open positions button");
            chooseTeamLink.click();

            WebElement teamOpenPositions = waitForElementVisible(getTeamOpenPositionsLinkSelector(teamType));
            if(teamOpenPositions != null) {
                teamOpenPositions.click();
            } else {
                logTestStepDetail("Team open positions button could not be found, please check.");
            }
        } else {
            logTestStepDetail("Team link could not be found, please check.");
        }
    }
}
