package paynow.backend.tests;

import backend.model.AuthRequest;
import backend.model.AuthResponse;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.hamcrest.Matchers.*;

public class AuthTest extends BaseTest {

    @Test
    void testSuccessfulLogin() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail("ernie.hudson@gmail.com");
        authRequest.setPassword("gj5q92hcd06wrav");

        AuthResponse authResponse = given()
                .contentType(ContentType.JSON)
                .body(authRequest)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .extract().as(AuthResponse.class);

        assertNotNull(authResponse.getToken(), "Token should not be null");
        assertEquals("ernie.hudson@gmail.com", authResponse.getResp().getEmail(), "Wrong email");
    }

    @Test
    public void testInvalidPassword() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail("ernie.hudson@gmail.com");
        authRequest.setPassword("wrongPassword1");

        given()
                .contentType(ContentType.JSON)
                .body(authRequest)
                .when()
                .post("auth/login")
                .then()
                .statusCode(400)
                .body("error", equalTo("E-mail address or Password is wrong"));
    }

    @Test
    public void testMissingPassword() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail("ernie.hudson@gmail.com");

        given()
                .contentType(ContentType.JSON)
                .body(authRequest)
                .when()
                .post("auth/login")
                .then()
                .statusCode(400)
                .body("error", equalTo("Invalid data"));
    }

    @Test
    public void testBadRequest() {
        given()
                .contentType(ContentType.JSON)
                .body("")
                .when()
                .post("//auth/login")
                .then()
                .statusCode(404);
    }
}
