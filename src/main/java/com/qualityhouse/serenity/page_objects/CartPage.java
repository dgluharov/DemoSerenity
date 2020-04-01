package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    @FindBy(css = ".cart_quantity_input")
    public WebElementFacade quantityField;

    @FindBy(css = "td.cart_description > p:nth-child(1)")
    public WebElementFacade productName;

    public static final By TOTAL_PRODUCT_PRICE_LOCATOR = By.id("total_product");
    public static final By PRODUCT_CHARACTERISTICS_LOCATOR = By.cssSelector("tr:nth-of-type(1) > td.cart_description > small:nth-child(3)");
}
