package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.Product;
import org.openqa.selenium.*;

import java.util.List;

public class CartPageActions
        extends BasesActions {


    public String calculateTotalPriceForProduct(Product product) {
        return String.format("%.2f", product.getPrice() * product.getQuantity());
    }

    public int getQuantityOfProduct(WebElement productQuantityLocator) {
        return new Integer(productQuantityLocator.getAttribute("value"));
    }

    public String getProductName(WebElement productNameLocator) {
        return productNameLocator.getText();
    }
}
