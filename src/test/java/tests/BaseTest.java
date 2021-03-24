package tests;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    public SoftAssert sa = new SoftAssert();

    @BeforeMethod
    public void openBrowser() {
        DriverFactory.initializeDriver();
    }

    @AfterMethod
    public void quitBrowser() {
        DriverFactory.quitDriver();
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
