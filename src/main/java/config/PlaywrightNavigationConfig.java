package config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class PlaywrightNavigationConfig {
    public static Page createPage(Browser browser) {
        Page page = browser.newPage();

        page.route("**", route -> {
            route.resume();
            try {
                page.waitForLoadState(LoadState.NETWORKIDLE);
            } catch (Exception ignored) {
            }
        });

        return page;
    }
}