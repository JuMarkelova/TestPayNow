package frontend.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage extends BasePage {
    // Юля: начиталась, что в конструкторе никакой логики быть не должно
    //только можено параметрами передать значения переменных экземпляра, поэтому не делаем так

//    Подумать может лучше регистрировать в конструкторе?
//    public AuthorizationPage(boolean shouldRegister) {
//     if (shouldRegister) {
//         register(); // подумать как возвращать таким образом данные зареганного юзера
//     }
//    }

    String authorizationUrlPath = "/";
    SelenideElement emailField = $("#email");
    SelenideElement passwordField = $("#password");
    SelenideElement termsCheckbox = $("#remember");
    SelenideElement loginButton = $("button[type='submit']");

    public void open() throws Exception {
//юля: тем не менее отсюда register() вынесла для ясности, создаю юезра в тестах

//        Если регаем в конструкторе, то это здесь не нужно
//        register();
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