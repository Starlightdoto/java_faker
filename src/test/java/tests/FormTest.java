package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.PressEnter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest extends TestBase{


    @Test
    void successfulRegTest() {
        String firstName = "Almas";
        String lastName = "Tester";
        String email = "test@test.com";
        String address = "Test address 322";
        String userNumber = "8800555353";
        String gender = "Male";
        String monthDOB = "7";
        String yearDOB = "1998";
        String subject = "Maths";
        String imgPath = "img/test.png";
        String state = "NCR";
        String city = "Delhi";

        regPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setNumber(userNumber)
                .setAddress(address)
                .setGender(gender);


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("7");
        $(".react-datepicker__year-select").selectOptionByValue("1998");
        $(".react-datepicker__day--027").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/test.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        //asserting submitted form
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive")
                .shouldHave(text("Almas Tester"), text("test@test.com"),
                        text("Male"),text("8800555353"),
                        text("July"), text("Maths"),
                        text("Sports"), text("test.png"),
                        text("Test address 123"), text("NCR Delhi"));

    }



}
