package test;

import org.junit.Assert;
import org.junit.Test;
import pages.WebsiteMainPageObject;
import support.AbstractSeleniumTest;

public class FirstTest extends AbstractSeleniumTest {

    public String url = "http://xing.com";

    @Test
    public void display() {

        WebsiteMainPageObject mp = new WebsiteMainPageObject(driver);

        mp.goToPage(url);
        Assert.assertTrue(driver.getTitle().contains("XING"));
    }
}
