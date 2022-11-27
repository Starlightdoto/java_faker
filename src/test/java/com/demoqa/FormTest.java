package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.PressEnter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1200";
        Configuration.headless = false;
    }

    @Test
    void successfulRegTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Almas");
        $("#lastName").setValue("Tester");
        $("#userEmail").setValue("test@test.com");
        $("#currentAddress").setValue("Test address 123");
        $("#userNumber").setValue("88005553535");
        $("#gender-radio-1").parent().click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("7");
        $(".react-datepicker__year-select").selectOptionByValue("1998");
        $(".react-datepicker__day--027").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFromClasspath("img/test.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Almas"), text("Tester"), text("test@test.com"));



    }



}
