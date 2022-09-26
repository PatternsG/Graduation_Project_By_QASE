package UI.Tests;

import UI.DataProvider.TestCaseDataProvider;
import UI.Models.TestCase;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestRunsTests extends AfterTests {

    private final String EXPECTED_TEST_RUN_CREATED = "Run was created successfully!";
    private final String EXPECTED_TEST_RUN_PASSED = "Completed 100%";
    private final String EXPECTED_TEST_RUN_NOT_CREATED =
            "The cases field is required when include all cases is not present.";
    @Test(groups = {"Delete_Test_Case", "Positive"},
            dataProvider = "testCaseDataProvider", dataProviderClass = TestCaseDataProvider.class)
    public void createTestRunPositiveTest(TestCase testCase) {
        loginPage.initialization(EMAIL, PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject(QASE);
        projectPage.waitForPageLoaded();
        projectPage.clickNewTestCaseButton();
        newTestCasePage.waitForPageLoaded();
        newTestCasePage.fillForm(testCase);
        newTestCasePage.clickSaveButton();
        projectPage.waitForPageLoaded();
        projectPage.waitInvisibilityOfElementLocated();
        projectPage.clickToSideBarButton(TEST_RUNS);
        testRunsPage.waitForPageLoaded();
        testRunsPage.clickNewTestRunButton();
        createTestRunPage.waitForPageLoaded();
        createTestRunPage.clickAddCasesButton();
        createTestRunPage.clickSuiteButton();
        createTestRunPage.addTestCases(3);
        Assert.assertEquals(testRunsPage.getAlertText(), EXPECTED_TEST_RUN_CREATED);
    }

    @Test(groups = {"Delete_Test_Run", "Positive"}, dependsOnMethods = {"createTestRunPositiveTest"})
    public void startTestRunPositiveTest() {
        loginPage.initialization(EMAIL, PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject(QASE);
        projectPage.waitForPageLoaded();
        projectPage.clickToSideBarButton(TEST_RUNS);
        testRunsPage.waitForPageLoadedWhitTestRuns();
        testRunsPage.clickTestRunButton();
        testRunsDashboardPage.waitForPageLoaded();
        testRunsDashboardPage.assignToMember();
        testRunsDashboardPage.selectMember();
        testRunsDashboardPage.clickAssignButton();
        testRunsDashboardPage.passedTestCases();
        Assert.assertEquals(testRunsDashboardPage.actualResult(), EXPECTED_TEST_RUN_PASSED);
    }

    @Test(groups = "Negative")
    public void createTestRunNegativeTest() {
        loginPage.initialization(EMAIL, PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject(QASE);
        projectPage.waitForPageLoaded();
        projectPage.clickToSideBarButton(TEST_RUNS);
        testRunsPage.waitForPageLoaded();
        testRunsPage.clickNewTestRunButton();
        createTestRunPage.waitForPageLoaded();
        createTestRunPage.clickStartRunButton();
        Assert.assertEquals(testRunsDashboardPage.getAlertText(),
                EXPECTED_TEST_RUN_NOT_CREATED);
    }
}
