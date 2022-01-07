package testes;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragDropSquaresTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;}

    @Test
    void DragNDropSelenide() {

        //Открыть страницу
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //Перенести прямоугольник А на место В
        //actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        //с dragAndDropTo работает
        $("#column-a").dragAndDropTo("#column-b");
        //Проверить, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));

    }
}
