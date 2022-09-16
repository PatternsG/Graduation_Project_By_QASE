package UI.Pages.TestRunsPages;

import UI.Enums.Defects.Assignee;
import UI.Enums.TestRuns.TestStatus;
import UI.Enums.TestRuns.UpdateSelected;
import UI.Pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

@Log4j2
public class TestRunsDashboardPage extends BasePage {

    private final static By PAGE_LOADED_LOCATOR = By.xpath("//button[@class='add-filter-button']");
    private final static By CONTROL_INDICATOR = By.xpath("(//span[@class='custom-control-indicator'])[1]");
    private final static By UPDATE_SELECTED_LOCATOR = By.id("dropdownMenuLink");
    private final static By SELECT_MEMBER = By.xpath("//div[@class=' css-1hwfws3']");
    private final static By ASSIGN_BUTTON_LOCATOR = By.xpath("//button[@class='btn btn-primary']");
    private final static By OPEN_WIZARD_BUTTON = By.id("open-wizard");
    private final static By CLOSE_VERIFIED_TEST_CASE = By.xpath("//i[@class='fal fa-times']");
    private static final By ALERT_LOCATOR = By.xpath("//div[@role='alert']");
    private final static By COMPLETION_RATE_LOCATOR = By.xpath
            ("//span[text()='Completion rate']//following-sibling::span");
    private final static By TITLE_TASTE_CASE_LOCATOR = By.xpath
            ("//div[@class='run-case-row-div run-case-row-result text-start' and not(child::*)]");
    private final static String STATUS_LOCATOR = "//button[text()=' %s' and contains (@class, 'p2WI5n')]";
    private final static By CANCEL_CREATE_RUN_TEST = By.xpath("//button[@class='btn btn-invisible-danger b-0']");
    private final static By CLOSE_FORM = By.xpath("//button[@class='btn btn-danger']");
    private final static String DROPDOWN_ITEM =
            "//div[@class='dropdown-menu dropdown-menu-end show']/div/a[text()='%s']";

    public TestRunsDashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitWorElementOfDisplayed(PAGE_LOADED_LOCATOR);
    }

    @Override
    public String currentURL() {
        return null;
    }

    public void assignToMember() {
        log.info("Selecting updates for test cases");
        driver.findElement(CONTROL_INDICATOR).click();
        driver.findElement(UPDATE_SELECTED_LOCATOR).click();
        driver.findElement(By.xpath(String.format(DROPDOWN_ITEM, UpdateSelected.ASSIGN.getName()))).click();
    }

    public void selectMember() {
        log.info("Appointment of an executor for test cases");
        WebElement element = driver.findElement(SELECT_MEMBER);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().sendKeys
                (Assignee.KOVALEVSIY_IVAN.getName()).sendKeys(Keys.ENTER).build().perform();
    }

    public void clickAssignButton() {
        driver.findElement(ASSIGN_BUTTON_LOCATOR).click();
    }

    public void passedTestCases() {
        log.info("Passing the test run");
        List<WebElement> testCases = driver.findElements(TITLE_TASTE_CASE_LOCATOR);
        for (int i = 0; i < testCases.size(); i++) {
            waitWorElementOfDisplayed(OPEN_WIZARD_BUTTON);
            driver.findElement(OPEN_WIZARD_BUTTON).click();
            WebElement element = driver.findElement(By.xpath(String.format(STATUS_LOCATOR, TestStatus.PASSED.getName())));
            element.click();
            driver.findElement(CLOSE_VERIFIED_TEST_CASE).click();
        }
    }

    public String actualResult() {
        driver.navigate().refresh();
        waitWorElementOfDisplayed(COMPLETION_RATE_LOCATOR);
        String element = driver.findElement(COMPLETION_RATE_LOCATOR).getText();
        return element;
    }

    public String getAlertText() {
        WebElement element = driver.findElement(ALERT_LOCATOR);
        String message = element.getText();
        driver.findElement(CANCEL_CREATE_RUN_TEST).click();
        driver.findElement(CLOSE_FORM).click();
        return message;
    }
}
