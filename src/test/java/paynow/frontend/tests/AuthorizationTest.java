package paynow.frontend.tests;

import frontend.pages.AuthorizationPage;
import frontend.pages.HomePage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthorizationTest {
    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test
    public void successAuth() throws Exception {
        String[] creds = authorizationPage.open();
        HomePage homePage = authorizationPage.fillAuthFormAndAuth(creds[0], creds[1]);

        assertTrue(homePage.getHomeLabel().exists(), "There is no Home Element");
        assertEquals(baseUrl + "/home", url(), "Wrong url");
    }
}
