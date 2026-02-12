package com.uam.automation.web.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HeaderPage {

    public static final Target CART_ICON =
            Target.the("cart icon")
                    .located(By.xpath("//a[contains(text(),'Cart')]"));
}
