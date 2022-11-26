package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1200";
        Configuration.headless = false;
    }

    @Test
    void fillForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Almas");
        $("#lastName").setValue("Tester");
        $("#userEmail").setValue("test@test.com");
        $("#userNumber").setValue("88005553535");
        $("#dateOfBirthInput").click();
    }



}
