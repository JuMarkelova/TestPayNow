package frontend.util;

import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {

    public static String phoneNumberGenerator() {
        long phoneNumber = ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L);
        return String.valueOf(phoneNumber);
    }
}
