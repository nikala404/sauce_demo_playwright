package config;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class PlaywrightAllureListener implements ITestListener {

    public static final ThreadLocal<Page> currentPage = new ThreadLocal<>();

    @Override
    public void onTestFailure(ITestResult result) {
        Page page = currentPage.get();

        if (page != null) {
            try {
                Path screenshotPath = Path.of("screenshots", result.getMethod().getMethodName() + ".png");
                Files.createDirectories(screenshotPath.getParent());
                page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath).setFullPage(true));

                try (InputStream is = Files.newInputStream(screenshotPath)) {
                    Allure.addAttachment("Failure Screenshot", is);
                }

                String pageSource = page.content();
                Allure.addAttachment("Page Source", "text/html", pageSource, ".html");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
