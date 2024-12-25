package common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = PropertiesUtil.class.getClassLoader().getResourceAsStream("test.properties")) {
            if (input == null) {
                throw new IllegalArgumentException("File not found");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load file", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
