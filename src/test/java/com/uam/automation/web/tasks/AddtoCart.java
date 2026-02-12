package com.uam.automation.web.tasks;

import com.uam.automation.web.ui.SearchResultPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AddtoCart implements Task {

    public static AddtoCart now() {
        return instrumented(AddtoCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SearchResultPage.FIRST_ADD_TO_CART, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(SearchResultPage.FIRST_ADD_TO_CART)
        );
    }
}
