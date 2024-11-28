package frontend.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TransferPage extends BasePage{
    //сделать паблик и убрать прайват?
    private final String TRANSFER_URL_PATH = "/transfer";
    private SelenideElement transferTitle =
            $x("//div[@class='visible w-max pl-1 pt-1 sm:text-2xl' and text()='Transfer']");

    public String getTRANSFER_URL_PATH() {
        return TRANSFER_URL_PATH;
    }

    public SelenideElement getTransferTitle() {
        return transferTitle;
    }
}
