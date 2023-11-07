package BT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC07_Page {
    private WebDriver driver;

    public TC07_Page(WebDriver driver) {
        this.driver = driver;
    }
    private final By MyAccount = By.linkText("MY ACCOUNT");
    private final By Email = By.cssSelector("#email");
    private final By Pass = By.cssSelector("#pass");
    private final By Login = By.cssSelector("button[id='send2'] span span");

    private final By MyOrder = By.linkText("MY ORDERS");
    private final By ViewOrder = By.xpath("//tr[@class='first odd']//a[contains(text(),'View Order')]");
    private final By PrintOrder = By.linkText("Print Order");
//    private final By Destination = By.xpath("");
//    private final By SaveBtn = By.xpath("");


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

    public void clickMyOrders() {
        driver.findElement(MyOrder).click();
    }

    public void clickViewOrder() {
        driver.findElement(ViewOrder).click();

    }

    public void clickPrintOrder() {
        driver.findElement(PrintOrder).click();
            for (String x : driver.getWindowHandles()){
                driver.switchTo().window(x);
        }
    }

//    public void clickSavePDF(){
//        driver.findElement(Destination).click();
//    }
}