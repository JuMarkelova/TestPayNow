package paynow.frontend.tests;

import frontend.entity.User;
import frontend.entity.UserWithToken;
import frontend.pages.AuthorizationPage;
import frontend.pages.HomePage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public abstract class BaseTest {
    protected AuthorizationPage authorizationPage = new AuthorizationPage();
    protected HomePage homePage;

    protected static User user;

//    //это я докер пыталась запускать
//    @BeforeAll
//    public static void setup() {
//        browser = "chrome"; // Название браузера
//        browserVersion = "127.0"; // Укажите версию, если она не default
//        remote = "http://localhost:4444/wd/hub"; // Адрес Selenoid
//        browserSize = "1920x1080"; // Размер окна
//        headless = false; // Если хотите видеть браузер в VNC
//    }

    @BeforeAll
    public void register() throws Exception {
        UserWithToken userWithToken = authorizationPage.register();
        user = userWithToken.getUser();
    }

    @BeforeEach
    public void auth() throws Exception {
        authorizationPage.open();
        System.out.println(user.getEmail() + " " + user.getPassword());
        authorizationPage.fillAuthForm(user.getEmail(), user.getPassword());
        authorizationPage.putOnFlagAcceptTerms();
        authorizationPage.submit();
        homePage = new HomePage();
    }
}
