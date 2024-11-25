package paynow.frontend.tests.wallet;

import frontend.pages.HomePage;
import frontend.pages.WalletPage;
import org.junit.jupiter.api.Test;
import paynow.frontend.tests.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class WalletTest extends BaseTest {

    @Test
    public void addMoneyToWallet() throws Exception {
//        User user = homePage.register().getUser();
        authorizationPage.open();
//        authorizationPage.fillAuthForm(user.getEmail, user.getPassword);
        authorizationPage.fillAuthForm("warner.vandervort@hotmail.com", "sh08vf0z08ef1o");
        authorizationPage.putOnFlagAcceptTerms();
        authorizationPage.submit();
        HomePage homePage = new HomePage();
        assertThat(homePage.getHomeLabel().exists())
                .as("There is no Home Element")
                .isTrue();
        int balanceBeforeAddingMoney = homePage.getAccountBalance();
        homePage.clickAddMoneyButton();
        WalletPage walletPage = new WalletPage();
        assertThat(walletPage.getWalletTitle().exists())
                .as("There is no Wallet Title")
                .isTrue();
        assertThat(walletPage.getAccountBalance())
                .isEqualTo(balanceBeforeAddingMoney);
        walletPage.clickAddMoneyButton();
        int amountMoneyToAdd = 5000;
        walletPage.fillCardDetails("LALALA",
                "929292929292",
                "12122024",
                "432",
                walletPage.getOPTION_CARD_TYPE_VISA(),
                amountMoneyToAdd
        );
        walletPage.clickPayButton();
        walletPage.getWalletTitle().click();
        assertThat(walletPage.getAccountBalance())
                .as("Wrong balance after adding money")
                .isEqualTo(balanceBeforeAddingMoney + amountMoneyToAdd);
    }
}
