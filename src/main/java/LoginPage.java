import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    String LOGIN_PAGE_URL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    String CREDENTIALS_TEXT_XPATH = "//span[text()='( Username : Admin | Password : admin123 )']";
    String INPUT_FIELD_CSS_SELECTOR = "input[name='txtUsername']";
    String PASSWORD_FIELD_CSS_SELECTOR = "input[name='txtPassword']";
    String LOGIN_BUTTON_CSS_SELECTOR = "input[type='submit']";
    String FORGOT_PASSOWORD_LINK_TEXT = "Forgot your password?";

    LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToOrangeLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    private String getCredentialsFromCredentialText() {
        return driver.findElement(By.xpath(CREDENTIALS_TEXT_XPATH)).getText().trim();
    }

    public String getUserName() {
        return getCredentialsFromCredentialText().split("\\|")[0].split(":")[1].trim();
    }

    public String getPassword() {
        return getCredentialsFromCredentialText().split("\\|")[1].split(":")[1].substring(0, 9).trim();
    }

    public void enterUserName(String userName) {
        driver.findElement(By.cssSelector(INPUT_FIELD_CSS_SELECTOR)).sendKeys(userName);
    }

    public void enterPassword(String password) {
        driver.findElement(By.cssSelector(PASSWORD_FIELD_CSS_SELECTOR)).sendKeys(password);
    }

    public DashBoardPage clickLogin() {
        driver.findElement(By.cssSelector(LOGIN_BUTTON_CSS_SELECTOR)).click();
        return new DashBoardPage(driver);
    }

    public void clickForgetPassword() {
        driver.findElement(By.linkText(FORGOT_PASSOWORD_LINK_TEXT)).click();
    }
}