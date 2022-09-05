package Selenide_Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SelenideProjectsPage extends SelenideHomePage {

    @Override
    public void waitForPageLoaded() {
    }

    public void openProject(String name) {
        final String PROJECT_ITEM_XPATH_EXPRESSION =
                "//table[contains(@class, 'projects-table')]//a[text()='%s']";
        $(By.xpath(String.format(PROJECT_ITEM_XPATH_EXPRESSION, name)))
                .scrollTo().click();
    }
}
