package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.LandingPageSteps;
import steps.LoginPageSteps;

@Epic("SauceDemo")
@Feature("Login Functionality")
public class LoginTest extends BaseTest {
    LoginPageSteps loginPageSteps;
    LandingPageSteps landingPageSteps;

    @BeforeClass
    public void initSteps() {
        loginPageSteps = new LoginPageSteps(page);
        landingPageSteps = new LandingPageSteps(page);
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Story("Login with invalid credentials")
    @Description("Try logging in with invalid credentials and check for error message")
    public void loginWithInvalidData() {
        loginPageSteps
                .login("test", "test")
                .validateLoginError();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Story("Login with locked out user")
    @Description("Attempt login with locked out user and verify appropriate error is displayed")
    public void loginWithLockedOutUser() {
        loginPageSteps
                .login("locked_out_user", "secret_sauce")
                .validateLockedOutUser();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.BLOCKER)
    @Story("Login with valid credentials")
    @Description("Login with valid credentials and verify successful login")
    public void successfulLogin() {
        loginPageSteps
                .login("standard_user", "secret_sauce")
                .validateLoggedInSuccessfully();

        landingPageSteps
                .validateLogoIsVisible();
    }
}
