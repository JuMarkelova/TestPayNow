package paynow.frontend.tests.wallet;

import frontend.entity.CardType;
import frontend.pages.HomePage;
import frontend.pages.WalletPage;
import org.junit.jupiter.api.Test;
import paynow.frontend.tests.BaseTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class WalletTest extends BaseTest {

    @Test
    public void addMoneyToWallet() throws Exception {
//        User user = homePage.register().getUser();
        authorizationPage.open();
//        authorizationPage.fillAuthForm(user.getEmail, user.getPassword);
        //вытащить в beforeAll авторизацию? может быть добавить в baseTest и исключить проверки регистрации
        authorizationPage.fillAuthForm("warner.vandervort@hotmail.com", "sh08vf0z08ef1o");
        authorizationPage.putOnFlagAcceptTerms();
        authorizationPage.submit();
        HomePage homePage = new HomePage();
        //открыть wallet page сразу, а проверку перехода по кнопкке унести в home page
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
                LocalDate.of(2024, 12, 31),
                "432",
                CardType.VISA,
                amountMoneyToAdd
        );
        walletPage.clickPayButton();
        walletPage.getWalletTitle().click();
        assertThat(walletPage.getAccountBalance())
                .as("Wrong balance after adding money")
                .isEqualTo(balanceBeforeAddingMoney + amountMoneyToAdd);
    }
}
