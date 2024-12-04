package frontend.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class TransferPage extends BasePage {
    //сделать паблик и убрать прайват?
    //сделала все переменные пути паблик, убрала геттеры к ним
    public final String TRANSFER_URL_PATH = "/transfer";
    @Getter
    private SelenideElement transferTitle =
            $x("//div[@class='visible w-max pl-1 pt-1 sm:text-2xl' and text()='Transfer']");
}
