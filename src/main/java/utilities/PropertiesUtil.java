package utilities;


import constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class PropertiesUtil {

    private PropertiesUtil() {
    }

    static Properties prop;

    static {
        try {
            FileInputStream fis = new FileInputStream(FrameworkConstants.getPropertyFilePath());
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValueOfProperty(String key) {
        return prop.getProperty(key);
    }
}