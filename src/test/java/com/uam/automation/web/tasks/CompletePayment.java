package com.uam.automation.web.tasks;

import com.uam.automation.web.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class CompletePayment implements Task {

    private final String method;
    private final String transactionCode;

    public CompletePayment(String method, String transactionCode) {
        this.method = method;
        this.transactionCode = transactionCode;
    }

    public static CompletePayment with(String method, String transactionCode) {
        return instrumented(CompletePayment.class, method, transactionCode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Abrir dropdown y seleccionar opción (Select2)
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.PAYMENT_DROPDOWN, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.PAYMENT_DROPDOWN),

                WaitUntil.the(CheckoutPage.SELECT2_SEARCH, isVisible()).forNoMoreThan(10).seconds(),
                Clear.field(CheckoutPage.SELECT2_SEARCH),
                Enter.theValue(method).into(CheckoutPage.SELECT2_SEARCH),

                WaitUntil.the(CheckoutPage.paymentOption(method), isClickable()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.paymentOption(method))
        );

        // Esperar textarea activo e ingresar transaction
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.TRANSACTION_INFO, isVisible()).forNoMoreThan(10).seconds(),
                Clear.field(CheckoutPage.TRANSACTION_INFO),
                Enter.theValue(transactionCode).into(CheckoutPage.TRANSACTION_INFO)
        );

        // Click Pay Now
        actor.attemptsTo(
                Scroll.to(CheckoutPage.PAY_NOW),
                WaitUntil.the(CheckoutPage.PAY_NOW, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(CheckoutPage.PAY_NOW)
        );
    }
}
