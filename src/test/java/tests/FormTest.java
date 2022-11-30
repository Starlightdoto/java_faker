package tests;
import org.junit.jupiter.api.Test;

public class FormTest extends TestBase{


    @Test
    void successfulRegTest() {
        String firstName = "Almas";
        String lastName = "Tester";
        String email = "test@test.com";
        String address = "Test address 322";
        String userNumber = "8800555353";
        String gender = "Male";
        String dayDOB = "27";
        String monthDOB = "July";
        String yearDOB = "1998";
        String subject = "Maths";
        String imgPath = "img/test.png";
        String imgName = "test.png";
        String state = "NCR";
        String city = "Delhi";
        String hobbie = "Sports";


        regPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setNumber(userNumber)
                .setAddress(address)
                .setGender(gender)
                .setBirthDate(dayDOB, monthDOB, yearDOB)
                .setSubjects(subject)
                .setHobbie(hobbie)
                .setPicture(imgPath)
                .setStateAndCity(state, city)
                .submitForm();


        //asserting submitted form
        regPage.verifyResultsModalAppears()
                        .verifyResult("Student Name", firstName + " " + lastName)
                        .verifyResult("Student Email", email)
                        .verifyResult("Gender", gender)
                        .verifyResult("Mobile", userNumber)
                        .verifyResult("Date of Birth", dayDOB + " " + monthDOB + "," + yearDOB)
                        .verifyResult("Subjects", subject)
                        .verifyResult("Hobbies", hobbie )
                        .verifyResult("Picture", imgName)
                        .verifyResult("Address", address)
                        .verifyResult("State and City", state + " " + city);

    }

}
