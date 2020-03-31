package com.qualityhouse.serenity.steps.libraries;

import com.qualityhouse.serenity.page_objects.WomenPage;


public class WomenSectionBaseActions
        extends BasesActions {

    private WomenPage womenPage;


    public void selectsFirstProduct() {
        clicksOn(womenPage.firstProduct);
    }
}
