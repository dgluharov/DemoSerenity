package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.Product;
import com.qualityhouse.serenity.page_objects.ProductPage;
import com.qualityhouse.serenity.page_objects.WomenPage;
import com.qualityhouse.serenity.utils.SizeEnum;
import net.thucydides.core.annotations.Step;

import static com.qualityhouse.serenity.page_objects.ProductPage.*;


public class PurchaseActions
        extends BasesActions {

    private WomenPage womenPage;
    private ProductPage productPage;


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
        if (size != null) {

            selectsFromDropDownAnItemByValue(SIZE_DROPDOWN_LOCATOR, SizeEnum.valueOf(size).getValue());

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


    public double getProductPrice() {
        return Double.parseDouble(readsTextFrom(PRODUCT_PRICE_LOCATOR).substring(1));
    }

    public void selectsFirstProduct() {
        clicksOn(womenPage.firstProduct);
    }


}
