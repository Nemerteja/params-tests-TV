package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {


    private SelenideElement
            fNameInp = $("#firstName"),
            fSurNameInp = $("#lastName"),
            fEmailInp = $("#userEmail"),
            fPhoneInp = $("#userNumber"),
            fGenderRadio = $("#genterWrapper"),
            fHobbieCheckbox = $("#hobbiesWrapper"),
            fAdressInp = $("#currentAddress"),
            fStateDropDown = $("#state"),
            fCityDropDown = $("#city"),
            fSubjectInput = $("#subjectsInput"),
            finaltable = $(".table-responsive");

    public CalendarComponent fcalendar = new CalendarComponent();

    public void openPage (){
        open("https://demoqa.com/automation-practice-form");
        fNameInp.scrollIntoView(true);
    }

    public void inputName (String valName, String valSurname){
        fNameInp.setValue(valName);
        fSurNameInp.setValue(valSurname);
    }

    public void inputEmail (String valEmail){
        fEmailInp.setValue(valEmail);
    }

    public void inputPhone (String valPhone){
        fPhoneInp.setValue(valPhone);
    }

    public void radioGender (String valGender){
        fGenderRadio.$(byText(valGender)).click();
    }

    public void checkboxHobbie (String valHobbie){
        fHobbieCheckbox.$(byText(valHobbie)).click();
    }

    public void inputAdress (String valAdress){
        fAdressInp.setValue(valAdress);
    }

    public void inputState (String valState){
         fStateDropDown.click();
         $(byText(valState)).click();
    }

    public void inputCity (String valCity){
        fCityDropDown.click();
        $(byText(valCity)).click();
    }

    public void inputSubject (String valSubject){
        fSubjectInput.setValue(valSubject).pressEnter();
            }
            public RegistrationPage checkResults (String key, String sresults){
              finaltable.$(byText(key)).parent().shouldHave(Condition.text(sresults));

              return this;
            }

    public RegistrationPage checkExactResults (String key, String sresults){
        finaltable.$(byText(key)).parent().shouldHave(Condition.exactText(sresults));

        return this;
    }
 }
