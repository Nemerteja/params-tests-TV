package testes;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
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
        $(byText("Female")).click();
        $("#userNumber").setValue("1234567891");

        $("#dateOfBirthInput").click();
        $(byText("December")).click();
        $(byText("April")).click();
        $(byText("2021")).click();
        $(byText("2005")).click();
        $(byText("25")).click();
        $("#subjectsInput").setValue("m");
        $(byText("Maths")).click();
        $(byText("Music")).click();

        File file = new File("src/test/java/testes/resourses/1.png");
       $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("Some address");
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $("[class=\"modal-body\"]").shouldHave(text("Student Name"),text("Some Name"),
                text("Student Email"),text("aaa@aa.aa"),
                text("Gender"),text("Female"),
                text("Mobile"),text("1234567891"),
                text("Date of Birth"),text("25 April,2005"),
                text("Subjects"),text("Maths"),
                text("Hobbies"),text("Music"),
                text("Picture"),text("1.png"),
                text("Address"),text("Some address"),
                text("State and City"),text("NCR Delhi"));

}
}
