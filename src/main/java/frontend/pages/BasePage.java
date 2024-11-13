package frontend.pages;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import frontend.entity.User;
import frontend.service.UserRegistrationService;
import frontend.util.DataGenerator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BasePage {
    String baseUrl;
// не нравится использование переменных тут (юля: это про login, password, убрала их)

    public BasePage() {
        baseUrl = getBaseUrl();
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

    // юля: теперь метод возвращает объект класса User вместо сохранения логина и пароля
    public User register() {
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
}