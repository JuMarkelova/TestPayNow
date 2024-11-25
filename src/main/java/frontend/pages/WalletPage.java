package frontend.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class WalletPage {
    private final String WALLET_URL_PATH = "/wallet";
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
    private final String OPTION_CARD_TYPE_VISA = "Visa";
    private final String OPTION_CARD_TYPE_RU_PAY = "RuPay";
    private final String OPTION_CARD_TYPE_MASTERCARD = "MasterCard";
    private SelenideElement payButton = $x("//button[@type='submit' and text()='Pay']");

    public String getWALLET_URL_PATH() {
        return WALLET_URL_PATH;
    }

    public String getOPTION_CARD_TYPE_VISA() {
        return OPTION_CARD_TYPE_VISA;
    }

    public String getOPTION_CARD_TYPE_RU_PAY() {
        return OPTION_CARD_TYPE_RU_PAY;
    }

    public String getOPTION_CARD_TYPE_MASTERCARD() {
        return OPTION_CARD_TYPE_MASTERCARD;
    }

    public SelenideElement getWalletTitle() {
        return walletTitle;
    }

    public void clickAddMoneyButton() {
        addMoneyButton.click();
    }

    public int getAccountBalance() {
        String balanceText = balanceContainer.getText();
        String numericBalance = balanceText.replaceAll("[^0-9]", "");
        return Integer.parseInt(numericBalance);
    }

    //здесь наверное бы енам что ли добавить в карттайп, но пока так
    public void fillCardDetails(String name, String cardNumber, String expDate, String cvv, String cardType, int amount) {
        inputNameField.setValue(name);
        inputCardNumberField.setValue(cardNumber);
        inputExpDateField.setValue(expDate);
        inputCvvField.setValue(cvv);
        inputCardTypeField.selectOption(cardType);
        inputAmountField.setValue(String.valueOf(amount));
    }

    public void clickPayButton() {
        payButton.click();
    }
}
