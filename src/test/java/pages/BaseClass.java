package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class BaseClass {

    protected WebDriver driver;

    protected BaseClass() {
        driver = new FirefoxDriver();
    }
}
