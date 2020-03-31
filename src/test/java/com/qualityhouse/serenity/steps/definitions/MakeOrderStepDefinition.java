package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.entities.Product;
import com.qualityhouse.serenity.page_objects.CartPage;
import com.qualityhouse.serenity.page_objects.WomenPage;
import com.qualityhouse.serenity.steps.libraries.CartPageActions;
import com.qualityhouse.serenity.steps.libraries.ProductPageActions;
import com.qualityhouse.serenity.steps.libraries.WomenSectionBaseActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static com.qualityhouse.serenity.page_objects.CartPage.*;

public class MakeOrderStepDefinition {
    WomenPage womenPage;
    Product product;

    @Steps
    private WomenSectionBaseActions womenSectionBaseActions;
    @Steps
    private ProductPageActions productPageActions;
    @Steps
    private CartPageActions cartPageActions;

    @Given("^(?:.*) is on the Women's Page$")
    public void womenSectionPageIsOpen() {
        womenPage.open();
    }

    @And("^s?he selected the first product from list of products$")
    public void selectsTheFirstProductFromListOfProducts() {
        womenSectionBaseActions.selectsFirstProduct();
    }

    @When("^(?:.*) chose his options from Product Page:$")
    public void userChoseHisOptionsFromProductPage(List<Product> data) {
        product = data.get(0);
        productPageActions.fillProductDetails(product);
        productPageActions.fillOrderDetails(product);
    }

    @And("^s?he added them to the cart$")
    public void userAddedThemToTheCart() {
        productPageActions.clickAddToCart();
    }

    @Then("^s?he proceeds to Order Page$")
    public void userProceedsToOrderPage() {
        productPageActions.clickProceedToCheckoutButton();
    }

    @And("^in the cart there are the following products with theirs characteristics:$")
    public void inTheCartThereAreTheFollowingProductsWithTheirsCharacteristics(List<Product> data) {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(cartPageActions.readsTextFrom(TOTAL_PRODUCT_PRICE_LOCATOR))
                .as("Total price for product without delivery taxes")
                .contains(cartPageActions.calculateTotalPriceForProduct(product));
        softly.assertThat(cartPageActions.readsTextFrom(PRODUCT_NAME_LOCATOR))
                .as("Product name")
                .isEqualToIgnoringCase(product.getName());
        softly.assertThat(cartPageActions.readsTextFrom(PRODUCT_CHARACTERISTICS_LOCATOR))
                .as("Product characteristics")
                .contains(data.get(0).getSize())
                .contains(data.get(0).getColor());

        softly.assertAll();
    }
}
