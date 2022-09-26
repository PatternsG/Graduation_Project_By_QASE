package UI.Pages.TestCasePages;

import UI.Elements.NewTestCasePage.ComboboxByTestCase;
import UI.Elements.NewTestCasePage.Input;
import UI.Elements.NewTestCasePage.MultiLineInput;
import UI.Models.TestCase;
import UI.Pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewTestCasePage extends BasePage {

    public final static By SAVE_BUTTON = By.id("save-case");
    private final static By NEW_CASE_BUTTON = By.id("create-case-button");
    private final static By SUITE_CREATE_BUTTON = By.id("create-suite-button");

    public NewTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitWorElementOfDisplayed(SAVE_BUTTON);
    }

    public void fillForm(TestCase inputTestCase) {
        new Input(driver, "Title")
                .setValue(inputTestCase.getTitle());
        new ComboboxByTestCase(driver, "Status")
                .selectByVisibleText(inputTestCase.getStatus().getName());
        new MultiLineInput(driver, "Description")
                .setValue(inputTestCase.getDescription());
        new ComboboxByTestCase(driver, "Suite")
                .selectByVisibleText(inputTestCase.getSuite());
        new ComboboxByTestCase(driver, "Severity")
                .selectByVisibleText(inputTestCase.getSeverity().getName());
        new ComboboxByTestCase(driver, "Priority")
                .selectByVisibleText(inputTestCase.getPriority().getName());
        new ComboboxByTestCase(driver, "Type")
                .selectByVisibleText(inputTestCase.getType().getName());
        new ComboboxByTestCase(driver, "Layer")
                .selectByVisibleText(inputTestCase.getLayer().getName());
        new ComboboxByTestCase(driver, "Is flaky")
                .selectByVisibleText(inputTestCase.getIsFlaky().getName());
        new ComboboxByTestCase(driver, "Automation status")
                .selectByVisibleText(inputTestCase.getAutomationStatus().getName());
        new MultiLineInput(driver, "Pre-conditions").
                setValue(inputTestCase.getPreConditions());
        new MultiLineInput(driver, "Post-conditions").
                setValue(inputTestCase.getPostConditions());
    }

    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
    }
    public void clickNewTestCaseButton() {
        driver.findElement(NEW_CASE_BUTTON).click();
    }

    public void createTestCase(TestCase inputTestCase, int size) {
        log.info("Creation of 3 test cases");
        for (int i = 0; i < size; i++) {
            clickNewTestCaseButton();
            waitForPageLoaded();
            fillForm(inputTestCase);
            clickSaveButton();
            waitWorElementOfDisplayed(SUITE_CREATE_BUTTON);
        }
    }
}
