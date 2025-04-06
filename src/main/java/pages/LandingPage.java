package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

import java.util.List;

@Getter
public class LandingPage {
    private final Page page;

    private final Locator appLogo;
    private final List<Locator> inventoryItem;
    private final List<Locator> inventoryItemImages;
    private final List<Locator> inventoryItemDescription;
    private final List<Locator> inventoryItemPrices;

    public LandingPage(Page page) {
        this.page = page;
        this.appLogo = page.locator(".app_logo");
        this.inventoryItemImages = page.locator("//img[@class = 'inventory_item_img']").all();
        this.inventoryItemPrices = page.locator(".inventory_item_price").all();
        this.inventoryItemDescription = page.locator(".inventory_item_label").all();
        this.inventoryItem = page.locator(".inventory_item").all();
    }
}
