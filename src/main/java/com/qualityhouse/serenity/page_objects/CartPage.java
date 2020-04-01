package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("/index.php?controller=order")
public class CartPage extends BasePage {

    @FindBy(css = ".cart_quantity_input")
    public WebElementFacade quantityField;

    @FindBy(css = "td.cart_description > p:nth-child(1)")
    public WebElementFacade productName;

    public static final By TOTAL_PRODUCT_PRICE_LOCATOR = By.id("total_product");
    public static final By PRODUCT_CHARACTERISTICS_LOCATOR = By.cssSelector(".cart_description > small > a");
    public static final By PRODUCT_QUANTITY_LOCATOR = By.cssSelector(".cart_quantity_input");
    public static final By PRODUCT_NAME_LOCATOR = By.cssSelector("td.cart_description > p:nth-child(1)");
}
