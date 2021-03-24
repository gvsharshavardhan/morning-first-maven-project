package tests;

import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;

import java.util.List;

public class LoginPageTest extends BaseTest {

    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    String expectedDashboardpageTitle = "Dashboard";
    List<String> expectedQuickLauchOptions = List.of("Assign Leave"
            , "Leave List", "Timesheets", "Apply Leave", "My Leave", "My Timesheet");

    @Test
    public void validLoginTest111() {
        loginPage = new LoginPage();
        loginPage.goToOrangeLoginPage();
        String uname = loginPage.getUserName();
        String pword = loginPage.getPassword();
        loginPage.enterUserName(uname);
        loginPage.enterPassword(pword);
        dashBoardPage = loginPage.clickLogin();
        sa.assertEquals(dashBoardPage.getHeaderName(),
                expectedDashboardpageTitle);
        sa.assertEquals(dashBoardPage.getAllQuickLaunchOptions()
                , expectedQuickLauchOptions);
        sa.assertAll();
    }

    @Test
    public void validLoginTest222() {
        loginPage = new LoginPage();
        loginPage.goToOrangeLoginPage();
        String uname = loginPage.getUserName();
        String pword = loginPage.getPassword();
        loginPage.enterUserName(uname);
        loginPage.enterPassword(pword);
        dashBoardPage = loginPage.clickLogin();
        sa.assertEquals(dashBoardPage.getHeaderName(),
                expectedDashboardpageTitle);
        sa.assertEquals(dashBoardPage.getAllQuickLaunchOptions()
                , expectedQuickLauchOptions);
        sa.assertAll();
    }
}