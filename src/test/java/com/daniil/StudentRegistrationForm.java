package com.daniil;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Тест второго урока")
public class StudentRegistrationForm {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void studentRegistrationFormTest(){
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Daniil");
        $("#lastName").setValue("Kravchenko");
        $("#userEmail").setValue("secret@mail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("8999696969");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $("[value='6']").click();
        $(".react-datepicker__year-select").click();
        $("[value='1992']").click();
        $(".react-datepicker__day--006").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("images/1.jpg");
        $("#currentAddress").setValue("Mohadisha Temple").scrollTo();
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(byText("Daniil Kravchenko")).shouldBe(visible);
        $(byText("secret@mail.com")).shouldBe(visible);
        $(byText("Male")).shouldBe(visible);
        $(byText("8999696969")).shouldBe(visible);
        $(byText("06 July,1992")).shouldBe(visible);
        $(byText("History")).shouldBe(visible);
        $(byText("Sports")).shouldBe(visible);
        $(byText("1.jpg")).shouldBe(visible);
        $(byText("Mohadisha Temple")).shouldBe(visible);
        $(byText("NCR")).shouldBe(visible);
        $(byText("Delhi")).shouldBe(visible);
    }
}
