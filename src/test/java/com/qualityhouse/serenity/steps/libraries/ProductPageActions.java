package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.Product;
import com.qualityhouse.serenity.page_objects.ProductPage;
import net.thucydides.core.annotations.Step;

import static com.qualityhouse.serenity.page_objects.ProductPage.*;

public class ProductPageActions
        extends BasesActions {

    ProductPage productPage;


    @Step
    public void fillOrderDetails(Product product) {
        selectQuantity(product.getQuantity());
        selectSize(product.getSize());
        selectColor(product.getColor());
    }

    @Step
    public void clickAddToCart() {
        clicksOn(ADD_TO_CART_BUTTON);
    }

    @Step
    private void selectQuantity(int quantity) {
        fillsFieldWithData(QUANTITY_FIELD_LOCATOR, String.valueOf(quantity));
    }

    @Step
    private void selectSize(String size) {
        if (size.equalsIgnoreCase("s")) {
            selectsFromDropDownAnItemByValue(SIZE_DROPDOWN_LOCATOR, "1");
        } else if (size.equalsIgnoreCase("m")) {
            selectsFromDropDownAnItemByValue(SIZE_DROPDOWN_LOCATOR, "2");
        } else if (size.equalsIgnoreCase("l")) {
            selectsFromDropDownAnItemByValue(SIZE_DROPDOWN_LOCATOR, "3");
        }
    }

    @Step
    private void selectColor(String color) {
        if (color.trim().toLowerCase().equals("orange")) {
            clicksOn(ORANGE_COLOR_LOCATOR);
        } else {
            clicksOn(BLUE_COLOR_LOCATOR);
        }
    }

    public void clickProceedToCheckoutButton() {
        clicksOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
    }

    public String getProductName() {
        return readsTextFrom(PRODUCT_NAME_LOCATOR);
    }

    public double getProductPrice() {
        return Double.parseDouble(readsTextFrom(PRODUCT_PRICE_LOCATOR).substring(1));
    }
}
