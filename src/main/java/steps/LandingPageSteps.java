package steps;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.LandingPage;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public class LandingPageSteps extends LandingPage {

    public LandingPageSteps(Page page) {
        super(page);
    }

    @Step("Validate logo is visible on landing page")
    public LandingPageSteps validateLogoIsVisible() {
        Assert.assertTrue(getAppLogo().isVisible());
        return this;
    }

    @Step("Validate offers are loaded correctly")
    public LandingPageSteps validateOffersAreLoaded() {
        Assert.assertFalse(getInventoryItem().all().isEmpty());
        for (int i = 0; i < getInventoryItem().all().size(); i++) {
            Assert.assertTrue(getInventoryItemImages().all().get(i).isVisible(), "Image not visible at index " + i);
            Assert.assertFalse(getInventoryItemName().all().get(i).textContent().isEmpty(), "Name empty at index " + i);
            Assert.assertFalse(getInventoryItemDescription().all().get(i).textContent().isEmpty(), "Description empty at index " + i);
            Assert.assertFalse(getInventoryItemPrices().all().get(i).textContent().isEmpty(), "Price empty at index " + i);
        }
        return this;
    }

    @Step("Get offer details at position {offerPosition}")
    public List<String> getOffer(int offerPosition) {
        return List.of(
                getInventoryItemName().all().get(offerPosition).textContent(),
                getInventoryItemDescription().all().get(offerPosition).textContent(),
                getInventoryItemPrices().all().get(offerPosition).textContent()
        );
    }

    @Step("Navigate to offer at position {offerPosition}")
    public LandingPageSteps goToOffer(int offerPosition) {
        getInventoryItemImages().all().get(offerPosition).click();
        return this;
    }
}
