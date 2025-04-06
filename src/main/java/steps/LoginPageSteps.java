package steps;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.LoginPage;

@SuppressWarnings("UnusedReturnValue")
public class LoginPageSteps extends LoginPage {

    public LoginPageSteps(Page page) {
        super(page);
    }

    @Step("Login with username: {username} and password: {password}")
    public LoginPageSteps login(String username, String password) {
        getUserNameInput().fill(username);
        getPasswordInput().fill(password);
        getLoginButton().click();
        return this;
    }

    @Step("Validate login error is displayed for invalid credentials")
    public LoginPageSteps validateLoginError() {
        Assert.assertTrue(getLoginError().isVisible());
        Assert.assertEquals(getLoginError().textContent(), "Epic sadface: Username and password do not match any user in this service");
        return this;
    }

    @Step("Validate error for locked out user")
    public LoginPageSteps validateLockedOutUser() {
        Assert.assertTrue(getLoginError().isVisible());
        Assert.assertEquals(getLoginError().textContent(), "Epic sadface: Sorry, this user has been locked out.");
        return this;
    }

    @Step("Validate login was successful")
    public LoginPageSteps validateLoggedInSuccessfully() {
        Assert.assertFalse(getLoginError().isVisible());
        return this;
    }
}
