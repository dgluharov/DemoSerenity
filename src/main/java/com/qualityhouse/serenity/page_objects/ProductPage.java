package com.qualityhouse.serenity.page_objects;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    public static final By ADD_TO_CART_BUTTON = By.name("Submit");
    public static final By QUANTITY_FIELD_LOCATOR = By.name("qty");
    public static final By SIZE_DROPDOWN_LOCATOR = By.name("group_1");
    public static final By ORANGE_COLOR_LOCATOR = By.name("Orange");
    public static final By BLUE_COLOR_LOCATOR = By.name("Blue");
    public static final By PRODUCT_PRICE_LOCATOR = By.id("our_price_display");
    public static final By PRODUCT_NAME_LOCATOR = By.cssSelector("h1[itemprop='name']");
    public static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.cssSelector("div.button-container > a");
    public static final By SUCCESS_MESSAGE_ADDED_TO_CART = By.cssSelector(".layer_cart_product h2:nth-child(2)");
}
