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
        $("#firstName").scrollIntoView(true);
        $("#firstName").setValue("Some");
        $("#lastName").setValue("Name");
        $("#userEmail").setValue("aaa@aa.aa");
        $(".custom-radio").click();
        $("#userNumber").setValue("1234567891");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $("[value=\"3\"]").click();
        $(".react-datepicker__year-select").click();
        $("[value=\"2005\"]").click();
        $(".react-datepicker__day--025").click();
        $("#subjectsInput").setValue("m");
        $(byText("Maths")).click();
        $(".custom-checkbox").click();

        File file = new File("src/test/java/testes/resourses/1.png");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("Some address");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".modal-body").shouldHave(text("Student Name"), text("Some Name"),
                text("Student Email"), text("aaa@aa.aa"),
                text("Gender"), text("Male"),
                text("Mobile"), text("1234567891"),
                text("Date of Birth"), text("25 April,2005"),
                text("Subjects"), text("Maths"),
                text("Hobbies"), text("Sports"),
                text("Picture"), text("1.png"),
                text("Address"), text("Some address"),
                text("State and City"), text("NCR Delhi"));

    }
}
