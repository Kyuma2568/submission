
package BT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC08_Page {
    private WebDriver driver;

    public TC08_Page(WebDriver driver) {
        this.driver = driver;
    }

    private final By MyAccount = By.linkText("MY ACCOUNT");
    private final By Email = By.cssSelector("#email");
    private final By Pass = By.cssSelector("#pass");
    private final By Login = By.cssSelector("button[id='send2'] span span");
    private final By Reorder = By.linkText("REORDER");
    private final By Qty = By.cssSelector("input[title='Qty']");
    private final By Update = By.cssSelector("button[title='Update']");
    private final By OldGrandTotal = By.cssSelector("strong span[class='price']");
    private final By GrandTotal = By.cssSelector("strong span[class='price']");
    private final By OrderNumber = By.cssSelector("#order_number");

    public void goToHomePage() {
        driver.get("http://live.techpanda.org/");
    }
    public void clickMyAccount() {
        driver.findElement(MyAccount).click();
    }
    public void login(String username, String password) {
        WebElement emailField = driver.findElement(Email);
        WebElement passwordField = driver.findElement(Pass);
        WebElement loginButton = driver.findElement(Login);

        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void clickReorder() {
        driver.findElement(Reorder).click();
    }
    public String getOldGrandTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(OldGrandTotal)).getText();
    }
    public void changeQty(String qty) {
        WebElement qtyField = driver.findElement(Qty);
        qtyField.clear();
        qtyField.sendKeys(qty);
    }

    public void clickUpdate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Update)).click();
    }

    public String getGrandTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(GrandTotal)).getText();
    }

//    public String getOrderNumber() {
//        return driver.findElement(OrderNumber).getText();
//    }

//    public void completeBillingShippingInfo() {
//    }
}