package UI.Elements.NewDefectPage;

import UI.Elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ComboboxByDefect extends BaseElement {

    private final String COMBOBOX_NAME_LOCATOR =
            "//label[text()='%s']//following-sibling::div[@class='flex-grow-1 css-2b097c-container']";

    public ComboboxByDefect(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectByVisibleText(String visibleText) {
        WebElement element = driver.findElement(By.xpath(String.format(COMBOBOX_NAME_LOCATOR, label)));
        if (visibleText != null) {
            scrollIntoView(element);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().sendKeys(visibleText).sendKeys(Keys.ENTER).build().perform();
        }
    }
}
