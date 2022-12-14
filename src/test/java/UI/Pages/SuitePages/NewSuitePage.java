package UI.Pages.SuitePages;

import UI.Elements.NewTestCasePage.Input;
import UI.Models.Suite;
import UI.Pages.BasePage;
import UI.Pages.ProjectPage;
import UI.Pages.TestCasePages.NewTestCasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewSuitePage extends BasePage {
    private final static By SAVE_SUITE_BUTTON_LOCATOR = By.id("save-suite-button");
    private final static By ALERT_LOCATOR = By.xpath("//span[@class = 'OL6rtE']");

    public NewSuitePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitWorElementOfDisplayed(SAVE_SUITE_BUTTON_LOCATOR);
    }

    public void fillForm(Suite inputSuite) {
        new Input(driver, "Suite name").setValue(inputSuite.getSuiteName());
        new Input(driver, "Description").setValue(inputSuite.getDescription());
        new Input(driver, "Preconditions").setValue(inputSuite.getPreconditions());
    }

    public void clickSaveSuiteButton() {
        driver.findElement(SAVE_SUITE_BUTTON_LOCATOR).click();
    }

    public String getAlertText() {
        return driver.findElement(ALERT_LOCATOR).getText();
    }
}
