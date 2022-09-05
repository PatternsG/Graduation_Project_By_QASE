package Selenide_Pages;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class SelenideProjectPage extends SelenideHomePage {
    private final String NEW_TEST_CASE_BUTTON_LOCATOR =
            "#create-case-button";
    private final String DEFECTS_NAVIGATION_MENU_ITEM = "a[title = 'Defects']";

    @Override
    public void waitForPageLoaded() {
        $(NEW_TEST_CASE_BUTTON_LOCATOR)
                .should(Condition.visible, Duration.ofSeconds(30))
                .should(Condition.enabled, Duration.ofSeconds(30));
    }

    public void clickCreateTestCaseButton() {
        $(NEW_TEST_CASE_BUTTON_LOCATOR).click();
    }

    public void clickDefects() {
        $(DEFECTS_NAVIGATION_MENU_ITEM).scrollTo().click();
    }
}
