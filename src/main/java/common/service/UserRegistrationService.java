package common.service;

import backend.model.AuthResponse;
import com.codeborne.selenide.Selenide;
import frontend.entity.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class UserRegistrationService {
    private static final String REGISTER_URL = "http://localhost:3000/auth/register";

    public UserRegistrationService() {
        RestAssured.baseURI = REGISTER_URL;
    }

    public User registerNewUser(UserRequestBuilder builder) {
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(builder.build())
                .post();

        if (response.statusCode() == 200 || response.statusCode() == 201) {
            AuthResponse authResponse = response.getBody().as(AuthResponse.class);

            User user = new User();
            user.setToken(authResponse.getToken());
            user.setEmail(authResponse.getResp().getEmail());
            user.setName(authResponse.getResp().getName());
            user.setPassword(authResponse.getResp().getPassword());
            return user;
        } else {
            throw new RuntimeException("Error while creating user: " + response.getBody().asString());
        }
    }

    // Авторизация по апи
    //попробовать метод cookie

    public void openPageAsAuthenticatedUser(String url, String token) {
        Selenide.open("about:blank");

        Selenide.executeJavaScript("localStorage.setItem('authToken', arguments[0]);", token);

        Selenide.open(url);
    }

    public static class UserRequestBuilder {
        private final Map<String, String> requestBody = new HashMap<>();

        public UserRequestBuilder withEmail(String email) {
            requestBody.put("email", email);
            return this;
        }

        public UserRequestBuilder withPassword(String password) {
            requestBody.put("password", password);
            return this;
        }

        public UserRequestBuilder withName(String name) {
            requestBody.put("name", name);
            return this;
        }

        public UserRequestBuilder withNumber(String number) {
            requestBody.put("number", number);
            return this;
        }

        public UserRequestBuilder withPin(String pin) {
            requestBody.put("pin", pin);
            return this;
        }

        public Map<String, String> build() {
            return requestBody;
        }
    }
}
