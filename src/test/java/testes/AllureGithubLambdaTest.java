package testes;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AllureGithubLambdaTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    public void TestIssue() {
        step("Открыть главную страницу", () -> {
            open("https://github.com");
        });
        step("Ввести в поиск allure-starter", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("allure-starter");
            $(".header-search-input").submit();
        });
        step("Перейти по ссылке qa-guru/allure-starter", () -> {
            $(By.linkText("qa-guru/allure-starter")).click();
        });
        step("Проверить написание Issues в репозитории", () -> {
            $("#issues-tab").shouldHave(Condition.text("Issues"));
        });

    }
}
