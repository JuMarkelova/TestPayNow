package paynow.frontend.tests;

import frontend.pages.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

public class HomeTest extends BaseTest {
    WalletPage walletPage;

    @Test
    public void goToWalletPage() throws Exception {
        homePage.clickWalletToGoButton();
        walletPage = new WalletPage();
//        WalletPage walletPage = new WalletPage();
        //какая-то существует для проверки (через базовую страницу) всех элементов присутствующих на странице
        // не разбиралась
        assertThat(walletPage.getWalletTitle().exists())
                .isTrue();
        assertThat(url())
                .as("Wrong url")
                .isEqualTo(homePage.baseUrl + walletPage.WALLET_URL_PATH);
    }

    @Test
    public void goToWalletPageViaAddMoneyButton() throws Exception {
        homePage.clickAddMoneyButton();
        WalletPage walletPage = new WalletPage();
        assertThat(walletPage.getWalletTitle().exists())
                .isTrue();
        assertThat(url())
                .as("Wrong url")
                .isEqualTo(homePage.baseUrl + walletPage.WALLET_URL_PATH);
    }

    @Test
    public void goToTransferPage() throws Exception {
        homePage.clickTransferToGoButton();
        TransferPage transferPage = new TransferPage();
        assertThat(url())
                .as("Wrong url")
                .isEqualTo(homePage.baseUrl + transferPage.TRANSFER_URL_PATH);
        assertThat(transferPage.getTransferTitle().exists())
                .isTrue();
    }
}
