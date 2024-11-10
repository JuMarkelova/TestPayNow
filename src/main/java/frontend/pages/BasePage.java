package frontend.pages;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import frontend.util.DataGenerator;
import frontend.util.UserRegistrationService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class BasePage {
    String baseUrl;
    private String login;
    private String password;

    public BasePage() {
        baseUrl = getBaseUrl();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    private String getBaseUrl() {
        Properties properties = new Properties();
        String baseUrl = "";

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("test.properties")) {
            properties.load(input);

            baseUrl = properties.getProperty("base.url");
            System.out.println(baseUrl);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return baseUrl;
    }

    public void open(String urlPath) {
        Selenide.open(baseUrl + urlPath);
    }

    public void register() {
        UserRegistrationService userRegistrationService = new UserRegistrationService();
        Faker faker = new Faker();
        UserRegistrationService.UserRequestBuilder builder = new UserRegistrationService.UserRequestBuilder()
                .withEmail(faker.internet().emailAddress())
                .withPassword(faker.internet().password())
                .withName(faker.name().firstName())
                .withNumber(DataGenerator.numberGenerator())
                .withPin(DataGenerator.numberGenerator());
        Map<String, String> credentials = userRegistrationService.registerNewUser(builder);
        this.login = credentials.get("email");
        this.password = credentials.get("password");
    }
}