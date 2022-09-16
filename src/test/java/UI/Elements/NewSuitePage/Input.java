package UI.Elements.NewSuitePage;

import UI.Elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Input extends BaseElement {

    private final String INPUT_LOCATOR = "(//label[text()='%s']//following-sibling::div/input)[1]";

    public Input(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        WebElement element = driver.findElement(By.xpath(String.format(INPUT_LOCATOR, label)));
        if (value != null) {
            scrollIntoView(element);
            element.sendKeys(value);
        }
    }
}
