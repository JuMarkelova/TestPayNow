package frontend.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage extends BasePage {
    String authorizationUrlPath = "/";
    SelenideElement emailField = $("#email");
    SelenideElement passwordField = $("#password");
    SelenideElement termsCheckbox = $("#remember");
    SelenideElement loginButton = $("button[type='submit']");

    public void open() throws Exception {
        open(authorizationUrlPath);
    }

    public void putOnFlagAcceptTerms() {
        termsCheckbox.click();
    }

    public void submit() {
        loginButton.click();
    }

    public void fillAuthForm(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
    }
}