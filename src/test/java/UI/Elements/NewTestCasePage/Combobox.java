package UI.Elements.NewTestCasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Combobox extends BaseCombobox {

    private final String COMBOBOX_BUTTON_LOCATOR = "//label[text()='%s']";
    private final String COMBOBOX_OPTIONS = "//div[contains (@class, 'DJXdnf')]//following-sibling::div[text()='%s']";

    public Combobox(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectByVisibleText(String visibleText) {
        WebElement locator = driver.findElement(By.xpath(String.format(COMBOBOX_BUTTON_LOCATOR, label)));
        if (visibleText != null) {
            scrollIntoView(locator);
            locator.click();
            WebElement options = driver.findElement(By.xpath(String.format(COMBOBOX_OPTIONS, visibleText)));
            scrollIntoView(options);
            options.click();
        }
    }
}
