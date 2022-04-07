package beginautotests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class TestForm {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void FormInput() {
        // parameters
        String name = "Oksana";
        String lastname = "Ivanova";
        String userEmail = "oksana@com.com";
        String subject = "Civics";
        String phone = "9988778899";
        String image ="Areyouabeer.jpg";
        String fecha = "06 April,1985";
        String hobby = "Music";
        String address = "Mejor del mundo";
        String state = "Rajasthan";
        String city = "Jaipur";

       // form filling
        open("/automation-practice-form");
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(userEmail);
        $(byText("Female")).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1985");
        $(byText("6")).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(image);
        $("#currentAddress").setValue(address);
        $("#close-fixedban").click();
        $("#state").scrollIntoView(true).click();
        $("#state").$(byText(state)).click();
        $("#city").scrollIntoView(true).click();
        $("#city").$(byText(city)).click();
        $("#submit").pressEnter();

        // check values in the table
        $(".table-responsive").shouldHave((text(name + " " + lastname)),
                (text(userEmail)), (text(subject)), (text(phone)),
                (text(image)), (text(fecha)), (text(hobby)),
                (text(address)), (text(state + " " + city)));

    }
}

