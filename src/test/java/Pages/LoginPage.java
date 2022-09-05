package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    private By EMAIL_LOCATOR = By.cssSelector("[name = 'email']");
    private By PASSWORD_LOCATOR = By.cssSelector("[name = 'password']");
    private By LOGIN_BUTTON_LOCATOR = By.xpath("//button[text()='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void initialization(String email, String password) {
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
}
