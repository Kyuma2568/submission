package BT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC06_LoginPage {
    WebElement Elem;
    WebDriverWait wait;
    private WebDriver driver;
    public TC06_LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By myAccountLink = By.linkText("MY ACCOUNT");
    private By emailAddressBox = By.cssSelector("#email");
    private By passwordBox = By.cssSelector("#pass");
    private By loginButton = By.cssSelector("button[id='send2'] span span");


    public void clickOnMyAccountLink() {
        driver.findElement(myAccountLink).click();
    }

    public void login(String emailAddress, String password) {
        Elem = driver.findElement(emailAddressBox);
        Elem.clear();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(emailAddressBox, "value", ""));
        Elem.sendKeys(emailAddress);

        Elem = driver.findElement(passwordBox);
        Elem.clear();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(passwordBox, "value", ""));
        Elem.sendKeys(password);

        driver.findElement(loginButton).click();
    }


}
