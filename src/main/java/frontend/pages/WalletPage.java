package frontend.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import frontend.entity.CardType;
import lombok.Getter;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class WalletPage {
    //нужно ли единообразие xpath, css
    // я не нашла информации о том, чтобы использовать что-то одно на проекте, наверное, зависит от компании
    public final String WALLET_URL_PATH = "/wallet";
    @Getter
    private SelenideElement walletTitle = $(".pl-5.text-4xl.font-bold").shouldHave(Condition.text("Wallet"));
    private SelenideElement balanceContainer =
            $(".h-32.text-6xl.font-bold.text-center.flex.flex-col.items-center.justify-center.overflow-auto div");
    private SelenideElement addMoneyButton = $x("//div[text()='Add Money']");
    private SelenideElement inputNameField = $("[name='name']");
    private SelenideElement inputCardNumberField = $("[name='card_number']");
    private SelenideElement inputExpDateField = $("[name='exp_date']");
    private SelenideElement inputCvvField = $("[name='cvv']");
    private SelenideElement inputCardTypeField = $("[name='card_type']");
    private SelenideElement inputAmountField = $("[name='amount']");
    //сделать енамом типы карт
// убрала переменные, перенесла в енам
    private SelenideElement payButton = $x("//button[@type='submit' and text()='Pay']");

    public void clickAddMoneyButton() {
        addMoneyButton.click();
    }

    public int getAccountBalance() {
        String balanceText = balanceContainer.getText();
        String numericBalance = balanceText.replaceAll("[^0-9]", "");
        return Integer.parseInt(numericBalance);
    }

    //здесь наверное бы енам что ли добавить в карттайп, но пока так
    //добавила енам с типами карт
    //сделать дату датой?
// сделала дату с типом LocalDate
    public void fillCardDetails(String name,
                                String cardNumber,
                                LocalDate expirationDate,
                                String cvv,
                                CardType cardType,
                                int amount) {
        inputNameField.setValue(name);
        inputCardNumberField.setValue(cardNumber);
        inputExpDateField.setValue(String.valueOf(expirationDate));
        inputCvvField.setValue(cvv);
        inputCardTypeField.selectOption(cardType.getDisplayName());
        inputAmountField.setValue(String.valueOf(amount));
    }

    public void clickPayButton() {
        payButton.click();
    }
}
