package com.uam.automation.web.tasks;

import com.uam.automation.web.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchProduct implements Task {

    private final String product;

    public SearchProduct(String product) {
        this.product = product;
    }

    public static SearchProduct called(String product) {
        return instrumented(SearchProduct.class, product);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(HomePage.SEARCH_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(product).into(HomePage.SEARCH_INPUT),
                Hit.the(Keys.ENTER).into(HomePage.SEARCH_INPUT)
        );
    }
}
