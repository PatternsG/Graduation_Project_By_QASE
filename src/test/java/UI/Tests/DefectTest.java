package UI.Tests;

import UI.DataProvider.DefectDataProvider;
import UI.Models.Defects;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DefectTest extends AfterTests {

    private final String EXPECTED_DEFECT_CREATED = "Defect was created successfully!";

    @Test(groups = {"Delete_Defects", "Positive"}, dataProvider = "defectDataProvider",
            dataProviderClass = DefectDataProvider.class)
    public void createDefectPositiveTest(Defects inputDefect){
        loginPage.setEmail(EMAIL);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        projectsPage.waitForPageLoaded();
        projectsPage.openProject(DEMO_PROJECT);
        projectPage.waitForPageLoaded();
        projectPage.clickToSideBarButton(DEFECTS);
        defectsPage.waitForPageLoaded();
        defectsPage.clickCreateNewDefectsButton();
        newDefectPage.waitForPageLoaded();
        newDefectPage.fillForm(inputDefect);
        newDefectPage.clickCreateDefectButton();
        defectsPage.waitForPageLoaded();
        defectsPage.clickLastDefectButton();
        Assert.assertEquals(defectsPage.getAlertText(), EXPECTED_DEFECT_CREATED);
        Assert.assertEquals(defectsPage.getDefectInfo(), inputDefect);

    }

    @Test(groups = {"Negative"})
    public void createDefectNegativeTest() {
        loginPage.setEmail(EMAIL);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        projectsPage.waitForPageLoaded();
        projectsPage.openProject(DEMO_PROJECT);
        projectPage.waitForPageLoaded();
        projectPage.clickToSideBarButton(DEFECTS);
        defectsPage.waitForPageLoaded();
        defectsPage.clickCreateNewDefectsButton();
        newDefectPage.waitForPageLoaded();
        Assert.assertEquals(newDefectPage.currentURL(), NEW_DEFECT_URL);
    }
}
