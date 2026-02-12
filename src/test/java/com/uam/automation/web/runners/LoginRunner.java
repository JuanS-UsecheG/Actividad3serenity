package com.uam.automation.web.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/f" +
                "" +
                "eatures/login.feature",
        glue = "com.uam.automation.web.stepdefinitions"
)
public class LoginRunner { }
