package com.uam.automation.web.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchResultPage {

    // Botón "Add to Cart" del primer producto mostrado
    public static final Target FIRST_ADD_TO_CART =
            Target.the("first Add to Cart button")
                    .located(By.xpath("(//a[normalize-space()='Add to Cart'])[1]"));

    // Evidencia de que se agregó: el texto "Cart" en header
    public static final Target CART_LINK =
            Target.the("cart link")
                    .located(By.xpath("//a[contains(.,'Cart')]"));
}
