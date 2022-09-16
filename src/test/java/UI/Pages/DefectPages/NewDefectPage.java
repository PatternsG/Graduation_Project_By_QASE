package UI.Pages.DefectPages;

import UI.Elements.NewDefectPage.Combobox;
import UI.Elements.NewDefectPage.Input;
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

    public String currentURL() {
        String currentURL = driver.getCurrentUrl();
        return currentURL;
    }

    public void fillForm(Defects inputDefects) {
        new Input(driver, "Defect title").setValue(inputDefects.getDefectTitle());
        new Input(driver, "Actual result").setValue(inputDefects.getActualResult());
        new Combobox(driver, "Severity").selectByVisibleText(inputDefects.getSeverity().getName());
        new Combobox(driver, "Assignee").selectByVisibleText(inputDefects.getAssignee().getName());
    }

    public void clickCreateDefectButton() {
        driver.findElement(CREATE_DEFECT_BUTTON).click();
    }

}
