package UI.Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProjectsPage extends BasePage {

    private static final By PAGE_LOADED_LOCATOR = By.xpath("//th[@class = 'hidden-xs']");
    private String PROJECT_LOCATOR = "//table[contains(@class, 'projects-table')]//a[text()='%s']";

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitWorElementOfDisplayed(PAGE_LOADED_LOCATOR);
    }

    @Override
    public String currentURL() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    public boolean isDisplayed() {
        return driver.findElement(PAGE_LOADED_LOCATOR).isDisplayed();
    }

    public void openProject(String name) {
        By locator = By.xpath(String.format(PROJECT_LOCATOR, name));
        driver.findElement(locator).click();
    }

    public boolean haveOrNot() {
        log.info("Find element on page");
        try {
            driver.findElement(PAGE_LOADED_LOCATOR).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
