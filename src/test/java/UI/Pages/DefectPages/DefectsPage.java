package UI.Pages.DefectPages;

import UI.Elements.NewDefectPage.GetTextDefects;
import UI.Enums.TestCase.Severity;
import UI.Models.Defects;
import UI.Pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class DefectsPage extends BasePage {
    private final static By ALERT_LOCATOR = By.xpath("//span[@class = 'OL6rtE']");
    private final static By PAGE_LOADED_LOCATOR = By.xpath("//th[text()='External']");
    private final static By CREATE_NEW_DEFECTS_BUTTON = By.cssSelector(".btn.btn-primary");
    private final static By LAST_DEFECT_LOCATOR = By.xpath("(//a[@class='defect-title'])[1]");
    private final static By TWO_DEFECT_LOCATOR = By.xpath
            ("(//tr[@class='project-row'])[2]//div[@class='dropdown']//i");
    private final static By DELETE_DEFECT_LOCATOR = By.xpath
            ("(//tr[@class='project-row'])[2]//div[@class='dropdown']//a[@class='text-danger']");
    private final static By TITLE_LOCATOR = By.xpath("//button[@class='sYQsX9']//ancestor::h1");
    private final static By DELETION_CONFIRMATION_LOCATOR = By.xpath("//span[text()='Delete']");
    private final static By DEFECT_TITLE = By.xpath("//a[@class='defect-title']");

    public DefectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitWorElementOfDisplayed(PAGE_LOADED_LOCATOR);
    }

    public void clickCreateNewDefectsButton() {
        driver.findElement(CREATE_NEW_DEFECTS_BUTTON).click();
    }

    public void clickLastDefectButton() {
        driver.findElement(LAST_DEFECT_LOCATOR).click();
        waitWorElementOfDisplayed(TITLE_LOCATOR);
    }

    public String getAlertText() {
        return driver.findElement(ALERT_LOCATOR).getText();
    }

    public Defects getDefectInfo() {
        Defects.DefectsBuilder defectsBuilder = Defects.builder();
        String defectTitle = new GetTextDefects(driver, "Defect title").getTitleText();
        if (defectTitle != "") {
            defectsBuilder.defectTitle(defectTitle);
        }
        String actualResult = new GetTextDefects(driver, "Actual result").getHeaderText();
        if (actualResult != "") {
            defectsBuilder.actualResult(actualResult);
        }
        String severity = new GetTextDefects(driver, "Severity").getGenericText();
        if (severity != "") {
            defectsBuilder.severity(Severity.fromString(severity));
        }
        String assignee = new GetTextDefects(driver, "Assignee").getGenericText();
        if (assignee != "") {
            defectsBuilder.assignee(assignee);
        }
        return defectsBuilder.build();
    }

    public boolean haveOrNot() {
        try {
            driver.findElement(TWO_DEFECT_LOCATOR).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void deleteDefects() {
        log.info("Remove all defects until 1 remains");
        List<WebElement> allDefects = driver.findElements(DEFECT_TITLE);
        int size = allDefects.size();
        if (size > 1) {
            for (int i = 1; i < size; i++) {
                driver.findElement(TWO_DEFECT_LOCATOR).click();
                driver.findElement(DELETE_DEFECT_LOCATOR).click();
                waitWorElementOfDisplayed(DELETION_CONFIRMATION_LOCATOR);
                driver.findElement(DELETION_CONFIRMATION_LOCATOR).click();
                waitForPageLoaded();
                driver.navigate().refresh();
            }
        }
    }

}
