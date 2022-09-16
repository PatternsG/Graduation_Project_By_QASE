package UI.Elements.TestCasePage;

import UI.Elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetTextTestCase extends BaseElement {

    private final static By TITLE_LOCATOR = By.xpath("//div[@class='_1x6QT uoG20c']");
    private final String HEADER_LOCATOR = "//label[ text()='%s' and @class='e6R61R']/following-sibling::div//p";

    public GetTextTestCase(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getTitleText() {
        WebElement elem = driver.findElement(TITLE_LOCATOR);
        scrollIntoView(elem);
        return elem.getText();
    }

    public String getHeaderText() {
        WebElement elem = driver.findElement(By.xpath(String.format(HEADER_LOCATOR, label)));
        scrollIntoView(elem);
        return elem.getText();
    }
}
