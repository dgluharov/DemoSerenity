package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

/**
 * @author yakimfb
 * @since 19.03.20
 **/
public class BasePage
        extends PageObject {
    @FindBy(css = ".product-container")
    public List<WebElementFacade> productContainer;

    public static final By ERROR_MESSAGE_LIST = By.cssSelector("div.alert-danger li");
    public static final By PRODUCT_NAME = By.cssSelector(".product-name");
}
