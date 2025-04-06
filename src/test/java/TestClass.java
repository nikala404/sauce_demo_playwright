import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.LandingPageSteps;
import steps.LoginPageSteps;

public class TestClass extends BaseTest {
    LoginPageSteps loginPageSteps;
    LandingPageSteps landingPageSteps;

    @BeforeClass
    public void initSteps() {
        loginPageSteps = new LoginPageSteps(page);
        landingPageSteps = new LandingPageSteps(page);
    }

    @Test(priority = 1)
    public void loginInApplication(){
        loginPageSteps.login("standard_user", "secret_sauce");
    }

    @Test(priority = 2)
    public void validateOffersAreLoaded(){
        landingPageSteps.validateOffersAreLoaded();
    }


}
