package beginautotests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;


public class TestFormWithFaker {
    // parameters
    Faker faker = new Faker();
    String name = faker.name().firstName(),
            lastname = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            address = faker.address().fullAddress();
    String FullName = format("%s %s", name, lastname);
    String subject = "Civics";
    String phone = "9988778899";
    String image ="Areyouabeer.jpg";
    String fecha = "06 April,1985";
    String hobby = "Music";
    String state = "Rajasthan";
    String city = "Jaipur";

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void FormInput() {


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
        $(".table-responsive").shouldHave((text(FullName)),
                (text(userEmail)), (text(subject)), (text(phone)),
                (text(image)), (text(fecha)), (text(hobby)),
                (text(address)), (text(state + " " + city)));

    }
}

