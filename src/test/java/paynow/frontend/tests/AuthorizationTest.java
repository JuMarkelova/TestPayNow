package paynow.frontend.tests;

import frontend.entity.User;
import frontend.entity.UserWithToken;
import frontend.pages.AuthorizationPage;
import frontend.pages.HomePage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthorizationTest {
    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test
    public void successAuth() throws Exception {
        User user = authorizationPage.register().getUser();
        authorizationPage.open();
        authorizationPage.fillAuthForm(user.getEmail(), user.getPassword());
        authorizationPage.putOnFlagAcceptTerms();
        authorizationPage.submit();
        HomePage homePage = new HomePage();

//        AssertJ
//        Hamcrest Matchers
//        Написать побольше тестов бизнесовых внимательно отнестись к проверкам
//        аннотации Junit beforeAll, beforeEach и тд
        assertTrue(homePage.getHomeLabel().exists(), "There is no Home Element");
        assertEquals(homePage.getNameWelcomeElement(), user.getName(), "Incorrect name displayed");
        assertEquals(homePage.baseUrl + "/home", url(), "Wrong url");
    }

    @Test
    public void test() {
        UserWithToken userWithToken = authorizationPage.register();

    }
}
