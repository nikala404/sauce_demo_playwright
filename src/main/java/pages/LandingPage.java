package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class LandingPage {
    private final Page page;

    private final Locator appLogo;
    private final Locator inventoryItem;
    private final Locator inventoryItemName;
    private final Locator inventoryItemImages;
    private final Locator inventoryItemDescription;
    private final Locator inventoryItemPrices;

    public LandingPage(Page page) {
        this.page = page;
        this.appLogo = page.locator(".app_logo");
        this.inventoryItem = page.locator(".inventory_item");
        this.inventoryItemName = page.locator(".inventory_item_name");
        this.inventoryItemImages = page.locator("img.inventory_item_img");
        this.inventoryItemDescription = page.locator(".inventory_item_desc");
        this.inventoryItemPrices = page.locator(".inventory_item_price");
    }
}
