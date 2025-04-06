package steps;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.OfferPage;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public class OfferPageSteps extends OfferPage {

    public OfferPageSteps(Page page) {
        super(page);
    }

    @Step("Validate offer on details page matches the landing page offer")
    public OfferPageSteps validateOffersAreIdentical(List<String> landingPageOffer) {
        String offerName = getOfferName().textContent();
        String offerDescription = getOfferDescription().textContent();
        String offerPrice = getOfferPrice().textContent();

        Assert.assertTrue(landingPageOffer.contains(offerName), "Offer name '" + offerName + "' not found in landing page offers");
        Assert.assertTrue(landingPageOffer.contains(offerDescription), "Offer description '" + offerDescription + "' not found in landing page offers");
        Assert.assertTrue(landingPageOffer.contains(offerPrice), "Offer price '" + offerPrice + "' not found in landing page offers");

        return this;
    }
}
