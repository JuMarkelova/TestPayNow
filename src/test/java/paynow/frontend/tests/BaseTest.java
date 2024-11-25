package paynow.frontend.tests;

import frontend.pages.AuthorizationPage;

import static com.codeborne.selenide.Configuration.*;

public class BaseTest {
    protected AuthorizationPage authorizationPage = new AuthorizationPage();

    //это я докер пыталась запускать
    public static void setup() {
        browser = "chrome"; // Название браузера
        browserVersion = "127.0"; // Укажите версию, если она не default
        remote = "http://localhost:4444/wd/hub"; // Адрес Selenoid
        browserSize = "1920x1080"; // Размер окна
        headless = false; // Если хотите видеть браузер в VNC
    }
}
