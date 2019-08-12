package pages;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class BaseClass {

    protected WebDriver driver;

    protected BaseClass() {
        driver = new ChromeDriver();
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

}
