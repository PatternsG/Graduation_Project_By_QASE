package Selenide_Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class SelenideLoginPage extends SelenideBasePage {
    private final String EMAIL_LOCATOR = "#inputEmail";
    private final String PASSWORD_LOCATOR = "#inputPassword";
    private final String LOGIN_BUTTON_LOCATOR = "#btnLogin";
    private final static String URL = "https://app.qase.io/login";

    @Override
    public void waitForPageLoaded() {
        $(EMAIL_LOCATOR).should(Condition.visible);
    }

    public void initialization(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLogin();
    }

    public void open() {
        Selenide.open(URL);
    }

    private void setEmail(String email) {
        $(EMAIL_LOCATOR).setValue(email);

    }

    private void setPassword(String password) {
        $(PASSWORD_LOCATOR).setValue(password);
    }

    private void clickLogin() {
        $(LOGIN_BUTTON_LOCATOR).click();
    }
}
