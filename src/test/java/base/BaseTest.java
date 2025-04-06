package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import config.PlaywrightAllureListener;
import config.PlaywrightNavigationConfig;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(true);
        browser = playwright.chromium().launch(launchOptions);
        page = PlaywrightNavigationConfig.createPage(browser);
        PlaywrightAllureListener.currentPage.set(page);
        page.navigate("https://www.saucedemo.com/");
    }

    @AfterClass
    public void tearDown() {
        PlaywrightAllureListener.currentPage.remove();
        if (page != null) page.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
