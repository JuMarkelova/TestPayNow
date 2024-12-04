package paynow.frontend.tests;

import com.github.javafaker.Faker;
import frontend.pages.HomePage;
import frontend.util.DataGenerator;
import org.junit.jupiter.api.Test;
import frontend.pages.RegistrationPage;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest {
    private RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registerSuccessfully() throws Exception {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String name = faker.name().firstName();
        String phoneNumber = DataGenerator.numberGenerator();
        String pin = DataGenerator.numberGenerator();
        registrationPage.open();
        registrationPage.fillRegistrationForm(email,
                password,
                name,
                phoneNumber,
                pin);
        registrationPage.putOnFlagAcceptTerms();
        registrationPage.submit();
        HomePage homePage = new HomePage();
        assertEquals(homePage.baseUrl + homePage.HOME_URL_PATH, url(), "Wrong url");
        assertTrue(homePage.getHomeLabel().exists(), "There is no Home Element");
        assertEquals(homePage.getNameWelcomeElement(), name, "Incorrect name displayed");
    }
}
