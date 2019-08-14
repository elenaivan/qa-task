package support;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbstractSeleniumTest {

    protected WebDriver driver;
    protected StringBuilder testStepDetails = new StringBuilder();

    @Before
    public void initialize() {
        this.driver = new ChromeDriver();
    }

    @After
    public void closeBrowser() {
        driver.close();
    }
}
