package paynow.frontend.tests;

import frontend.pages.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

public class HomeTest extends BaseTest {

    @Test
    public void goToWalletPage() throws Exception {
        authorizationPage.open();
        authorizationPage.fillAuthForm("warner.vandervort@hotmail.com", "sh08vf0z08ef1o");
        authorizationPage.putOnFlagAcceptTerms();
        authorizationPage.submit();
        HomePage homePage = new HomePage();
        homePage.clickWalletToGoButton();
        WalletPage walletPage = new WalletPage();
//какая-то существует для проверки (через базовую страницу) всех жлементов присутствующих на странице
        assertThat(walletPage.getWalletTitle().exists())
                .isTrue();
        assertThat(url())
                .as("Wrong url")
                .isEqualTo(homePage.baseUrl + walletPage.WALLET_URL_PATH);
    }

    @Test
    public void goToTransferPage() throws Exception {
        authorizationPage.open();
        authorizationPage.fillAuthForm("warner.vandervort@hotmail.com", "sh08vf0z08ef1o");
        authorizationPage.putOnFlagAcceptTerms();
        authorizationPage.submit();
        HomePage homePage = new HomePage();
        homePage.clickTransferToGoButton();
        TransferPage transferPage = new TransferPage();
        assertThat(transferPage.getTransferTitle().exists())
                .isTrue();
        assertThat(url())
                .as("Wrong url")
                .isEqualTo(homePage.baseUrl + transferPage.TRANSFER_URL_PATH);
    }
}
