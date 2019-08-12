package support;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbstractBaseClass {

    protected WebDriver driver;

    protected AbstractBaseClass() {
    }

    public AbstractBaseClass(WebDriver driver) {
        this.driver = driver;
    }

    @Before
    public void initializeBrowser() {
        this.driver = new ChromeDriver();
    }

    @After
    public void closeBrowser() {
        driver.close();
    }
}
