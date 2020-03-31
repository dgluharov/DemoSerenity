package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

/**
 * @author yakimfb
 * @since 19.03.20
 **/
public class BasePage
        extends PageObject
{
    public static final By ERROR_MESSAGE_LIST = By.cssSelector("div.alert-danger li");
}
