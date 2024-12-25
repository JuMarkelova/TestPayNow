package frontend.pages;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import frontend.entity.UserWithToken;
import common.service.UserRegistrationService;
import common.util.DataGenerator;
import common.util.PropertiesUtil;

public class BasePage {
    public String baseUrl;

    public BasePage() {
        baseUrl = PropertiesUtil.getProperty("base.url");
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