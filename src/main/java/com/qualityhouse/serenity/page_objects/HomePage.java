package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author yakimfb
 * @since 18.03.20
 **/
public class HomePage
        extends PageObject
{
    @FindBy( css = "nav a.logout" )
    public WebElementFacade logOutMenu;

    @FindBy( css = "nav a.account" )
    public WebElementFacade userMenu;

}
