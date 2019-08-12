package support;

import org.openqa.selenium.WebDriver;

public class AbstractPageObject {

    protected WebDriver driver;

    public AbstractPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage(String url) {
        driver.get(url);
    }

}
