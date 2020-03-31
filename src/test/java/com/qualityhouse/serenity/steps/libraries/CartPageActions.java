package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.Product;

public class CartPageActions
        extends BasesActions {


    public String calculateTotalPriceForProduct(Product product) {
        return String.format("%.2f", product.getPrice() * product.getQuantity());
    }
}
