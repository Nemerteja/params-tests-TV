package testes;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class ParamsTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;}

    @ValueSource(strings = {"Фьючерсы", "Криптовалюты"})
    @ParameterizedTest(name = "Поиск в Рынках раздела {0}")
    void tradingViewMarketsTestValueSrc(String searchMarketName) {


        open("https://ru.tradingview.com/");

        $("[data-main-menu-root-track-id=\"markets\"]").click();

        $(".tv-category-header__tags-content").shouldHave(text(searchMarketName));


    }

    @CsvSource({"Фьючерсы, Сельхозтовары","Криптовалюты, Биткоин"})
    @ParameterizedTest(name = "Поиск в Рынках раздела {0} и проверка наличия раздела {1}")
    void tradingViewMarketsTestCSV(String searchMarketName, String expectedResult) {


        open("https://ru.tradingview.com/");

        $("[data-main-menu-root-track-id=\"markets\"]").click();

        $(".tv-category-header__tags-content").shouldHave(text(searchMarketName));

        $(byText(searchMarketName)).click();

        $(".tv-widget-watch-list__head").shouldHave(text(expectedResult));

    }

    static Stream<Arguments> tradingViewMarketsTestMethodSrc(){
        return Stream.of(
            Arguments.of("Фьючерсы", "Сельхозтовары"), Arguments.of("Криптовалюты", "Биткоин")
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Поиск в Рынках раздела {0} и проверка наличия раздела {1}")
    void tradingViewMarketsTestMethodSrc(String searchMarketName, String expectedResult) {


        open("https://ru.tradingview.com/");

        $("[data-main-menu-root-track-id=\"markets\"]").click();

        $(".tv-category-header__tags-content").shouldHave(text(searchMarketName));

        $(byText(searchMarketName)).click();

        $(".tv-widget-watch-list__head").shouldHave(text(expectedResult));

    }

    @EnumSource(ForSearch.class)
    @ParameterizedTest(name = "Поиск в Рынках раздела {0}")
    void tradingViewMarketsTestEnum(ForSearch searchMarketName) {


        open("https://ru.tradingview.com/");

        $("[data-main-menu-root-track-id=\"markets\"]").click();

        $(".tv-category-header__tags-content").shouldHave(text(searchMarketName.name()));

    }
}
