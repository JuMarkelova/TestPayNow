package frontend.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage {
    public final String HOME_URL_PATH = "/home";
    @Getter
    private SelenideElement homeLabel = $("div").shouldHave(text("Home"));
    private SelenideElement welcomeElement = $x("//h1[contains(text(), 'Welcome back')]");
    private SelenideElement addMoneyButton = $(Selectors.byText("Add Money"));
    private SelenideElement balanceContainer =
            $(".text-4xl.pt-4.font-bold.text-center");
    private SelenideElement walletToGoButton = $x("//div[contains(@class, 'text-black') and .//div[text()='Wallet']]");
    private SelenideElement transferToGoButton = $x("//div[contains(@class, 'text-black') and .//div[text()='Transfer']]");

//    public HomePage() {
//        this.open();
//    }

    public void open() {
        try {
            open(HOME_URL_PATH);
        } catch (Exception ex) {
        }
    }

    public String getNameWelcomeElement() {
        return welcomeElement.getText().replace("Welcome back", "").trim();
    }

    public void clickAddMoneyButton() {
        addMoneyButton.click();
    }

    public void clickWalletToGoButton() {
        walletToGoButton.click();
    }

    public void clickTransferToGoButton() {
        transferToGoButton.click();
    }
}
