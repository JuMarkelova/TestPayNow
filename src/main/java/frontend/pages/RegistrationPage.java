package frontend.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends BasePage {
    private final String REGISTER_URL_PATH = "/register";
    private SelenideElement emailField = $("#email");
    private SelenideElement passwordField = $("#password");
    private SelenideElement confirmPasswordField = $("#confirm-password");
    private SelenideElement nameField = $("#name");
    private SelenideElement numberField = $("#number");
    private SelenideElement pinField = $("#pin");
    private SelenideElement termsCheckbox = $("#terms");
    private SelenideElement registerButton = $("button[type='submit']");

    public void fillRegistrationForm(String email, String password, String name, String number, String pin) {
        emailField.setValue(email);
        passwordField.setValue(password);
        confirmPasswordField.setValue(password);
        nameField.setValue(name);
        numberField.setValue(number);
        pinField.setValue(pin);
    }

    public void putOnFlagAcceptTerms() {
        termsCheckbox.click();
    }

    public void submit() {
        registerButton.click();
    }

    public void open() throws Exception {
        open(REGISTER_URL_PATH);
    }
}
