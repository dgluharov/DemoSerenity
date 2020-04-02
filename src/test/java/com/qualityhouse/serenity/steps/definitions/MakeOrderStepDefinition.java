package com.qualityhouse.serenity.steps.definitions;

import com.qualityhouse.serenity.entities.Product;
import com.qualityhouse.serenity.page_objects.CartPage;
import com.qualityhouse.serenity.page_objects.WomenPage;
import com.qualityhouse.serenity.steps.libraries.CartPageActions;
import com.qualityhouse.serenity.steps.libraries.PurchaseActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static com.qualityhouse.serenity.page_objects.CartPage.*;
import static com.qualityhouse.serenity.page_objects.ProductPage.*;
import static com.qualityhouse.serenity.page_objects.ProductPage.PRODUCT_NAME_LOCATOR;
import static org.assertj.core.api.Assertions.assertThat;

public class MakeOrderStepDefinition {
    public static final String EXPECTED_ADD_TO_CART_MESSAGE = "Product successfully added to your shopping cart";
    private WomenPage womenPage;

    private Product product;

    @Steps
    private PurchaseActions purchaseActions;
    @Steps
    private CartPageActions cartPageActions;

    @Given("^(?:.*) is on the Women's Page$")
    public void womenSectionPageIsOpen() {
        womenPage.open();
    }

    @Given("^s?he has selected the first product from products list$")
    @When("^(?:.*) selects the first product from products list$")
    public void selectsTheFirstProductFromListOfProducts() {
        purchaseActions.selectsFirstProduct();
    }

    @When("^s?he adds the product to the cart with order details:$")
    public void userChoseHisOptionsFromProductPage(List<Product> data) {
        this.product = data.get(0);
        this.product.setUnitPrice(purchaseActions.readsDoubleFrom(PRODUCT_PRICE_LOCATOR));
        this.product.setName(purchaseActions.readsTextFrom(PRODUCT_NAME_LOCATOR));

        purchaseActions.fillOrderDetails(this.product);
        purchaseActions.clicksOn(ADD_TO_CART_BUTTON);
    }


    @Then("^the product should be added to the cart$")
    public void userProceedsToOrderPage() {
        assertThat(purchaseActions.readsTextFrom(SUCCESS_MESSAGE_ADDED_TO_CART))
                .containsIgnoringCase(EXPECTED_ADD_TO_CART_MESSAGE);
    }


    @Then("^correct order details are displayed in the cart page$")
    public void correctOrderDetailsAreDisplayed() {
        cartPageActions.opensCartPage();
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(cartPageActions.readsTextFrom(TOTAL_PRODUCT_PRICE_LOCATOR))
                .as("Total price should be calculated correctly")
                .contains(cartPageActions.calculateTotalPriceForProduct(this.product));
        softly.assertThat(cartPageActions.readsTextFrom(CartPage.PRODUCT_NAME_LOCATOR))
                .as("Product name")
                .isEqualToIgnoringCase(this.product.getName());
        softly.assertThat(cartPageActions.readsNumericValueFrom(CartPage.PRODUCT_QUANTITY_LOCATOR))
                .as("Product quantity")
                .isEqualTo(this.product.getQuantity());
        softly.assertThat(cartPageActions.readsTextFrom(PRODUCT_CHARACTERISTICS_LOCATOR))
                .as("Product characteristics")
                .containsIgnoringCase(this.product.getSize())
                .containsIgnoringCase(this.product.getColor());

        softly.assertAll();
    }
}
