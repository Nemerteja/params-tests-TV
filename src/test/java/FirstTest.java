import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byText;



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
        $(byText("30")).click();
        $("#subjectsInput").setValue("Some subject");
        $(byText("Music")).click();

        File file = new File("src/test/java/1.png");
       $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("Some address");
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();
        $("#submit").click();



}
}
