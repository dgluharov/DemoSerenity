package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.Product;
import com.qualityhouse.serenity.page_objects.CartPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.*;

public class CartPageActions
        extends BasesActions {

    private CartPage cartPage;

    @Step
    public String calculateTotalPriceForProduct(Product product) {
        return String.format("%.2f", product.getUnitPrice() * product.getQuantity());
    }

    @Step
    public int getQuantityOfProduct(WebElement productQuantityLocator) {
        return new Integer(productQuantityLocator.getAttribute("value"));
    }

    @Step
    public String getProductName(WebElement productNameLocator) {
        return productNameLocator.getText();
    }

    @Step
    public void opensCartPage() {
        cartPage.open();
    }
}
