package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.AbstractPageObject;

public class WebsiteMainPageObject extends AbstractPageObject {

    private By careersLinkSelector = By.xpath("//*[@id=\"root\"]/article/footer/ul/li[2]/ul/li[1]/a");

    public WebsiteMainPageObject(WebDriver driver, StringBuilder steps) {
        super(driver, steps);
    }

    private boolean isCareersLinkDisplayed() {
        return waitForElementVisible(careersLinkSelector);
    }

    public CareersPageObject openCareersPage() {
        if (isCareersLinkDisplayed()) {
            driver.findElement(careersLinkSelector).click();
            logTestStepDetail("User is trying to go to Careers page");
            return new CareersPageObject(driver, testStepDetails);
        }
        else {
            logTestStepDetail("Element is not on the page! Careers page couldn't be opened");
            return null;
        }
    }

}
