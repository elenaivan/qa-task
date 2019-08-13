package test;

import org.junit.Assert;
import org.junit.Test;
import pages.CareersPageObject;
import pages.OpenPositionsPageObject;
import pages.WebsiteMainPageObject;
import pages.JobDescriptionPageObject;
import support.AbstractSeleniumTest;

public class QAPositionTest extends AbstractSeleniumTest {

    private String url = "http://freeletics.com";
    private String teamType = "product-engineering";
    private String job = "QA Engineer";

    @Test
    public void openCareersPage() {
        WebsiteMainPageObject freeleticsWebsite = new WebsiteMainPageObject(driver, testStepDetails);
        freeleticsWebsite.goToPage(url);
        Assert.assertTrue(driver.getTitle().contains("FREELETICS"));

        CareersPageObject careersPage = freeleticsWebsite.openCareersPage();
        Assert.assertTrue("Careers page failed to open.", careersPage.isCareersPageLoaded());

        OpenPositionsPageObject openPositions = careersPage.goToTeamOpenPositions(teamType);
        Assert.assertTrue("Open positions failed to open.", ((OpenPositionsPageObject) openPositions).isPageLoaded());

        JobDescriptionPageObject jobDescription = openPositions.goToJobDescription(job);
        Assert.assertTrue("Job description page failed to open.", jobDescription.isPageLoaded());

        int jobResponsibilitiesTotalNumber = jobDescription.getJobResponsibilities();
        Assert.assertTrue("Number of responsibilities is not met.", jobResponsibilitiesTotalNumber == 9 );
        System.out.println("There are " + jobResponsibilitiesTotalNumber + " responsibilities for this job");

        int candidateRequirementsTotalNumber = jobDescription.getCandidateRequirementsList();
        Assert.assertTrue("Number of candidate requirements is not met.", candidateRequirementsTotalNumber == 7 );
        System.out.println("There are " + candidateRequirementsTotalNumber + " candidate requirements for this job");

    }

}
