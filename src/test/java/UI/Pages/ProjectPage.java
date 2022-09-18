package UI.Pages;

import UI.Utils.PropertyReader;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Log4j2
public class ProjectPage extends BasePage {

    private final static By SUITE_CREATE_BUTTON = By.id("create-suite-button");
    private final static By NEW_CASE_BUTTON = By.id("create-case-button");
    private final static By ALERT_LOCATOR = By.xpath("//span[@class = 'OL6rtE']");
    private final static By LAST_CASE_LOCATOR = By.xpath("//div[@class='jp0OXJ vxJTrJ']//a");
    private final static By TEST_CASE_BLOCK_LOCATOR = By.xpath("//div[@class='F8M2Vb eS8b4a']");
    private final static By DELETE_TEST_CASE_BUTTON = By.xpath("//button[@class='btn btn-secondary me-2']");
    private final static By DELETE_FORM_CONTROL = By.xpath("//input[@class='form-control']");
    private final static By DELETE_LAST_BUTTON = By.xpath("//span[text()='Delete']");
    private final static By ALL_CHECKBOX_LOCATOR = By.xpath("//span[@class='rKnGli WkeLop']/input");
    private final static By UPDATE_SUITE_BUTTON_LOCATOR = By.xpath("//button[@class='btn btn-primary']");
    private final static By CHOICE_OF_SUITE_BUTTON_LOCATOR = By.xpath
            ("//span[text()='Suite']//ancestor::label//following-sibling::div");
    private final static By EDITE_BUTTON_LOCATOR = By.xpath
            ("//button[@class='btn btn-secondary me-3' and text() = ' Edit']");
    private final static By CONFIRM_DELETE_SUITE_BUTTON = By.xpath("//button[@class='LzLtDS DRnS3P MBIQEc']");
    private final String DELETE_SUITE_BUTTON = "//span[text()='%s']//following-sibling::div//i[@class='far fa-trash']";
    private final String CHOICE_OF_SUITE_DROPDOWN = "//div[@class='DJXdnf' and text()='%s']";
    private final String CHECKBOX_LOCATOR = "(//div[@class='jp0OXJ xofNTA']//preceding-sibling::div" +
            "//span[contains (@class, 'rKnGli GyAaw8')])[%s]";
    private final String SIDE_BAR_BUTTON_LOCATOR = "//span[text()='%s']";
    private final String TEST_CASE_NAME_LOCATOR = "//div[contains (@class, 'jp0OXJ')]" +
            "/following-sibling::div/a[text()='%s']";
    private final String SUITE_NAME = PropertyReader.getProperty("qase.suite_name");
    private final String CONFIRM = "CONFIRM";

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitWorElementOfDisplayed(SUITE_CREATE_BUTTON);
    }

    public void waitInvisibilityOfElementLocated() {
        log.info("Waiting for an element to disappear");
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.invisibilityOfElementLocated(ALERT_LOCATOR));
    }

    public void clickToSideBarButton(String buttonName) {
        By locator = By.xpath(String.format(SIDE_BAR_BUTTON_LOCATOR, buttonName));
        driver.findElement(locator).click();
    }

    public void clickTestCaseButton() {
        driver.findElement(By.xpath(String.format(TEST_CASE_NAME_LOCATOR, getLastCaseName()))).click();
    }

    public void clickNewTestCaseButton() {
        driver.findElement(NEW_CASE_BUTTON).click();
    }

    public String getAlertText() {
        return driver.findElement(ALERT_LOCATOR).getText();
    }

    public String getLastCaseName() {
        List<WebElement> elem = driver.findElements(LAST_CASE_LOCATOR);
        String lastElem = elem.get(elem.size() - 1).getText();
        return lastElem;
    }

    public void deleteTestCase() {
        log.info("Deleting test cases if there are more than 3");
        List<WebElement> elements = driver.findElements(TEST_CASE_BLOCK_LOCATOR);
        if (elements.size() > 3) {
            waitForPageLoaded();
            driver.findElement(ALL_CHECKBOX_LOCATOR).click();
            for (int i = elements.size(), j = 0; j < 3; j++) {
                driver.findElement(By.xpath(String.format(CHECKBOX_LOCATOR, i))).click();
                i--;
            }
            driver.findElement(DELETE_TEST_CASE_BUTTON).click();
            driver.findElement(DELETE_FORM_CONTROL).sendKeys(CONFIRM);
            driver.findElement(DELETE_LAST_BUTTON).click();
        }
    }

    public void movingTestCasesToSuite() {
        log.info("Selecting and transferring test cases to the created suite");
        List<WebElement> elements = driver.findElements(TEST_CASE_BLOCK_LOCATOR);
        int size = elements.size();
        for (int i = 0, j = size; i < 3; i++) {
            if (j >= 1) {
                WebElement elem = driver.findElement(By.xpath(String.format(CHECKBOX_LOCATOR, j)));
                elem.click();
                j--;
            } else break;
        }
        driver.findElement(EDITE_BUTTON_LOCATOR).click();
        waitWorElementOfDisplayed(CHOICE_OF_SUITE_BUTTON_LOCATOR);
        driver.findElement(CHOICE_OF_SUITE_BUTTON_LOCATOR).click();
        driver.findElement(By.xpath(String.format(CHOICE_OF_SUITE_DROPDOWN, SUITE_NAME))).click();
        driver.findElement(UPDATE_SUITE_BUTTON_LOCATOR).click();

    }

    public boolean haveOrNot() {
        try {
            driver.findElement(ALERT_LOCATOR).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickNewSuiteButton() {
        driver.findElement(SUITE_CREATE_BUTTON).click();
    }

    public void clickDeleteSuiteButton() {
        log.info("Deleting a created suite");
        WebElement element = driver.findElement(By.xpath(String.format(DELETE_SUITE_BUTTON, SUITE_NAME)));
        element.click();
        driver.findElement(CONFIRM_DELETE_SUITE_BUTTON).click();
        waitForPageLoaded();
    }
}
