package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement
            fBirthdayInput = $("#dateOfBirthInput"),
            fMonthInput = $(".react-datepicker__month-select"),
            fYearInput = $(".react-datepicker__year-select");

public void setDate(String sDday, String sDmonth, String sDyear){
    fBirthdayInput.click();
    fMonthInput.selectOption(sDmonth);
    fYearInput.selectOption(sDyear);
    $(".react-datepicker__day--0" + sDday + ":not(.react-datepicker__day--outside-month)").click();
}


}
