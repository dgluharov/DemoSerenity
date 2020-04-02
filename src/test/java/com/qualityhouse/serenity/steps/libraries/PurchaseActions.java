package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.entities.Product;
import com.qualityhouse.serenity.page_objects.ProductPage;
import com.qualityhouse.serenity.page_objects.WomenPage;
import com.qualityhouse.serenity.utils.ColorEnum;
import com.qualityhouse.serenity.utils.SizeEnum;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static com.qualityhouse.serenity.page_objects.ProductPage.QUANTITY_FIELD_LOCATOR;
import static com.qualityhouse.serenity.page_objects.ProductPage.SIZE_DROPDOWN_LOCATOR;


public class PurchaseActions
        extends BasesActions {

    private WomenPage womenPage;
    private ProductPage productPage;


    public void fillOrderDetails(Product product) {
        selectQuantity(product.getQuantity());
        selectSize(product.getSize());
        selectColor(product.getColor());
    }


    @Step
    private void selectQuantity(int quantity) {
        fillsFieldWithData(QUANTITY_FIELD_LOCATOR, String.valueOf(quantity));
    }

    @Step
    private void selectSize(String size) {
        if (size != null) {

            selectsFromDropDownAnItemByValue(SIZE_DROPDOWN_LOCATOR, SizeEnum.valueOf(size).getValue());

        }
    }

    @Step
    private void selectColor(String color) {
        if (color != null) {
            clicksOn(By.name(ColorEnum.valueOf(color.toUpperCase()).getValue()));
        }
    }

    public void selectsFirstProduct() {
        clicksOn(womenPage.firstProduct);
    }
}
