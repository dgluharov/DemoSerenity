package com.qualityhouse.serenity.page_objects;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://test.automationpractice.com/index.php?id_category=3&controller=category")
public class WomenPage
        extends PageObject {

    @FindBy(css = "li.ajax_block_product:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h5:nth-child(1) > a:nth-child(1)")
    public WebElementFacade firstProduct;
}
