package UI.Elements.NewTestCasePage;

import UI.Elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Input extends BaseElement {

    public final String INPUT_LOCATOR = "//label[text()='%s']//following-sibling::div/input";

    public Input(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        WebElement inputValue = driver.findElement(By.xpath(String.format(INPUT_LOCATOR, label)));
        if (value != null) {
            scrollIntoView(inputValue);
            inputValue.sendKeys(value);
        }
    }
}
