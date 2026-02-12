package com.uam.automation.web.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {

    // Dropdown visible
    public static final Target PAYMENT_DROPDOWN =
            Target.the("payment dropdown")
                    .located(By.xpath("//span[contains(@id,'select2-advFieldsStatus')]"));

    // busqueda de Select2
    public static final Target SELECT2_SEARCH =
            Target.the("select2 search input")
                    .located(By.cssSelector("input.select2-search__field"));

    // por texto
    public static Target paymentOption(String text) {
        return Target.the("payment option " + text)
                .located(By.xpath("//li[contains(@class,'select2-results__option') and normalize-space(.)='" + text + "']"));
    }

    // Transaction information
    public static final Target TRANSACTION_INFO =
            Target.the("transaction information textarea")
                    .located(By.xpath("//textarea[@name='transaction_info']"));

    //Pay Now
    public static final Target PAY_NOW =
            Target.the("pay now button")
                    .located(By.xpath("//input[@name='form3']"));

    // Validacion
    public static final Target PAYMENT_SUCCESS_MESSAGE =
            Target.the("payment success message")
                    .located(By.xpath("//*[contains(normalize-space(.),'Congratulation! Payment is successful')]"));

    // Dashboard
    public static final Target BACK_TO_DASHBOARD =
            Target.the("back to dashboard button")
                    .located(By.xpath("//a[@href='dashboard.php']"));

    // Orders
    public static final Target ORDERS_BUTTON =
            Target.the("orders button")
                    .located(By.xpath("//button[normalize-space()='Orders']"));

    // Verificar Term = Producto ordenado
    public static Target ORDER_PRODUCT(String productName) {
        return Target.the("product in orders: " + productName)
                .located(By.xpath("//*[contains(normalize-space(.),'" + productName + "')]"));
    }
}
