package UI.Tests;

import UI.Utils.PropertyReader;
import org.testng.annotations.*;

public abstract class AfterTests extends BaseTest {

    private final String TEST_RUN_URL = PropertyReader.getProperty("qase.current_url.test_run_page");
    protected String QASE = PropertyReader.getProperty("qase.project.qase");
    protected String DEMO_PROJECT = PropertyReader.getProperty("qase.project.demo_project");
    protected String DEFECTS = PropertyReader.getProperty("qase.button_defects");
    protected String TEST_RUNS = PropertyReader.getProperty("qase.button_test_runs");

    @AfterGroups(value = "Delete_Test_Run", alwaysRun = true)
    public void deleteTestsRun() {
        driver.get("https://app.qase.io/login");
        loginPage.waitForPageLoaded();
        loginPage.initialization(EMAIL, PASSWORD);
        projectsPage.waitForPageLoaded();
        driver.get(TEST_RUN_URL);
        testRunsPage.waitForPageLoaded();
        testRunsPage.deleteTestRun();
        headerPage.logOut();
        loginPage.waitForPageLoaded();
    }

    @AfterGroups(value = "Delete_Test_Case", alwaysRun = true)
    public void deleteTestCase() {
        driver.get("https://app.qase.io/login");
        loginPage.waitForPageLoaded();
        loginPage.initialization(EMAIL, PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject(QASE);
        projectPage.waitForPageLoaded();
        projectPage.deleteTestCase();
        headerPage.logOut();
        loginPage.waitForPageLoaded();
    }

    @AfterGroups(value = "Delete_Defects", alwaysRun = true)
    public void deleteDefects() {
        driver.get("https://app.qase.io/login");
        loginPage.waitForPageLoaded();
        loginPage.initialization(EMAIL, PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject(DEMO_PROJECT);
        projectPage.waitForPageLoaded();
        projectPage.clickToSideBarButton(DEFECTS);
        defectsPage.waitForPageLoaded();
        defectsPage.deleteDefects();
        headerPage.logOut();
        loginPage.waitForPageLoaded();
    }

    @AfterGroups(value = "Delete_Suite", alwaysRun = true)
    public void deleteSuite() {
        driver.get("https://app.qase.io/login");
        loginPage.waitForPageLoaded();
        loginPage.initialization(EMAIL, PASSWORD);
        projectsPage.waitForPageLoaded();
        projectsPage.openProject(QASE);
        projectPage.waitForPageLoaded();
        projectPage.clickDeleteSuiteButton();
        headerPage.logOut();
        loginPage.waitForPageLoaded();
    }
}
