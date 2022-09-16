package UI.Pages.TestRunsPages;

import UI.Pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class CreateTestRunPage extends BasePage {

    private final static By ADD_CASES_BUTTON = By.xpath("//button[@id='edit-run-add-cases-button']");
    private final static By SUITE_LOCATOR = By.xpath("//p[@class='suite-title']");
    private final static By TEST_CASES_LOCATOR = By.xpath
            ("//div[@class='cases-block']//span[@class='custom-control-indicator']");
    private final static By DONE_BUTTON = By.id("select-cases-done-button");
    private final static By START_RUN_BUTTON = By.id("save-run-button");

    public CreateTestRunPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitWorElementOfDisplayed(ADD_CASES_BUTTON);
    }

    @Override
    public String currentURL() {
        String currentURL = driver.getCurrentUrl();
        return currentURL;
    }

    public void clickStartRunButton() {
        driver.findElement(START_RUN_BUTTON).click();
    }

    public void clickAddCasesButton() {
        WebElement elem = driver.findElement(ADD_CASES_BUTTON);
        scrollIntoView(elem);
        elem.click();
    }

    public void clickSuiteButton() {
        driver.findElement(SUITE_LOCATOR).click();
    }

    public void addTestCases() {
        log.info("Adding Test Cases to a Test Run");
        List<WebElement> elem = driver.findElements(TEST_CASES_LOCATOR);
        for (int i = 1; i < 4; i++) {
            if (elem.size() - i < 0) {
                break;
            }
            WebElement element = elem.get(elem.size() - i);
            scrollIntoView(element);
            element.click();
        }
        driver.findElement(DONE_BUTTON).click();
        driver.findElement(START_RUN_BUTTON).click();
    }
}
