package BT;

import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.time.Duration;

public class TC10_Page {
    private WebDriver driver;
    private WebDriverWait wait;

    public TC10_Page(WebDriver driver) {
        this.driver = driver;
    }

    private final By Username = By.id("username");
    private final By Password = By.id("login");
    private final By OrderId = By.xpath("//*[@id='sales_order_grid_filter_real_order_id']");
    private final By Fromdate = By.xpath("//*[@name='created_at[from]']");
    private final By Todate = By.xpath("//*[@name='created_at[to]']");
    private final By SubmitBtn = By.cssSelector("input[type='submit']");
    private final By CloseBtn = By.cssSelector("a[title='close'] span");
    private final By NavBar = By.id("nav");
    private final By DBSales = By.linkText("Sales");
    private final By Orders = By.linkText("Orders");

    public void login(String username, String password) {
        driver.findElement(Username).sendKeys(username);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(SubmitBtn).click();
    }

    public void closeMsgBox() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CloseBtn)).click();
    }

    public void goToOrders() {
        driver.findElement(NavBar).findElement(DBSales).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Orders)).click();
    }
    public void Search(String id, String from, String to) {
        driver.findElement(OrderId).sendKeys(id);
        driver.findElement(Fromdate).sendKeys(from);
        driver.findElement(Todate).sendKeys(to);
    }
}

