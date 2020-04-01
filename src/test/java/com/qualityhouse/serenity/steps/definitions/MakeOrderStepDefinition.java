package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.entities.Product;
import com.qualityhouse.serenity.page_objects.CartPage;
import com.qualityhouse.serenity.page_objects.WomenPage;
import com.qualityhouse.serenity.steps.libraries.CartPageActions;
import com.qualityhouse.serenity.steps.libraries.ProductPageActions;
import com.qualityhouse.serenity.steps.libraries.WomenSectionBaseActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static com.qualityhouse.serenity.page_objects.ProductPage.SUCCESS_MESSAGE_ADDED_TO_CART;
import static org.assertj.core.api.Assertions.assertThat;
import static com.qualityhouse.serenity.page_objects.CartPage.PRODUCT_CHARACTERISTICS_LOCATOR;
import static com.qualityhouse.serenity.page_objects.CartPage.TOTAL_PRODUCT_PRICE_LOCATOR;

public class MakeOrderStepDefinition {
    private WomenPage womenPage;

    private CartPage cartPage;

    private Product product;

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

    @Given("^s?he has selected the first product from products list$")
    @When("^(?:.*) selects the first product from products list$")
    public void selectsTheFirstProductFromListOfProducts() {
        womenSectionBaseActions.selectsFirstProduct();
    }

    @When("^s?he adds the product to the cart with order details:$")
    public void userChoseHisOptionsFromProductPage(List<Product> data) {
        this.product = data.get(0);
        this.product.setUnitPrice(productPageActions.getProductPrice());
        this.product.setName(productPageActions.getProductName());

        productPageActions.fillOrderDetails(this.product);
        productPageActions.clickAddToCart();
    }


    @Then("^the product should be added to the cart$")
    public void userProceedsToOrderPage() {
        assertThat(productPageActions.readsTextFrom(SUCCESS_MESSAGE_ADDED_TO_CART))
                .containsIgnoringCase("Product successfully added to your shopping cart");
    }


    @Then("^correct order details are displayed in the cart page$")
    public void correctOrderDetailsAreDisplayed() {
        cartPageActions.opensCartPage();
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(cartPageActions.readsTextFrom(TOTAL_PRODUCT_PRICE_LOCATOR))
                .as("Total price for product without delivery taxes")
                .contains(cartPageActions.calculateTotalPriceForProduct(this.product));
        softly.assertThat(cartPageActions.getProductName(cartPage.productName))
                .as("Product name")
                .isEqualToIgnoringCase(this.product.getName());
        softly.assertThat(cartPageActions.getQuantityOfProduct(cartPage.quantityField))
                .as("Product quantity")
                .isEqualTo(product.getQuantity());
        softly.assertThat(cartPageActions.readsTextFrom(PRODUCT_CHARACTERISTICS_LOCATOR))
                .as("Product characteristics")
                .containsIgnoringCase(this.product.getSize())
                .containsIgnoringCase(this.product.getColor());

        softly.assertAll();
    }
}
