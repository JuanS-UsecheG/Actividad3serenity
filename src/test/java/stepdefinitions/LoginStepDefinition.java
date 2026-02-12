package com.uam.automation.web.stepdefinitions;

import com.uam.automation.web.tasks.*;
import com.uam.automation.web.ui.CartPage;
import com.uam.automation.web.ui.CheckoutPage;
import com.uam.automation.web.ui.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.UUID;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.is;

public class LoginStepDefinition {

    private Actor user;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        user = OnStage.theActorCalled("User");
        user.can(BrowseTheWeb.with(Serenity.getDriver()));
    }

    @Given("that the user opens DemoShop")
    public void that_the_user_opens_demoshop() {
        user.attemptsTo(
                OpenDemoShop.at("http://demo-shop.cesaragudelo.com/")
        );
    }

    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password) {
        user.attemptsTo(
                Login.with(username, password)
        );
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String term) {
        user.attemptsTo(
                SearchProduct.called(term)
        );
    }

    @When("the user adds the first product to the cart")
    public void the_user_adds_the_first_product_to_the_cart() {
        user.attemptsTo(
                AddtoCart.now()
        );
    }

    @When("the user selects size {string}, color {string} and quantity {string} and adds to cart")
    public void configure_and_add(String size, String color, String qty) {
        user.attemptsTo(
                ConfigureProduct.with(size, color, qty)
        );
    }

    @When("the user goes to the cart")
    public void the_user_goes_to_the_cart() {
        user.attemptsTo(
                GoToCart.now()
        );
    }

    @Then("the product should be visible in the cart")
    public void the_product_should_be_visible_in_the_cart() {
        user.attemptsTo(
                WaitUntil.the(CartPage.CART_TITLE, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(CartPage.QTY_INPUT, isVisible()).forNoMoreThan(10).seconds()
        );

        user.should(
                seeThat(actor -> CartPage.QTY_INPUT.resolveFor(actor).isVisible(), is(true))
        );
    }

    @When("the user proceeds to checkout")
    public void the_user_proceeds_to_checkout() {
        user.attemptsTo(
                ProceedToCheckout.now()
        );
    }

    // Aleatorio
    @When("the user completes the payment with method {string}")
    public void the_user_completes_the_payment(String method) {

        String transactionCode = "Oprap" + UUID.randomUUID().toString().replace("-", "").substring(0, 6);

        user.attemptsTo(
                CompletePayment.with(method, transactionCode)
        );
    }

    @Then("the user should see the successful payment message")
    public void the_user_should_see_the_successful_payment_message() {

        user.attemptsTo(
                WaitUntil.the(CheckoutPage.PAYMENT_SUCCESS_MESSAGE, isVisible()).forNoMoreThan(10).seconds()
        );

        user.should(
                seeThat(actor -> CheckoutPage.PAYMENT_SUCCESS_MESSAGE.resolveFor(actor).isVisible(), is(true))
        );
    }

    @When("the user goes back to dashboard")
    public void the_user_goes_back_to_dashboard() {
        user.attemptsTo(
                WaitUntil.the(CheckoutPage.BACK_TO_DASHBOARD, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.BACK_TO_DASHBOARD)
        );
    }

    @When("the user opens orders")
    public void the_user_opens_orders() {
        user.attemptsTo(
                WaitUntil.the(CheckoutPage.ORDERS_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.ORDERS_BUTTON)
        );
    }

    @Then("the user should see the purchased product {string} in orders")
    public void the_user_should_see_the_purchased_product_in_orders(String productName) {

        user.attemptsTo(
                WaitUntil.the(CheckoutPage.ORDER_PRODUCT(productName), isVisible()).forNoMoreThan(10).seconds()
        );

        user.should(
                seeThat(actor -> CheckoutPage.ORDER_PRODUCT(productName).resolveFor(actor).isVisible(), is(true))
        );
    }

    @Then("the user should see the account session started")
    public void the_user_should_see_the_account_session_started() {
        user.attemptsTo(
                WaitUntil.the(LoginPage.POST_LOGIN_ELEMENT, isVisible()).forNoMoreThan(10).seconds()
        );

        user.should(
                seeThat(a -> LoginPage.POST_LOGIN_ELEMENT.resolveFor(a).isVisible(), is(true))
        );
    }
}
