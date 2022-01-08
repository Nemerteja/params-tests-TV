package testes;

import com.github.javafaker.Faker;

public class TestData {

    Faker faker = new Faker();

  //  String name = faker.name().fullName(); // Miss Samanta Schmidt
  //  String firstName = faker.name().firstName(); // Emory
  //  String lastName = faker.name().lastName(); // Barton

   // String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449

    public static  String fFirstName = "Some",
            fSurName = "Name",
            fEmailIn = "aaa@aa.aa",
            fGenderRad = "Female",
            fPhoneIn = "1234567891",
            fDayIn = "25",
            fMonthIn = "April",
            fYearIn = "2005",
            fSubjectIn = "Maths",
            fHobbieCheck = "Sports",
            fAdressIn = "Some address",
            fStateIn = "NCR",
            fCityIn = "Delhi";
}
