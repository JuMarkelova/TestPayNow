package paynow.frontend.tests;

import com.codeborne.selenide.Selenide;
import frontend.entity.User;
import frontend.entity.UserWithToken;
import frontend.pages.AuthorizationPage;
import frontend.pages.BasePage;
import frontend.pages.HomePage;
import frontend.pages.RegistrationPage;
import frontend.service.UserRegistrationService;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;


public class AuthorizationTest extends BaseTest {

//    @BeforeAll
//    public static void setUp() {
//        BaseTest.setup();
//    }

    //для докера
//    @Test
//    public void testGoogleSearch() {
//        BaseTest.setup();
//        open("https://www.google.com");
//        Selenide.sleep(10000);
//        $("[name='q']").setValue("Selenide").pressEnter();
//        $("h3").shouldHave(text("Selenide: concise UI tests in Java"));
//    }

    @Test
    public void successAuthRegisteredUser() throws Exception {
        //получчается, в этом тесте просто закомментила все

//        User user = authorizationPage.register().getUser();
//        System.out.println(user);
//        authorizationPage.open();
//        authorizationPage.fillAuthForm(user.getEmail(), user.getPassword());
//        authorizationPage.putOnFlagAcceptTerms();
//        authorizationPage.submit();
//        HomePage homePage = new HomePage();

//        AssertJ -- посмотрела, использую
//        Hamcrest Matchers -- ознакомилась, что есть
//        Написать побольше тестов бизнесовых внимательно отнестись к проверкам
//        аннотации Junit beforeAll, beforeEach и тд
        assertThat(homePage.getHomeLabel().exists())
                .as("There is no Home Element")
                .isTrue();
        assertThat(homePage.getNameWelcomeElement())
                .as("Incorrect name displayed")
                .isEqualTo(BaseTest.user.getName());
        assertThat(url())
                .as("Wrong url")
                .isEqualTo(homePage.baseUrl + homePage.HOME_URL_PATH);
    }

//    @Test
//    public void test() {
//        UserWithToken userWithToken = authorizationPage.register();
//        BasePage basePage = new BasePage();
//        basePage.openAuthorized("/home", userWithToken.getToken());
//        Selenide.sleep(5000);
//    }
}
