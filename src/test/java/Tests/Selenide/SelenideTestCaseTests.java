package Tests.Selenide;

import DataProvider.TestCaseDataProvider;
import Models.TestCase;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

public class SelenideTestCaseTests extends SelenideBaseTest {

    @Test(dataProvider = "testCaseDataProvider",
            dataProviderClass = TestCaseDataProvider.class)
    public void addTestCase(TestCase inputTestCase) {
        loginPage.initialization(EMAIL, PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject("Test");
        projectPage.waitForPageLoaded();
        projectPage.clickCreateTestCaseButton();
        createTestCasePage.waitForPageLoaded();
        createTestCasePage.fillForm(inputTestCase);
        createTestCasePage.clickSave();
        projectPage.getAlert().should(
                Condition.matchText("Test case was created successfully!"));
    }
}
