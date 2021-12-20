package com.daniil;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

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
        $("[for='gender-radio-1']").click(); //Не моя часть кода
        // $("#gender-radi0-3").parent().click(); можно еще вот так
        // $(byText("Other")).click(); bad practice
        // $("#genterWrapper").$(byText("Other")).click(); Так лучше вместо обычного byText, с указанием в каком блоке наш текст
        $("#userNumber").setValue("8999696969");
        // $("#dateOfBirthInput").setValue("06 Jun 1992").pressEnter(); нераблчий вариант
        //$(".react-datepicker__month-select").selectOption("June");
        //$(".react-datepicker__year-select").selectOption("1992");
        //$(".react-datepicker__day--06:not(.react-datepicker__day--outside-month)").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $("[value='6']").click();
        $(".react-datepicker__year-select").click();
        $("[value='1992']").click();
        $(".react-datepicker__day--006").click();

        // :not() запись для поиска элемента исключая что-то
        //        $$(".react-datepicker__day--06") Можно еще вот так
        //        .filter(not(cssClass(".react-datepicker__day--outside-month")))
        //        .first() // or .get(0)
        //        .click();
        // $x("//*[contains(@aria-label, \"June 6th, 1992\"]+"); Xpath лучше для поиска по сокращенному поиску, но более громоздкий
        // $("[aria-label=\"Choose Wednesday, June 6th, 1992\"]"); CSS
        // $("[aria-label$='June 6th, 1992']") CSS the best way; $ - starts with
        // $("[aria-label*='June 6th']") CSS the best way also; * - contains
        $("#subjectsInput").setValue("History").pressEnter();
        // можно еще setValue("H") byText и click() + может быть через hover(
        $("[for='hobbies-checkbox-1']").click();
        //$("#uploadPicture").uploadFile(new File("src/test/resources/images/1.png"));
        $("#uploadPicture").uploadFromClasspath("images/1.jpg"); // более простой способ

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
