package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

/*
final:
-------
class -> cannot inherit
method -> cannot override
members -> cannot modify
 */

public final class DriverFactory {
    static WebDriver driver;
    static ThreadLocal<WebDriver> tl = new ThreadLocal();

    private DriverFactory() {

    }

    public static void initializeDriver() {
        if (Objects.isNull(getDriver())) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            setDriver(driver);
            getDriver().manage().window().maximize();
        }
    }

    public static void quitDriver() {
        getDriver().quit();
        tl.remove();
    }


    private static void setDriver(WebDriver driver) {
        tl.set(driver);
    }

    public static WebDriver getDriver() {
        return tl.get();
    }
}