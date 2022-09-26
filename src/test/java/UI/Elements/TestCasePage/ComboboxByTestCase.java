package UI.Elements.TestCasePage;

import UI.Elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComboboxByTestCase extends BaseElement {

    private final String COMBOBOX_LOCATOR = "//div[@class='RZYgph']//ancestor::div[@class='tuLXOo']" +
            "//div//label[text()='%s']//following-sibling::div//*[@class='RZYgph']";

    public ComboboxByTestCase(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getText() {
        WebElement elem = driver.findElement(By.xpath(String.format(COMBOBOX_LOCATOR, label)));
        scrollIntoView(elem);
        return elem.getText();
    }
}
