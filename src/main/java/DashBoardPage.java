import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class DashBoardPage extends BasePage {

    String QUICK_LAUNCH_OPTIONS_CSS_SELECTOR = "table.quickLaungeContainer  span.quickLinkText";
    String DASHBOARD_PAGE_HEADER_XPATH = "//h1";

    DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getAllQuickLaunchOptions() {
        List<WebElement> optionElements = driver.findElements(By.cssSelector(QUICK_LAUNCH_OPTIONS_CSS_SELECTOR));
        List<String> options = new ArrayList<>();
        for (WebElement e : optionElements) {
            options.add(e.getText().trim());
        }
        return options;
    }

    public String getHeaderName() {
        return driver.findElement(By.xpath(DASHBOARD_PAGE_HEADER_XPATH)).getText().trim();
    }

    public void WaitUntilDashBoardPageTitleIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath(DASHBOARD_PAGE_HEADER_XPATH))));
    }
}
