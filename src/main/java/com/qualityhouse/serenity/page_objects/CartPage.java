package com.qualityhouse.serenity.page_objects;

import org.openqa.selenium.By;

public class CartPage extends BasePage {
    public static final By TOTAL_PRODUCT_PRICE_LOCATOR = By.id("total_product");
    public static final By PRODUCT_NAME_LOCATOR = By.cssSelector("tr:nth-of-type(1) > td.cart_description > p.product-name > a");
    public static final By PRODUCT_CHARACTERISTICS_LOCATOR = By.cssSelector("tr:nth-of-type(1) > td.cart_description > small:nth-child(3)");
    public static final By PRODUCT_QUANTITY_LOCATOR = By.xpath("//td[5]//input[1]");


}
