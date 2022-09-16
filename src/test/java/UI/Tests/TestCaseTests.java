package UI.Tests;

import UI.DataProvider.TestCaseDataProvider;
import UI.Models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseTests extends AfterTests {

    @Test(groups = {"Delete_Test_Case", "Positive"},
            dataProvider = "testCaseDataProvider", dataProviderClass = TestCaseDataProvider.class)
    public void createTestCasePositiveTest(TestCase inputTestCase) {
        loginPage.setEmail(EMAIL);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        projectsPage.waitForPageLoaded();
        projectsPage.openProject("QASE");
        projectPage.waitForPageLoaded();
        projectPage.clickNewTestCaseButton();
        newTestCasePage.waitForPageLoaded();
        newTestCasePage.fillForm(inputTestCase);
        newTestCasePage.clickSaveButton();
        String actualResult = projectPage.getAlertText();
        testCasePage.getSuiteText();
        projectPage.clickTestCaseButton();
        testCasePage.waitForPageLoaded();
        Assert.assertEquals(actualResult, "Test case was created successfully!");
        Assert.assertEquals(testCasePage.getTestCaseInfo(), inputTestCase);
        testCasePage.clickCloseTestCase();
    }

    @Test(groups = {"Negative"})
    public void createTestCaseNegativeTest() {
        loginPage.initialization(EMAIL, PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject("QASE");
        projectPage.waitForPageLoaded();
        projectPage.clickNewTestCaseButton();
        newTestCasePage.waitForPageLoaded();
        newTestCasePage.clickSaveButton();
        Assert.assertFalse(projectPage.haveOrNot());
    }
}
