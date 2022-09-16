package UI.Tests;

import UI.DataProvider.SuiteDataProvider;
import UI.DataProvider.TestCaseDataProvider;
import UI.Models.Suite;
import UI.Models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteTests extends AfterTests {

    @Test(groups = {"Positive"},
            dataProvider = "suiteDataProvider", dataProviderClass = SuiteDataProvider.class)
    public void createSuitePositiveTest(Suite inputSuite) throws InterruptedException {
        loginPage.initialization(EMAIL, PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject("QASE");
        projectPage.waitForPageLoaded();
        projectPage.clickNewSuiteButton();
        newSuitePage.waitForPageLoaded();
        newSuitePage.fillForm(inputSuite);
        newSuitePage.clickSaveSuiteButton();
        Assert.assertEquals(newSuitePage.getAlertText(), "Suite was successfully created.");
    }

    @Test(groups = {"Delete_Suite", "Positive"}, dependsOnMethods = {"createSuitePositiveTest"},
            dataProvider = "testCaseDataProvider", dataProviderClass = TestCaseDataProvider.class)
    public void movingTestCasesToSuitePositiveTest(TestCase inputTestCase) throws InterruptedException {
        loginPage.initialization(EMAIL, PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject("QASE");
        projectPage.waitForPageLoaded();
        newSuitePage.createTestCase(inputTestCase);
        projectPage.invisibilityOfElementLocated();
        projectPage.movingTestCasesToSuite();
        Assert.assertEquals(projectPage.getAlertText(), "3 test cases were successfully updated");
        Thread.sleep(2000);
    }
}
