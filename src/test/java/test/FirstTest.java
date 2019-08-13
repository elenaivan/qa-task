package test;

import org.junit.Assert;
import org.junit.Test;
import pages.CareersPageObject;
import pages.WebsiteMainPageObject;
import support.AbstractSeleniumTest;

public class FirstTest extends AbstractSeleniumTest {

    public String url = "http://freeletics.com";

    @Test
    public void openCareersPage() {

        WebsiteMainPageObject mp = new WebsiteMainPageObject(driver, testStepDetails);
        mp.goToPage(url);
        Assert.assertTrue(driver.getTitle().contains("FREELETICS"));

        CareersPageObject cp = mp.openCareersPage();
        Assert.assertTrue("Careers page failed to open.", cp.isCareersPageLoaded());
    }
}
