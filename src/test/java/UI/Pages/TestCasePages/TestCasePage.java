package UI.Pages.TestCasePages;

import UI.Elements.TestCasePage.Combobox;
import UI.Elements.TestCasePage.GetTextTestCase;
import UI.Enums.TestCase.*;
import UI.Models.TestCase;
import UI.Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCasePage extends BasePage {

    private final static By PAGE_LOADED_LOCATOR = By.xpath("//div[@class='_1x6QT uoG20c']");
    private final static By SUITE_LOCATOR = By.xpath("//span[@class='DvbSwG']");

    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitWorElementOfDisplayed(PAGE_LOADED_LOCATOR);
    }

    public String getSuiteText() {
        return driver.findElement(SUITE_LOCATOR).getText();
    }

    public void clickCloseTestCase() {
        Actions actions = new Actions(driver);
        actions.moveByOffset(1, 1).click().build().perform();
    }

    public TestCase getTestCaseInfo() {
        TestCase.TestCaseBuilder testCaseBuilder = TestCase.builder().suite(getSuiteText());
        String title = new GetTextTestCase(driver, "Title").getTitleText();
        if (title != "") {
            testCaseBuilder.title(title);
        }
        String status = new Combobox(driver, "Status").getText();
        if (status != "") {
            testCaseBuilder.status(Status.fromString(status));
        }
        String description = new GetTextTestCase(driver, "Description").getHeaderText();
        if (description != "") {
            testCaseBuilder.description(description);
        }
        String severity = new Combobox(driver, "Severity").getText();
        if (severity != "") {
            testCaseBuilder.severity(Severity.fromString(severity));
        }
        String priority = new Combobox(driver, "Priority").getText();
        if (priority != "") {
            testCaseBuilder.priority(Priority.fromString(priority));
        }
        String type = new Combobox(driver, "Type").getText();
        if (type != "") {
            testCaseBuilder.type(Type.fromString(type));
        }
        String layer = new Combobox(driver, "Layer").getText();
        if (layer != "") {
            testCaseBuilder.layer(Layer.fromString(layer));
        }
        String isFlaky = new Combobox(driver, "Is flaky").getText();
        if (isFlaky != "") {
            testCaseBuilder.isFlaky(Bool.fromString(isFlaky));
        }
        String automationStatus = new Combobox(driver, "Automation status").getText();
        if (automationStatus != "") {
            testCaseBuilder.automationStatus(AutomationStatus.fromString(automationStatus));
        }
        String preConditions = new GetTextTestCase(driver, "Pre-conditions").getHeaderText();
        if (preConditions != "") {
            testCaseBuilder.preConditions(preConditions);
        }
        String postConditions = new GetTextTestCase(driver, "Post-conditions").getHeaderText();
        if (postConditions != "") {
            testCaseBuilder.postConditions(postConditions);
        }
        return testCaseBuilder.build();
    }

    @Override
    public String currentURL() {
        return driver.getCurrentUrl();
    }
}
