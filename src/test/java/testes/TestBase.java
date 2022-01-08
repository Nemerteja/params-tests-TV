package testes;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import com.github.javafaker.Faker;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    public String fakerFirstName = faker.name().firstName();
    public String fakerSurName = faker.name().lastName();
    public String fakerEmail = faker.name().username() + "@gmail.com";
    public String fakerAdress = faker.address().streetAddress();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }
}
