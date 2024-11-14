package frontend.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage {
    private String homeUrlPath = "/home";
    private SelenideElement homeLabel = $("div").shouldHave(text("Home"));
    private SelenideElement welcomeElement = $x("//h1[contains(text(), 'Welcome back')]");

    public SelenideElement getHomeLabel() {
        return homeLabel;
    }

    public String getNameWelcomeElement() {
        return welcomeElement.getText().replace("Welcome back", "").trim();
    }

    public void open() {
        open(homeUrlPath);
    }
}
