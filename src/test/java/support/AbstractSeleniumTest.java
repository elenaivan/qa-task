package support;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class AbstractSeleniumTest {

    protected WebDriver driver;
    protected StringBuilder testStepDetails = new StringBuilder();

    public void switchToNewTab() {
        // considering there is only one new tab opened
        if (driver.getWindowHandles().size() > 1) {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            // change focus to new tab
            driver.switchTo().window(tabs.get(1));
        }
    }

    @Before
    public void initialize() {
        this.driver = new ChromeDriver();
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

}
