package Tests;

import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test
    public void  authorizationPositiveTest() throws InterruptedException {
        loginPage.setEmail(EMAIL);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        Thread.sleep(5000);
    }
}
