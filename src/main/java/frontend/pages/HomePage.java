package frontend.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {
    private String homeUrlPath = "/home";
    private SelenideElement homeLabel = $("div").shouldHave(text("Home"));

    public SelenideElement getHomeLabel() {
        return homeLabel;
    }

    public void open() {
        open(homeUrlPath);
    }
}
