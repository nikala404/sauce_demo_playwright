package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.LandingPageSteps;
import steps.LoginPageSteps;
import steps.OfferPageSteps;

import java.util.List;

@Epic("SauceDemo")
@Feature("Product Listing")
public class OfferValidationTest extends BaseTest {
    LoginPageSteps loginPageSteps;
    LandingPageSteps landingPageSteps;
    OfferPageSteps offerPageSteps;

    @BeforeClass
    public void initSteps() {
        loginPageSteps = new LoginPageSteps(page);
        landingPageSteps = new LandingPageSteps(page);
        offerPageSteps = new OfferPageSteps(page);
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Story("Login Functionality")
    @Description("Login with standard user and verify landing page is loaded")
    public void loginInApplication() {
        loginPageSteps
                .login("standard_user", "secret_sauce")
                .validateLoggedInSuccessfully();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Story("Product Loading")
    @Description("Validate all product offers are loaded with correct name, image, description, and price")
    public void validateOffersAreLoaded() {
        landingPageSteps
                .validateLogoIsVisible()
                .validateOffersAreLoaded();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Story("Product Detail Comparison")
    @Description("Validate that offer details on landing and offer page are identical")
    public void validateOffersAreIdentical() {
        List<String> offer = landingPageSteps.getOffer(1);
        landingPageSteps.goToOffer(1);
        offerPageSteps.validateOffersAreIdentical(offer);
    }
}
