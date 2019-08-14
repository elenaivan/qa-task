package test;

import org.junit.Assert;
import org.junit.Test;
import pages.*;
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
        freeleticsWebsite.openCareersPage();

        CareersPageObject careersPage = new CareersPageObject(driver, testStepDetails);
        // the message is used in case the assertion fails
        Assert.assertTrue("Careers page failed to open.", careersPage.isCareersPageLoaded());
        careersPage.goToTeamOpenPositions(teamType);

        OpenPositionsPageObject openPositionsPage = new OpenPositionsPageObject(driver, testStepDetails);
        Assert.assertTrue("Open positions failed to open.", openPositionsPage.isPageLoaded());
        openPositionsPage.goToJobDescription(job);

        JobDescriptionPageObject jobDescriptionPage = new JobDescriptionPageObject(driver, testStepDetails);
        Assert.assertTrue("Job description page failed to open.", jobDescriptionPage.isPageLoaded());

        // title assertion
        String jobTitle = jobDescriptionPage.getJobTitle().toUpperCase();
        System.out.println(jobTitle);
        Assert.assertTrue("Job title is not the same as you expect from the test.", jobTitle.contains(job.toUpperCase()));

        // description assertion
        String jobDescription = jobDescriptionPage.getJobDescription();
        Assert.assertTrue("Job description appears to be empty.", !jobDescription.isEmpty());

        int jobResponsibilitiesTotalNumber = jobDescriptionPage.getJobResponsibilities();
        Assert.assertEquals("Number of responsibilities is not met.", jobResponsibilitiesTotalNumber, 9 );

        int candidateRequirementsTotalNumber = jobDescriptionPage.getCandidateRequirementsList();
        Assert.assertEquals("Number of candidate requirements is not met.", candidateRequirementsTotalNumber, 7 );

        // apply now button
        jobDescriptionPage.applyToJob();

        ApplicationPageObject applicationPage = new ApplicationPageObject(driver, testStepDetails);
        Assert.assertTrue("Application page failed to open.", applicationPage.isPageLoaded());

        String applicationJobTitle = applicationPage.getJobTitle();
        System.out.println(applicationJobTitle);

    }

}
