package UI.Tests;

import UI.DataProvider.DefectDataProvider;
import UI.Models.Defects;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DefectTest extends AfterTests {

    @Test(groups = {"Delete_Defects", "Positive"}, dataProvider = "defectDataProvider",
            dataProviderClass = DefectDataProvider.class)
    public void createDefectPositiveTest(Defects inputDefect) throws InterruptedException {
        loginPage.setEmail(EMAIL);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        projectsPage.waitForPageLoaded();
        projectsPage.openProject("Demo Project");
        projectPage.waitForPageLoaded();
        projectPage.clickToSideBarButton("Defects");
        defectsPage.waitForPageLoaded();
        defectsPage.clickCreateNewDefectsButton();
        newDefectPage.waitForPageLoaded();
        newDefectPage.fillForm(inputDefect);
        newDefectPage.clickCreateDefectButton();
        defectsPage.waitForPageLoaded();
        defectsPage.clickLastDefectButton();
        Assert.assertEquals(defectsPage.getAlertText(), "Defect was created successfully!");
        Assert.assertEquals(defectsPage.getDefectInfo(), inputDefect);

    }

    @Test(groups = {"Negative"})
    public void createDefectNegativeTest() {
        loginPage.setEmail(EMAIL);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        projectsPage.waitForPageLoaded();
        projectsPage.openProject("Demo Project");
        projectPage.waitForPageLoaded();
        projectPage.clickToSideBarButton("Defects");
        defectsPage.waitForPageLoaded();
        defectsPage.clickCreateNewDefectsButton();
        newDefectPage.waitForPageLoaded();
        Assert.assertEquals(newDefectPage.currentURL(), NEW_DEFECT_URL);
    }
}
