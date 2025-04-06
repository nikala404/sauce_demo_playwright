package steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import pages.LandingPage;

import java.util.List;

public class LandingPageSteps extends LandingPage {

    public LandingPageSteps(Page page) {
        super(page);
    }

    public LandingPageSteps validateOffersAreLoaded() {


        List<Locator> items = getInventoryItem();
        Assert.assertFalse(items.isEmpty(), "No offers/items were loaded on the landing page.");

        for (int i = 0; i < items.size(); i++) {
            Assert.assertTrue(getInventoryItemImages().get(i).isVisible(), "Image not visible at index " + i);
            Assert.assertFalse(getInventoryItemDescription().get(i).innerText().isEmpty(), "Description empty at index " + i);
            Assert.assertFalse(getInventoryItemPrices().get(i).textContent().isEmpty(), "Price empty at index " + i);

            System.out.println("Price: " + getInventoryItemPrices().get(i).textContent());
        }

        return this;
    }

}
