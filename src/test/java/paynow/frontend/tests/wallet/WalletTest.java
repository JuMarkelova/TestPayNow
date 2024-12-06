package paynow.frontend.tests.wallet;

import frontend.entity.CardType;
import frontend.pages.HomePage;
import frontend.pages.WalletPage;
import org.junit.jupiter.api.Test;
import paynow.frontend.tests.BaseTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class WalletTest extends BaseTest {
    WalletPage walletPage;

    @Test
    public void addMoneyToWallet() throws Exception {
        //вытащить в beforeAll авторизацию? может быть добавить в baseTest и исключить проверки регистрации
        //сделала, вытащила метод auth()
//        HomePage homePage = new HomePage();
        //открыть wallet page сразу, а проверку перехода по кнопке унести в home page
        //сделала
        homePage.clickWalletToGoButton();
        walletPage = new WalletPage();
//                walletPage.open();
        int balanceBeforeAddingMoney = walletPage.getAccountBalance();
        walletPage.clickAddMoneyButton();
        int amountMoneyToAdd = 5000;
        walletPage.fillCardDetails("Name",
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
