package com.uam.automation.web.tasks;

import com.uam.automation.web.ui.HeaderPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class GoToCart implements Task {

    public static GoToCart now() {
        return instrumented(GoToCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HeaderPage.CART_ICON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(HeaderPage.CART_ICON)
        );
    }
}
