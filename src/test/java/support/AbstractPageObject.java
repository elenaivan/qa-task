package support;

import org.openqa.selenium.WebDriver;

public class AbstractPageObject {

    protected WebDriver driver;
    protected StringBuilder testStepDetails;

    public AbstractPageObject(WebDriver driver, StringBuilder steps) {
        this.driver = driver;
        this.testStepDetails = steps;
    }

    protected void logTestStepDetail(String message) {
        System.out.println(testStepDetails.append(message));
    }

    public void goToPage(String url) {
        logTestStepDetail("User is trying to open:" + url);
        driver.get(url);
    }

}
