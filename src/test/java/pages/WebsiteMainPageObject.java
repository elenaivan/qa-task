package pages;

import org.openqa.selenium.WebDriver;
import support.AbstractBaseClass;

public class WebsiteMainPageObject extends AbstractBaseClass {

    public WebsiteMainPageObject(WebDriver driver) {
        super(driver);
    }

    public void goToPage(String url) {
        driver.get(url);
    }

}
