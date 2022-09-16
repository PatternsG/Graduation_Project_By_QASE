package UI.Elements.NewTestCasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MultiLineInput extends Input {

    public final String INPUT_LOCATOR = "//label[text()='%s']/following-sibling::div" +
            "//div[@class ='ProseMirror toastui-editor-contents']";

    public MultiLineInput(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        WebElement locator = driver.findElement(By.xpath(String.format(INPUT_LOCATOR, label)));
        if (value != null) {
            scrollIntoView(locator);
            locator.sendKeys(value);
        }
    }
}
