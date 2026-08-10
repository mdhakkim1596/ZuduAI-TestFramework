package ai.zudu.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {

        String env = System.getProperty("env", "dev");
        String fileName = "config/" + env + ".properties";

        try {
            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName);
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
