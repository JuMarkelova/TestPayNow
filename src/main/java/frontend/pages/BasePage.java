package frontend.pages;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import frontend.entity.UserWithToken;
import frontend.service.UserRegistrationService;
import frontend.util.DataGenerator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BasePage {
    public String baseUrl;

    public BasePage() {
        baseUrl = getBaseUrl();
    }

    private String getBaseUrl() {
        Properties properties = new Properties();
        String baseUrl = "";

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("test.properties")) {
            properties.load(input);
            baseUrl = properties.getProperty("base.url");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return baseUrl;
    }

    public void open(String urlPath) {
        Selenide.open(baseUrl + urlPath);
    }

    public UserWithToken register() {
        UserRegistrationService userRegistrationService = new UserRegistrationService();
        Faker faker = new Faker();
        UserRegistrationService.UserRequestBuilder builder = new UserRegistrationService.UserRequestBuilder()
                .withEmail(faker.internet().emailAddress())
                .withPassword(faker.internet().password())
                .withName(faker.name().firstName())
                .withNumber(DataGenerator.numberGenerator())
                .withPin(DataGenerator.numberGenerator());
        return userRegistrationService.registerNewUser(builder);
    }

    public void openAuthorized(String urlPath, String token) {
        UserRegistrationService userRegistrationService = new UserRegistrationService();
        userRegistrationService.openPageAsAuthenticatedUser(urlPath, token);
    }
}