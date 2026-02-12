package com.uam.automation.web.tasks;

import com.uam.automation.web.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ProceedToCheckout implements Task {

    public static ProceedToCheckout now() {
        return instrumented(ProceedToCheckout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(CartPage.PROCEED_TO_CHECKOUT),
                WaitUntil.the(CartPage.PROCEED_TO_CHECKOUT, isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(CartPage.PROCEED_TO_CHECKOUT)
        );
    }
}
