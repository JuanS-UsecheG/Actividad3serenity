package com.uam.automation.web.tasks;

import com.uam.automation.web.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Login with(String username, String password) {
        return instrumented(Login.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        if (!LoginPage.LOGIN_ENTRY.resolveAllFor(actor).isEmpty()) {
            actor.attemptsTo(
                    WaitUntil.the(LoginPage.LOGIN_ENTRY, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(LoginPage.LOGIN_ENTRY)
            );
        }

        //espera campos
        actor.attemptsTo(
                WaitUntil.the(LoginPage.USERNAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(username).into(LoginPage.USERNAME),

                WaitUntil.the(LoginPage.PASSWORD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(password).into(LoginPage.PASSWORD),

                WaitUntil.the(LoginPage.LOGIN_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
