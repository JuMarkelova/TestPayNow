package frontend.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage extends BasePage {
    String authorizationUrlPath = "/";
    SelenideElement emailField = $("#email");
    SelenideElement passwordField = $("#password");
    SelenideElement termsCheckbox = $("#remember");
    SelenideElement loginButton = $("button[type='submit']");

    public String[] open() throws Exception {
        return openRegistered(authorizationUrlPath);
    }

//    Сделать private если не используется нигде
    public void putOnFlagAcceptTerms() {
        termsCheckbox.click();
    }

    public void submit() {
        loginButton.click();
    }

// Не должно быть зависимостей от другий пейджей
    public HomePage fillAuthFormAndAuth(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
        putOnFlagAcceptTerms();
        submit();
        return new HomePage(); // Тоже подумать стоит ли возвращать эксземпляр или все таки создавать его в тесте
    }
}