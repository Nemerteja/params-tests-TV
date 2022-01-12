package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsForGithubTest {

    private SelenideElement
            fSearchField = $(".header-search-input"),
            fIssue = $("#issues-tab");

@Step("Открыть главную страницу")
            public void openGithub (){
        open("https://github.com");
            }
    @Step("Ввести в поиск {valSearch}")
    public void searchGithub (String valSearch){
        $(fSearchField).click();
        $(fSearchField).sendKeys(valSearch);
        $(fSearchField).submit();
    }
    @Step("Перейти по ссылке {valRepo}")
    public void goToLinkGithub (String valRepo){
        $(By.linkText(valRepo)).click();
    }
    @Step("Проверить написание Issues в репозитории")
    public void IssueGithub (){
        $(fIssue).shouldHave(Condition.text("Issues"));
    }
}
