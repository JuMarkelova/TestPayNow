package paynow.backend.tests;

import common.util.PropertiesUtil;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = PropertiesUtil.getProperty("api.base.url");
    }
}
