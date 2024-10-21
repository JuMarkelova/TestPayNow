package frontend.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    private SelenideElement emailField = $("#email");
    private SelenideElement passwordField = $("#password");
    private SelenideElement confirmPasswordField = $("#confirm-password");
    private SelenideElement nameField = $("#name");
    private SelenideElement numberField = $("#number");
    private SelenideElement pinField = $("#pin");
    private SelenideElement termsCheck = $("#terms");
    private SelenideElement registerButton = $("button[type='submit']");

    public void open() {
        com.codeborne.selenide.Selenide.open("register");
    }

    public void fillRegistrationForm(String email, String password, String name, String number, int pin) {
        emailField.setValue(email);
        passwordField.setValue(password);
        confirmPasswordField.setValue(password);
        nameField.setValue(name);
        numberField.setValue(number);
        pinField.setValue(String.valueOf(pin));
    }

    public void putOnFlagAcceptTerms() {
        termsCheck.click();
    }

    public void submit() {
        registerButton.click();
    }
}
