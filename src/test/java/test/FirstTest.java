package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.WebsiteMainPageObject;
import support.AbstractBaseClass;

public class FirstTest extends AbstractBaseClass {

    public String url = "http://xing.com";

    @Test
    public void display() {
        WebsiteMainPageObject mp = new WebsiteMainPageObject(driver);
        mp.goToPage(url);
        Assert.assertTrue(driver.getTitle().contains("XING"));
    }
}
