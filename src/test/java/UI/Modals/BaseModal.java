package UI.Modals;

import UI.Pages.BasePage;
import org.openqa.selenium.WebDriver;

public class BaseModal extends BasePage {

    public BaseModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }

    @Override
    public String currentURL() {
        return null;
    }
}
