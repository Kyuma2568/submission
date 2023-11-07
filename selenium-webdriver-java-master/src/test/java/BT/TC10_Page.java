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
    private final By SubmitBtn = By.cssSelector("input[type='submit']");
    private final By CloseBtn = By.cssSelector("a[title='close'] span");
    private final By NavBar = By.id("nav");
    private final By DBSales = By.linkText("Sales");
    private final By Orders = By.linkText("Orders");
    private final By DBExport = By.id("sales_order_grid_export");
    private final By Export = By.cssSelector("button[title='Export']");



    public void login(String username, String password) {
        driver.findElement(Username).sendKeys(username);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(SubmitBtn).click();
    }
    public void closeMsgBox(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CloseBtn)).click();
    }
    public void goToOrders() {
        driver.findElement(NavBar).findElement(DBSales).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Orders)).click();
    }
    public void exportOrdersToCSV() {
        WebElement exportDropdown = driver.findElement(DBExport);
        Select select = new Select(exportDropdown);
        select.selectByVisibleText("CSV");
        driver.findElement(Export).click();
    }
}

