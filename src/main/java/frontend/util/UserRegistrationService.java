package frontend.util;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.openqa.selenium.Cookie;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRegistrationService {

    private static final String REGISTER_URL = "http://localhost:3000/auth/register";
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    private String token;

    public UserRegistrationService() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public String[] registerNewUser(String email, String password, String name, String number, String pin) throws Exception {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("email", email);
        requestBody.put("password", password);
        requestBody.put("name", name);
        requestBody.put("number", number);
        requestBody.put("pin", pin);
        String requestBodyJson = objectMapper.writeValueAsString(requestBody);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(REGISTER_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBodyJson))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200 || response.statusCode() == 201) {
            return new String[]{email, password};
//            JsonNode jsonResponse = objectMapper.readTree(response.body());
//            this.token = jsonResponse.get("token").asText();
//            return this.token;

        } else {
            throw new RuntimeException("Ошибка при регистрации пользователя: " + response.body());
        }
        // post-запрос регистрации
        // return user, cookie
    }

//    public void auth() throws Exception {
//        Faker faker = new Faker();
//        String email = faker.internet().emailAddress();
//        String password = faker.internet().password();
//        String name = faker.name().firstName();
//        String phoneNumber = DataGenerator.numberGenerator();
//        String pin = DataGenerator.numberGenerator();
//
//        String token = registerNewUser(email, password, name, phoneNumber, pin);
////        registerNewUser(email, password, name, phoneNumber, pin);
//        com.codeborne.selenide.Selenide.open("http://localhost:5173");
//
//        Selenide.executeJavaScript("localStorage.setItem('token', arguments[0]);", token);
//        System.out.println(Optional.ofNullable(Selenide.executeJavaScript("return localStorage.getItem('token');")));
//
//        // String cookie = registerNewUser.cookie
//        // set cookie
//    }
}
