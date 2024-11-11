package frontend.util;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class UserRegistrationService {
    private static final String REGISTER_URL = "http://localhost:3000/auth/register";

    public UserRegistrationService() {
        RestAssured.baseURI = REGISTER_URL;
    }

    public Map<String, String> registerNewUser(UserRequestBuilder builder) {
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(builder.build())
                .post();

        if (response.statusCode() == 200 || response.statusCode() == 201) {
            Map<String, String> result = new HashMap<>();
            result.put("email", builder.build().get("email"));
            result.put("password", builder.build().get("password"));
            return result;
        } else {
            throw new RuntimeException("Error while creating user: " + response.getBody().asString());
        }
    }

    // Авторизация по апи

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
