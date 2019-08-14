package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.AbstractPageObject;

public class WebsiteMainPageObject extends AbstractPageObject {

    private By careersLinkSelector = By.xpath("//*[@id=\"root\"]/article/footer/ul/li[2]/ul/li[1]/a");

    public WebsiteMainPageObject(WebDriver driver, StringBuilder steps) {
        super(driver, steps);
    }

    private boolean isCareersLinkDisplayed() {
        return waitForElementVisible(careersLinkSelector) != null;
    }

    public void openCareersPage() {
        if (isCareersLinkDisplayed()) {
            driver.findElement(careersLinkSelector).click();
            logTestStepDetail("User is trying to go to Careers page");
        } else {
            logTestStepDetail("Element is not on the page! Careers page couldn't be opened");
        }
    }
}
