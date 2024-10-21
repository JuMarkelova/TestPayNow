package paynow.frontend.tests;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import frontend.util.DataGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import frontend.pages.RegistrationPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest {
    private RegistrationPage registrationPage;

    @BeforeAll
    public static void setup() {
        baseUrl = "http://localhost:5173/";
    }

    @BeforeEach
    void init() {
        registrationPage = new RegistrationPage();
    }

    @Test
    public void registerSuccessfully() throws InterruptedException {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String name = faker.name().firstName();
        String phoneNumber = DataGenerator.phoneNumberGenerator();

        registrationPage.open();
        registrationPage.fillRegistrationForm(email,
                password,
                name,
                phoneNumber,
                12345678);
        Selenide.sleep(1000);
        registrationPage.putOnFlagAcceptTerms();
        Selenide.sleep(1000);
        registrationPage.submit();
        Selenide.sleep(5000);
        assertEquals(baseUrl + "home", url(), "Wrong url");
    }
}
