package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class OfferPage {
    private final Page page;

    private final Locator offerImage;
    private final Locator offerName;
    private final Locator offerDescription;
    private final Locator offerPrice;

    public OfferPage(Page page){
        this.page = page;
        this.offerImage = page.locator(".inventory_details_img");
        this.offerName = page.locator(".inventory_details_name");
        this.offerDescription = page.locator(".inventory_details_desc");
        this.offerPrice = page.locator(".inventory_details_price");
    }
}
