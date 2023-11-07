package BT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class TC03_Page {
    private WebDriver driver;

    // Declare element selector value here
    private By mobileMenu = By.linkText("MOBILE");
    private By addToCartSonyXperia = By.xpath("//h2[a='Sony Xperia']/following-sibling::div//button[@title='Add to Cart']");
    private By qty = By.cssSelector("input[title='Qty']");
    private By updateButton = By.cssSelector("button[title='Update']");
    private By errorMessage = By.cssSelector("li[class='error-msg'] ul li span");
    private By emptyCartLink = By.linkText("Remove Item");
    private By emptyCartMessage = By.cssSelector("div[class='page-title'] h1");

    // Constructor with required parameter as a WebDriver instance
    public TC03_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with the elements on the page
    public void clickOnMobileMenu() {
        driver.findElement(mobileMenu).click();
    }

    public void addToCartSonyXperia() {
        driver.findElement(addToCartSonyXperia).click();
    }

    public void changeQty(String qty) {
        WebElement qtyElem = driver.findElement(this.qty);
        qtyElem.clear();
        // Wait for the input to be cleared
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(this.qty, "value", ""));
        // Then send the new quantity
        qtyElem.sendKeys(qty);
    }

    public void clickUpdateButton() {
        driver.findElement(updateButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void clickEmptyCartLink() {
        driver.findElement(emptyCartLink).click();
    }

    public String getEmptyCartMessage() {
        return driver.findElement(emptyCartMessage).getText();
    }
}