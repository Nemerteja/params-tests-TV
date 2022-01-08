package testes;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FirstTest extends TestBase {

    @Test
    void fillFormTest() {
        registrationPage.openPage();
        registrationPage.inputName("Some", "Name");
        registrationPage.inputEmail("aaa@aa.aa");
        registrationPage.radioGender("Male");
        registrationPage.inputPhone("1234567891");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $("[value=\"3\"]").click();
        $(".react-datepicker__year-select").click();
        $("[value=\"2005\"]").click();
        $(".react-datepicker__day--025").click();

        registrationPage.inputSubject("Maths");
        registrationPage.checkboxHobbie("Sports");

        File file = new File("src/test/java/testes/resourses/1.png");
        $("#uploadPicture").uploadFile(file);

        registrationPage.inputAdress("Some address");
        registrationPage.inputState("NCR");
        registrationPage.inputCity("Delhi");
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);
        registrationPage.checkResults("Student Name", "Some Name")
                .checkResults("Student Email", "aaa@aa.aa")
                .checkExactResults("Gender", "Gender Male")
                .checkResults("Mobile", "1234567891")
                .checkResults("Subjects", "Maths")
                .checkResults("Hobbies", "Sports")
                .checkResults("Picture", "1.png")
                .checkResults("Address", "Some address")
                .checkResults("State and City", "NCR Delhi");



        $(".modal-body").shouldHave(text("Date of Birth"), text("25 April,2005"));

               //  text("Date of Birth"), text("25 April,2005"),


    }
}
