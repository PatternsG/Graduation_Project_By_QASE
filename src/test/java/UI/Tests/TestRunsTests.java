package UI.Tests;

import UI.DataProvider.TestCaseDataProvider;
import UI.Models.TestCase;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestRunsTests extends AfterTests {

    @Test(groups = {"Delete_Test_Case", "Positive"},
            dataProvider = "testCaseDataProvider", dataProviderClass = TestCaseDataProvider.class)
    public void createTestRunPositiveTest(TestCase testCase) {
        loginPage.initialization(EMAIL, PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject("QASE");
        projectPage.waitForPageLoaded();
        projectPage.clickNewTestCaseButton();
        newTestCasePage.waitForPageLoaded();
        newTestCasePage.fillForm(testCase);
        newTestCasePage.clickSaveButton();
        projectPage.waitForPageLoaded();
        projectPage.invisibilityOfElementLocated();
        projectPage.clickToSideBarButton("Test Runs");
        testRunsPage.waitForPageLoaded();
        testRunsPage.clickNewTestRunButton();
        createTestRunPage.waitForPageLoaded();
        createTestRunPage.clickAddCasesButton();
        createTestRunPage.clickSuiteButton();
        createTestRunPage.addTestCases();
        Assert.assertEquals(testRunsPage.getAlertText(), "Run was created successfully!");
    }

    @Test(groups = {"Delete_Test_Run", "Positive"}, dependsOnMethods = {"createTestRunPositiveTest"})
    public void startTestRunPositiveTest() {
        loginPage.initialization(EMAIL, PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject("QASE");
        projectPage.waitForPageLoaded();
        projectPage.clickToSideBarButton("Test Runs");
        testRunsPage.waitForPageLoadedWhitTestRuns();
        testRunsPage.clickTestRunButton();
        testRunsDashboardPage.waitForPageLoaded();
        testRunsDashboardPage.assignToMember();
        testRunsDashboardPage.selectMember();
        testRunsDashboardPage.clickAssignButton();
        testRunsDashboardPage.passedTestCases();
        Assert.assertEquals(testRunsDashboardPage.actualResult(), "Completed 100%");
    }

    @Test(groups = "Negative")
    public void createTestRunNegativeTest() {
        loginPage.initialization(EMAIL, PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject("QASE");
        projectPage.waitForPageLoaded();
        projectPage.clickToSideBarButton("Test Runs");
        testRunsPage.waitForPageLoaded();
        testRunsPage.clickNewTestRunButton();
        createTestRunPage.waitForPageLoaded();
        createTestRunPage.clickStartRunButton();
        Assert.assertEquals(testRunsDashboardPage.getAlertText(), "The cases field is required when include all cases is not present.");
    }
}
