package UI.Tests;

import UI.Pages.DefectPages.DefectsPage;
import UI.Pages.DefectPages.NewDefectPage;
import UI.Pages.SuitePages.NewSuitePage;
import UI.Pages.TestCasePages.NewTestCasePage;
import UI.Pages.TestCasePages.TestCasePage;
import UI.Pages.TestRunsPages.CreateTestRunPage;
import UI.Pages.TestRunsPages.TestRunsDashboardPage;
import UI.Pages.TestRunsPages.TestRunsPage;
import UI.Utils.PropertyReader;
import UI.Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected final String EMAIL = System.getenv().getOrDefault("EMAIL",
            PropertyReader.getProperty("qase.email"));
    protected final String PASSWORD = System.getenv().getOrDefault("PASSWORD",
            PropertyReader.getProperty("qase.password"));
    protected final String NEW_DEFECT_URL = System.getenv().getOrDefault("NEW_DEFECT_URL",
            PropertyReader.getProperty("qase.current_url.new_defect_page"));
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;
    protected ProjectPage projectPage;
    protected DefectsPage defectsPage;
    protected NewDefectPage newDefectPage;
    protected TestCasePage testCasePage;
    protected NewTestCasePage newTestCasePage;
    protected TestRunsPage testRunsPage;
    protected CreateTestRunPage createTestRunPage;
    protected TestRunsDashboardPage testRunsDashboardPage;
    protected HeaderPage headerPage;
    protected NewSuitePage newSuitePage;

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setup(/*@Optional("chrome")*/ String browser, ITestContext testContext) throws Exception {
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new Exception("Browser is not correct");
        }
        testContext.setAttribute("driver", driver);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);
        newSuitePage = new NewSuitePage(driver);
        projectsPage = new ProjectsPage(driver);
        projectPage = new ProjectPage(driver);
        defectsPage = new DefectsPage(driver);
        newDefectPage = new NewDefectPage(driver);
        testCasePage = new TestCasePage(driver);
        newTestCasePage = new NewTestCasePage(driver);
        testRunsPage = new TestRunsPage(driver);
        createTestRunPage = new CreateTestRunPage(driver);
        testRunsDashboardPage = new TestRunsDashboardPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        driver.get("https://app.qase.io/login");
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        if (loginPage.isDisplayed() == false) {
            headerPage.logOut();
            loginPage.waitForPageLoaded();
        }
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
