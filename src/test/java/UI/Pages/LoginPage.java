package UI.Pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {

    private final static By EMAIL_LOCATOR = By.cssSelector("[name = 'email']");
    private final static By PASSWORD_LOCATOR = By.cssSelector("[name = 'password']");
    private final static By LOGIN_BUTTON_LOCATOR = By.xpath("//button[text()='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitWorElementOfDisplayed(LOGIN_BUTTON_LOCATOR);
    }

    public void initialization(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    public void setEmail(String email) {
        driver.findElement(EMAIL_LOCATOR).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(PASSWORD_LOCATOR).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
    }

    public boolean isDisplayed() {
        log.info("Checking which page you are on");
        try {
            driver.findElement(LOGIN_BUTTON_LOCATOR).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
