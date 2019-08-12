package support;

import org.openqa.selenium.WebDriver;

public class AbstractPageObject {

    protected WebDriver driver;
    protected StringBuilder testStepDetails;

    protected static final String PRINTOUT_NEW_LINE = "\n";

    public AbstractPageObject(WebDriver driver, StringBuilder steps) {
        this.driver = driver;
        this.testStepDetails = steps;
    }

    protected void logTestStepDetail(String message) {
        System.out.println(testStepDetails.append(message));
    }

    public void goToPage(String url) {
        logTestStepDetail("User is trying to go to ..." + url);
        driver.get(url);
    }

}
