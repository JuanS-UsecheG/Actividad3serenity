package com.uam.automation.web.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    // Botón/link que te lleva al login (menú/header)
    public static final Target LOGIN_ENTRY = Target.the("login entry point (link/button)")
            .located(By.xpath("//a[contains(.,'Login') or contains(.,'Ingresar') or contains(.,'Iniciar')]"
                    + " | //button[contains(.,'Login') or contains(.,'Ingresar') or contains(.,'Iniciar')]"));

    // Campo usuario: intenta por name/id comunes o placeholder
    public static final Target USERNAME = Target.the("username/email field")
            .located(By.cssSelector("input[name='email'], input#email, input[name='username'], input#username, input[type='email']"));

    public static final Target PASSWORD = Target.the("password field")
            .located(By.cssSelector("input[name='password'], input#password, input[type='password']"));

    public static final Target LOGIN_BUTTON = Target.the("login submit button")
            .located(By.xpath("//button[@type='submit' and (contains(.,'Login') or contains(.,'Ingresar') or contains(.,'Iniciar'))]"
                    + " | //button[contains(.,'Login') or contains(.,'Ingresar') or contains(.,'Iniciar')]"
                    + " | //input[@type='submit']"));

    // Señal post-login
    public static final Target POST_LOGIN_ELEMENT =
            Target.the("logged in banner")
                    .located(By.xpath("//*[contains(normalize-space(.),'Logged in as')]"));
}
