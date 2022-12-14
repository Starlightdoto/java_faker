package tests;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.components.CalendarComponent;
import tests.random_data.RandomUtil;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FormTest extends TestBase{
RandomUtil rndU = new RandomUtil();

    @Test
    void successfulRegTest() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String address = faker.animal().name();
        String userNumber = faker.phoneNumber().subscriberNumber(10);
        String gender = faker.demographic().sex();
        Integer dayDOB = faker.number().numberBetween(1, 28);
        String monthDOB = rndU.pickDate();
        Integer yearDOB = faker.number().numberBetween(1990, 2005);
        String subject = rndU.pickSubj();
        String imgPath = "img/test.png"; // не вижу смысла искать способ рандомную картинку подгружать
        String imgName = "test.png"; // то же самое что и пункт выше
        String state = "NCR"; // тут и следующая строка - взаимосвязаны,
                                // и если рандомно будет выбран штат - не угадаешь какой нужен город, проще оставить хардкод
        String city = "Delhi";
        String hobbie = rndU.pickHobbie();


        regPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setNumber(userNumber)
                .setAddress(address)
                .setGender(gender)
                .setBirthDate(dayDOB.toString(), monthDOB, yearDOB.toString())
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
