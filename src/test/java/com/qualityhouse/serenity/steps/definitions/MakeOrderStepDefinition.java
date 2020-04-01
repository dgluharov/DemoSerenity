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

import static com.qualityhouse.serenity.page_objects.CartPage.PRODUCT_CHARACTERISTICS_LOCATOR;
import static com.qualityhouse.serenity.page_objects.CartPage.TOTAL_PRODUCT_PRICE_LOCATOR;

public class MakeOrderStepDefinition {
    WomenPage womenPage;

    CartPage cartPage;

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

    @And("^s?he has selected the first product from list of products$")
    public void selectsTheFirstProductFromListOfProducts() {
        womenSectionBaseActions.selectsFirstProduct();
    }

    @When("^(?:.*) selects his options from Product Page:$")
    public void userChoseHisOptionsFromProductPage(List<Product> data) {
        Product product = data.get(0);
        productPageActions.fillProductDetails(product);
        productPageActions.fillOrderDetails(product);
    }

    @Then("^s?he adds them to the cart$")
    public void userAddedThemToTheCart() {
        productPageActions.clickAddToCart();
    }

    @When("^(?:.*) proceeds to Order Page$")
    public void userProceedsToOrderPage() {
        productPageActions.clickProceedToCheckoutButton();
    }


    @Then("^s?he should see the summary of his purchase:$")
    public void heShouldSeeTheSummaryOfHisPurchase(List<Product> data) {
        Product product = data.get(0);
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(cartPageActions.readsTextFrom(TOTAL_PRODUCT_PRICE_LOCATOR))
                .as("Total price for product without delivery taxes")
                .contains(cartPageActions.calculateTotalPriceForProduct(product));
        softly.assertThat(cartPageActions.getProductName(cartPage.productName))
                .as("Product name")
                .isEqualToIgnoringCase(product.getName());
        softly.assertThat(cartPageActions.getQuantityOfProduct(cartPage.quantityField))
                .as("Product quantity")
                .isEqualTo(product.getQuantity());
        softly.assertThat(cartPageActions.readsTextFrom(PRODUCT_CHARACTERISTICS_LOCATOR))
                .as("Product characteristics")
                .containsIgnoringCase(product.getSize())
                .containsIgnoringCase(product.getColor());

        softly.assertAll();
    }
}
