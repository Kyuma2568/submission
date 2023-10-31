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
    private By mobileMenuSelector = By.linkText("MOBILE");
    private By addToCartSonyXperiaSelector = By.xpath("//h2[a='Sony Xperia']/following-sibling::div//button[@title='Add to Cart']");
    private By qtySelector = By.cssSelector("input[title='Qty']");
    private By updateButtonSelector = By.cssSelector("button[title='Update']");
    private By errorMessageSelector = By.cssSelector(".item-msg.error");
    private By emptyCartLinkSelector = By.linkText("Remove Item");
    private By emptyCartMessageSelector = By.cssSelector("div[class='page-title'] h1");

    // Constructor with required parameter as a WebDriver instance
    public TC03_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with the elements on the page
    public void clickOnMobileMenu() {
        driver.findElement(mobileMenuSelector).click();
    }

    public void addToCartSonyXperia() {
        driver.findElement(addToCartSonyXperiaSelector).click();
    }

    public void changeQty(String qty) {
        WebElement qtyElem = driver.findElement(qtySelector);
        qtyElem.clear();
        // Wait for the input to be cleared
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(qtySelector, "value", ""));
        // Then send the new quantity
        qtyElem.sendKeys(qty);
    }

    public void clickUpdateButton() {
        driver.findElement(updateButtonSelector).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessageSelector).getText();
    }

    public void clickEmptyCartLink() {
        driver.findElement(emptyCartLinkSelector).click();
    }

    public String getEmptyCartMessage() {
        return driver.findElement(emptyCartMessageSelector).getText();
    }
}