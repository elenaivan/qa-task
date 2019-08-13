package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.AbstractPageObject;

public class CareersPageObject extends AbstractPageObject {

    private By teamsSectionId = By.id("SectionTeams");

    private By productEngineeringTeamButton = By.cssSelector("a[href=\"/en/corporate/jobs#product-engineering\"]");

    // this can be reused for any team
    private By chooseTeamSelector(String type) {
        return By.cssSelector("a[href=\"#"+type+"\"]");
    }

/*  Todo: make this work
    it doesn't work at the moment, when using it below in the method, returns a NULL pointer exception
    the selector might need rework */
    private By getTeamOpenPositionsLinkSelector(String type) {
        return By.cssSelector("a[href=\"/en/corporate/jobs#"+type+"\"]");
    }

    public CareersPageObject(WebDriver driver, StringBuilder steps) {
        super(driver, steps);
    }

    public boolean isCareersPageLoaded() {
        return waitForElementVisible(teamsSectionId) != null;
    }

    public OpenPositionsPageObject goToTeamOpenPositions(String teamType) {

        WebElement chooseTeamLink = waitForElementVisible(chooseTeamSelector(teamType));

        if (chooseTeamLink != null) {
            logTestStepDetail("User is going to the " + teamType + " open positions button");
            chooseTeamLink.click();

            // unfortunately, we break the reusability here of the method to go to the Product Engineering team

            driver.findElement(productEngineeringTeamButton).click();
            return new OpenPositionsPageObject(driver, testStepDetails);

        } else {
            logTestStepDetail("Team link could not be found, please check.");
            return null;
        }
    }

}
