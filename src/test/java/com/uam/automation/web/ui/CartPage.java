package com.uam.automation.web.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {

    public static final Target CART_TITLE =
            Target.the("cart title")
                    .located(By.xpath("//*[contains(normalize-space(.),'Cart')]"));

    public static final Target QTY_INPUT =
            Target.the("quantity input in cart")
                    .located(By.xpath("//input[contains(@name,'qty') or @type='number']"));

    public static final Target PROCEED_TO_CHECKOUT =
            Target.the("proceed to checkout button")
                    .located(By.xpath("//a[normalize-space()='Proceed to Checkout']"));
}
