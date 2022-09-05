package Tests.Selenide;

import API_Utils.PropertyReader;
import Selenide_Pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class SelenideBaseTest {

    protected final String EMAIL = System.getenv().getOrDefault("EMAIL",
            PropertyReader.getProperty("qase.email"));
    protected final String PASSWORD = System.getenv().getOrDefault("PASSWORD",
            PropertyReader.getProperty("qase.password"));
    protected SelenideLoginPage loginPage;
    protected SelenideHomePage homePage;
    protected SelenideProjectsPage projectsPage;
    protected SelenideProjectPage projectPage;
    protected SelenideNewTestCasePage createTestCasePage;


    @BeforeClass
    public void setup() {
        loginPage = new SelenideLoginPage();
        homePage = new SelenideHomePage();
        projectsPage = new SelenideProjectsPage();
        projectPage = new SelenideProjectPage();
        createTestCasePage = new SelenideNewTestCasePage();
    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        loginPage.open();
    }
}
