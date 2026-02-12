package com.uam.automation.web.tasks;

import com.uam.automation.web.ui.ProductDetailPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ConfigureProduct implements Task {

    private final String size;
    private final String color;
    private final String qty;

    public ConfigureProduct(String size, String color, String qty) {
        this.size = size;
        this.color = color;
        this.qty = qty;
    }

    public static ConfigureProduct with(String size, String color, String qty) {
        return instrumented(ConfigureProduct.class, size, color, qty);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Tamano
        actor.attemptsTo(
                WaitUntil.the(ProductDetailPage.SIZE_DROPDOWN, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ProductDetailPage.SIZE_DROPDOWN),

                WaitUntil.the(ProductDetailPage.SELECT2_SEARCH, isVisible()).forNoMoreThan(10).seconds(),
                Clear.field(ProductDetailPage.SELECT2_SEARCH),
                Enter.theValue(size).into(ProductDetailPage.SELECT2_SEARCH),

                WaitUntil.the(ProductDetailPage.option(size), isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ProductDetailPage.option(size)),


                WaitUntil.the(ProductDetailPage.SIZE_RENDERED, containsText(size)).forNoMoreThan(10).seconds()
        );

        // Color
        actor.attemptsTo(
                WaitUntil.the(ProductDetailPage.COLOR_DROPDOWN, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ProductDetailPage.COLOR_DROPDOWN),

                WaitUntil.the(ProductDetailPage.SELECT2_SEARCH, isVisible()).forNoMoreThan(10).seconds(),
                Clear.field(ProductDetailPage.SELECT2_SEARCH),
                Enter.theValue(color).into(ProductDetailPage.SELECT2_SEARCH),

                WaitUntil.the(ProductDetailPage.option(color), isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ProductDetailPage.option(color)),

                WaitUntil.the(ProductDetailPage.COLOR_RENDERED, containsText(color)).forNoMoreThan(10).seconds()
        );

        // Cantidad
        actor.attemptsTo(
                WaitUntil.the(ProductDetailPage.QUANTITY, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ProductDetailPage.QUANTITY),
                Clear.field(ProductDetailPage.QUANTITY),
                Enter.theValue(qty).into(ProductDetailPage.QUANTITY)
        );

        // AddToCart
        actor.attemptsTo(
                WaitUntil.the(ProductDetailPage.ADD_TO_CART, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ProductDetailPage.ADD_TO_CART)
        );
    }
}
