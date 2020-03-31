package com.qualityhouse.serenity.page_objects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

/**
 * @author yakimfb
 * @since 18.03.20
 **/
public class RegistrationPage
        extends PageObject
{
    @FindBy(css = "[for='id_gender1']")
    public WebElementFacade mrRadioButton;

    @FindBy(css = "[for='id_gender2']")
    public WebElementFacade mrsRadioButton;

    @FindBy( name = "customer_firstname" )
    public WebElementFacade firstNameField;

    @FindBy( name = "customer_lastname" )
    public WebElementFacade lastNameField;

    @FindBy( name = "email" )
    public WebElementFacade emailField;

    @FindBy( name = "passwd" )
    public WebElementFacade passwordField;

    public static final By DAY_OF_BIRTH_DROP_DOWN_LOCATOR = By.name( "days" );

    public static final By MONTH_OF_BIRTH_DROP_DOWN_LOCATOR = By.name( "months" );

    public static final By YEAR_OF_BIRTH_DROP_DOWN_LOCATOR = By.name( "years" );

    @FindBy( name = "address1" )
    public WebElementFacade address1Field;

    @FindBy( name = "city" )
    public WebElementFacade addressCityField;

    public static final By ADDRESS_STATE_DROP_DOWN_LOCATOR = By.name( "id_state" );

    @FindBy(name = "postcode")
    public WebElementFacade addressZipCodeField;

    public static final By ADDRESS_COUNTRY_DROP_DOWN_LOCATOR = By.name("id_country");

    @FindBy(name = "phone_mobile")
    public WebElementFacade addressMobilePhoneField;

    @FindBy(name = "alias")
    public WebElementFacade addressAliasField;

    @FindBy(name = "submitAccount")
    public WebElementFacade registerButton;

    @FindBy(css = "div.alert")
    public WebElementFacade alertDangerBox;
}
