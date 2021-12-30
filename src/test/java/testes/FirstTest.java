package testes;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FirstTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").scrollIntoView(true);
        $("[id=firstName]").setValue("Some");
        $("[id=lastName]").setValue("Name");
        $("#userEmail").setValue("aaa@aa.aa");
        $("[class=\"custom-control custom-radio custom-control-inline\"]").click();
        $("#userNumber").setValue("1234567891");

        $("#dateOfBirthInput").click();
        $("[class=\"react-datepicker__month-select\"]").click();
        $("[value=\"3\"]").click();
        $("[class=\"react-datepicker__year-select\"]").click();
        $("[value=\"2005\"]").click();
        $("[class=\"react-datepicker__day react-datepicker__day--025\"]").click();
        $("#subjectsInput").setValue("m");
        $(byText("Maths")).click();
        $("[class=\"custom-control custom-checkbox custom-control-inline\"]").click();

        File file = new File("src/test/java/testes/resourses/1.png");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("Some address");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $("[class=\"modal-body\"]").shouldHave(text("Student Name"), text("Some Name"),
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
