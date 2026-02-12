package com.uam.automation.web.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenDemoShop implements Task {

    private final String url;

    public OpenDemoShop(String url) {
        this.url = url;
    }

    public static OpenDemoShop at(String url) {
        return instrumented(OpenDemoShop.class, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}
