package UI.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends AfterTests {

    @Test(groups = {"Positive"})
    public void authorizationPositiveTest() {
        loginPage.setEmail(EMAIL);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        projectsPage.waitForPageLoaded();
        Assert.assertTrue(projectsPage.isDisplayed());
    }

    @Test(groups = {"Positive"})
    public void logOutPositiveTest() {
        loginPage.setEmail(EMAIL);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        projectsPage.waitForPageLoaded();
        headerPage.logOut();
        loginPage.waitForPageLoaded();
        Assert.assertTrue(loginPage.isDisplayed());
    }

    @Test(groups = {"Negative"})
    public void authorizationNegativeTest() {
        loginPage.setEmail(EMAIL);
        loginPage.clickLoginButton();
        Assert.assertFalse(projectsPage.haveOrNot());
    }
}
