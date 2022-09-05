package Tests;

import Pages.LoginPage;
import API_Utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected final String EMAIL = System.getenv().getOrDefault("EMAIL",
            PropertyReader.getProperty("qase.email"));
    protected final String PASSWORD = System.getenv().getOrDefault("PASSWORD",
            PropertyReader.getProperty("qase.password"));
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        driver.get("https://app.qase.io/login");
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }

    @AfterClass(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
