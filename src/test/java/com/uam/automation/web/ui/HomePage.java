package com.uam.automation.web.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target SEARCH_INPUT =
            Target.the("search input field")
                    .located(By.name("search_text"));  // ajustar si es necesario
}
