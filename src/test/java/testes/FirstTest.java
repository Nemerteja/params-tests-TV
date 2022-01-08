package testes;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class FirstTest extends TestBase {

    String fFirstName = "Some",
            fSurName = "Name",
            fEmailIn = "aaa@aa.aa",
            fGenderRad = "Female",
            fPhoneIn = "1234567891",
            fDayIn = "25",
            fMonthIn = "April",
            fYearIn = "2005",
            fSubjectIn = "Maths",
            fHobbieCheck = "Sports",
            fAdressIn = "Some address",
            fStateIn = "NCR",
            fCityIn = "Delhi";

    @Test
    void fillFormTest() {
        registrationPage.openPage();
        registrationPage.inputName(fFirstName, fSurName);
        registrationPage.inputEmail(fEmailIn);
        registrationPage.radioGender(fGenderRad);
        registrationPage.inputPhone(fPhoneIn);

        registrationPage.fcalendar.setDate(fDayIn, fMonthIn,fYearIn);

        registrationPage.inputSubject(fSubjectIn);
        registrationPage.checkboxHobbie(fHobbieCheck);

        File file = new File("src/test/java/testes/resourses/1.png");
        $("#uploadPicture").uploadFile(file);

        registrationPage.inputAdress(fAdressIn);
        registrationPage.inputState(fStateIn);
        registrationPage.inputCity(fCityIn);
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);
        registrationPage.checkResults("Student Name", fFirstName + " " + fSurName)
                .checkResults("Student Email", fEmailIn)
                .checkExactResults("Gender", "Gender " + fGenderRad)
                .checkResults("Mobile", fPhoneIn)
                .checkResults("Date of Birth", fDayIn+ " " + fMonthIn + "," + fYearIn)
                .checkResults("Subjects", fSubjectIn)
                .checkResults("Hobbies", fHobbieCheck)
                .checkResults("Picture", "1.png")
                .checkResults("Address", fAdressIn)
                .checkResults("State and City", fStateIn + " " + fCityIn);

    }
}
