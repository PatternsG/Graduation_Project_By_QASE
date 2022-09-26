package UI.Pages.DefectPages;

import UI.Elements.NewDefectPage.ComboboxByDefect;
import UI.Elements.NewTestCasePage.Input;
import UI.Models.Defects;
import UI.Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewDefectPage extends BasePage {

    private final static By CREATE_DEFECT_BUTTON = By.xpath("//button[text()='Create defect']");

    public NewDefectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitWorElementOfDisplayed(CREATE_DEFECT_BUTTON);
    }

    public void fillForm(Defects inputDefects) {
        new Input(driver, "Defect title").setValue(inputDefects.getDefectTitle());
        new Input(driver, "Actual result").setValue(inputDefects.getActualResult());
        new ComboboxByDefect(driver, "Severity").selectByVisibleText(inputDefects.getSeverity().getName());
        new ComboboxByDefect(driver, "Assignee").selectByVisibleText(inputDefects.getAssignee());
    }

    public void clickCreateDefectButton() {
        driver.findElement(CREATE_DEFECT_BUTTON).click();
    }

}
