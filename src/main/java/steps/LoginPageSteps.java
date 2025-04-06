package steps;

import com.microsoft.playwright.Page;
import pages.LoginPage;

public class LoginPageSteps extends LoginPage {

    public LoginPageSteps(Page page) {
        super(page);
    }


    public LoginPageSteps login(String username, String password) {
        getUserNameInput().fill(username);
        getPasswordInput().fill(password);
        getLoginButton().click();
        return this;
    }


}
