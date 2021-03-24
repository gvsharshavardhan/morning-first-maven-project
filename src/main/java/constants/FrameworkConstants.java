package constants;

public final class FrameworkConstants {

    private FrameworkConstants() {

    }

    private static final String PROPERTYFILEPATH = System.getProperty("user.dir") + "/src/main/resources/configProps.properties";

    public static String getPropertyFilePath() {
        return PROPERTYFILEPATH;
    }
}
