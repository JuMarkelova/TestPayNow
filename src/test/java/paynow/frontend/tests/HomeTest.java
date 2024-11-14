package paynow.frontend.tests;

import com.codeborne.selenide.Selenide;
import frontend.pages.HomePage;
import org.junit.jupiter.api.Test;

public class HomeTest {
    private HomePage homePage = new HomePage();



    @Test
    public void test() throws Exception {
        homePage.open();
        Selenide.sleep(5000);
    }
}
