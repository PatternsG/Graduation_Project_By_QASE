package UI.Elements.NewDefectPage;

import UI.Elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetTextDefects extends BaseElement {
    private final static By DESCRIPTION_LOCATOR = By.xpath
            ("//p[text()='Description']//following-sibling::div//p");
    private final static By TITLE_LOCATOR = By.xpath
            ("//button[@class='sYQsX9']//ancestor::h1");
    private final String GENERIC_LOCATOR = "//div[@class='OZIk_I' and text()='%s']//following-sibling::div";

    public GetTextDefects(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getHeaderText() {
        WebElement element = driver.findElement(DESCRIPTION_LOCATOR);
        scrollIntoView(element);
        return element.getText();
    }

    public String getTitleText() {
        WebElement element = driver.findElement(TITLE_LOCATOR);
        scrollIntoView(element);
        return element.getText();
    }

    public String getGenericText() {
        WebElement element = driver.findElement(By.xpath(String.format(GENERIC_LOCATOR, label)));
        scrollIntoView(element);
        return element.getText();
    }
}
