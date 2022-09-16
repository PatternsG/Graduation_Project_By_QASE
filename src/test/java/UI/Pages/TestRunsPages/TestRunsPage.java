package UI.Pages.TestRunsPages;

import UI.Pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class TestRunsPage extends BasePage {

    private static final By NEW_TEST_RUN_BUTTON = By.xpath("//div[@class='me-3']/a[@class='btn btn-primary']");
    private static final By ALERT_LOCATOR = By.xpath("//div[@role='alert']");
    private static final By TEST_RUN_NAME = By.xpath("//a[@class='defect-title']");
    private static final By DROPDOWN_BUTTON_LOCATOR = By.xpath("(//i[@class='fa fa-ellipsis-h'])[1]");
    private static final By DELETE_BUTTON_LOCATOR = By.xpath("(//a[@class='text-danger'])[1]");
    private static By DELETION_CONFIRMATION_LOCATOR = By.cssSelector(".btn.btn-cancel");

    public TestRunsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitWorElementOfDisplayed(NEW_TEST_RUN_BUTTON);
    }

    public void waitForPageLoadedWhitTestRuns() {
        waitWorElementOfDisplayed(TEST_RUN_NAME);
    }

    @Override
    public String currentURL() {
        String currentURL = driver.getCurrentUrl();
        return currentURL;
    }

    public void clickNewTestRunButton() {
        driver.findElement(NEW_TEST_RUN_BUTTON).click();
    }

    public String getAlertText() {
        return driver.findElement(ALERT_LOCATOR).getText();
    }

    public void clickTestRunButton() {
        driver.findElement(TEST_RUN_NAME).click();
    }

    public void deleteTestRun() {
        log.info("Delete created test run");
        List<WebElement> elements = driver.findElements(TEST_RUN_NAME);
        for (int i = elements.size(); i > 0; i--) {
            driver.findElement(DROPDOWN_BUTTON_LOCATOR).click();
            driver.findElement(DELETE_BUTTON_LOCATOR).click();
            waitWorElementOfDisplayed(DELETION_CONFIRMATION_LOCATOR);
            driver.findElement(DELETION_CONFIRMATION_LOCATOR).click();
            waitForPageLoaded();
        }
    }
}
