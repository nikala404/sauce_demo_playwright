package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class LoginPage {
    private final Page page;

    private final Locator userNameInput;
    private final Locator passwordInput;
    private final Locator loginButton;

    private final Locator loginError;

    public LoginPage(Page page) {
        this.page = page;
        this.userNameInput = page.locator("#user-name");
        this.passwordInput = page.locator("#password");
        this.loginButton = page.locator("#login-button");
        this.loginError = page.locator("//h3[@data-test = 'error']");
    }

}
