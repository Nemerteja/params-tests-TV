package testes;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideGithubTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void SelenideWikiSoftAssertionsShouldHaveCodeJUnit5() {

        //Открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        //В списке страниц должна быть страница SoftAssertions
        $(".markdown-body").shouldHave(text("Soft assertions"));
        //Открыть страницу SoftAssertions
        $(byText("Soft assertions")).click();
        // Проверить, что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5"),text("SoftAssertsExtension.class"));

    }
}
