package frontend.pages;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import frontend.util.DataGenerator;
import frontend.util.UserRegistrationService;
import java.io.FileReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class BasePage {
    String baseUrl;

    public BasePage() {
        baseUrl = getBaseUrl();
    }

    private String getBaseUrl() {
        Properties properties = new Properties();
        String baseUrl = "";

// Относительный путь до файла посмотреть класс FileReader
        try (InputStream input = new FileInputStream("/Users/iuliia/javaStudy/mentorSession/projPayNow/TestPayNow/src/main/resources/test.properties")) {
            properties.load(input);

            baseUrl = properties.getProperty("base.url");
            System.out.println(baseUrl);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return baseUrl;
    }

    public void open(String urlPath) throws Exception {
        Selenide.open(baseUrl + urlPath);
    }

//    Подумать
    public String[] openRegistered(String urlPath) throws Exception {
        UserRegistrationService userRegistrationService = new UserRegistrationService();
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String name = faker.name().firstName();
        String phoneNumber = DataGenerator.numberGenerator();
        String pin = DataGenerator.numberGenerator();
        String[] creds = userRegistrationService.registerNewUser(email, password, name, phoneNumber, pin);
        Selenide.open(baseUrl + urlPath);
        return creds;
    }
}