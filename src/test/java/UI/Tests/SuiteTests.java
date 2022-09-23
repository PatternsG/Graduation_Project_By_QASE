package UI.Tests;

import UI.DataProvider.SuiteDataProvider;
import UI.DataProvider.TestCaseDataProvider;
import UI.Models.Suite;
import UI.Models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteTests extends AfterTests {

    private final String EXPECTED_SUITE_CREATED = "Suite was successfully created.";
    private final String EXPECTED_TEST_CASE_UPDATE = "3 test cases were successfully updated";

    @Test(groups = {"Positive"},
            dataProvider = "suiteDataProvider", dataProviderClass = SuiteDataProvider.class)
    public void createSuitePositiveTest(Suite inputSuite) throws InterruptedException {
        loginPage.initialization(EMAIL, PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject(QASE);
        projectPage.waitForPageLoaded();
        projectPage.clickNewSuiteButton();
        newSuitePage.waitForPageLoaded();
        newSuitePage.fillForm(inputSuite);
        newSuitePage.clickSaveSuiteButton();
        Assert.assertEquals(newSuitePage.getAlertText(), EXPECTED_SUITE_CREATED);
    }

    @Test(groups = {"Delete_Suite", "Positive"}, dependsOnMethods = {"createSuitePositiveTest"},
            dataProvider = "testCaseDataProvider", dataProviderClass = TestCaseDataProvider.class)
    public void movingTestCasesToSuitePositiveTest(TestCase inputTestCase){
        loginPage.initialization(EMAIL, PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject(QASE);
        projectPage.waitForPageLoaded();
        newSuitePage.createTestCase(inputTestCase);
        projectPage.waitInvisibilityOfElementLocated();
        projectPage.movingTestCasesToSuite();
        Assert.assertEquals(projectPage.getAlertText(), EXPECTED_TEST_CASE_UPDATE);
    }
}
