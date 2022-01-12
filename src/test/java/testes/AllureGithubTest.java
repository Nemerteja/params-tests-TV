package testes;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AllureGithubTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    public void TestIssue() {
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("allure-starter");
        $(".header-search-input").submit();
        $(By.linkText("qa-guru/allure-starter")).click();
        $("#issues-tab").shouldHave(Condition.text("Issues"));
    }
}
