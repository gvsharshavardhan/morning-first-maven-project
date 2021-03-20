import org.testng.annotations.Test;

import java.util.List;

public class LoginPageTest extends BaseTest {

    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    String expectedDashboardpageTitle = "Dashboard";
    List<String> expectedQuickLauchOptions = List.of("Assign Leave"
            , "Leave List", "Timesheets", "Apply Leave", "My Leave", "My Timesheet");

    @Test
    public void validLoginTest() {
        loginPage = new LoginPage(driver);
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