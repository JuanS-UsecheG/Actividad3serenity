package com.uam.automation.web.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductDetailPage {

    // Select2 visible text spans
    public static final Target SIZE_RENDERED =
            Target.the("size rendered value")
                    .located(By.xpath("//span[contains(@id,'select2-size_id') and contains(@class,'select2-selection__rendered')]"));

    public static final Target COLOR_RENDERED =
            Target.the("color rendered value")
                    .located(By.xpath("//span[contains(@id,'select2-color_id') and contains(@class,'select2-selection__rendered')]"));

    // Click
    public static final Target SIZE_DROPDOWN =
            Target.the("size dropdown")
                    .located(By.xpath("//span[contains(@id,'select2-size_id')]/ancestor::span[contains(@class,'select2-selection')]"));

    public static final Target COLOR_DROPDOWN =
            Target.the("color dropdown")
                    .located(By.xpath("//span[contains(@id,'select2-color_id')]/ancestor::span[contains(@class,'select2-selection')]"));

    // Input
    public static final Target SELECT2_SEARCH =
            Target.the("select2 search input")
                    .located(By.cssSelector("input.select2-search__field"));

    // texto exacto
    public static Target option(String text) {
        return Target.the("select2 option " + text)
                .located(By.xpath("//li[contains(@class,'select2-results__option') and normalize-space(.)='" + text + "']"));
    }

    // Quantity
    public static final Target QUANTITY =
            Target.the("quantity input")
                    .located(By.cssSelector("input[name='p_qty']"));

    public static final Target ADD_TO_CART =
            Target.the("add to cart button")
                    .located(By.xpath("//input[@name='form_add_to_cart']"));
}
