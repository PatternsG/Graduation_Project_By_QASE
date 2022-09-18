package UI.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {

    private static final By ICON_ACCOUNT_BUTTON = By.cssSelector(".X8BNLp");
    private static final By SING_OUT_BUTTON = By.xpath("//span[text()='Sign out']");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitWorElementOfDisplayed(ICON_ACCOUNT_BUTTON);
    }

    public void logOut() {
        waitWorElementOfDisplayed(ICON_ACCOUNT_BUTTON);
        driver.findElement(ICON_ACCOUNT_BUTTON).click();
        driver.findElement(SING_OUT_BUTTON).click();
    }
}
