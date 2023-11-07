package BT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC09_Page {
    private WebDriver driver;
    public TC09_Page(WebDriver driver) {
        this.driver = driver;
    }
    private final By mobileMenu = By.linkText("MOBILE");
    private final By addToCartIphone = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(2) > div:nth-child(4) > button:nth-child(1)");
    private final By couponCodeInput = By.cssSelector("input[name='coupon_code']");
    private final By applyCouponButton = By.cssSelector("button[value='Apply']");
    private final By totalPrice = By.cssSelector("strong span[class='price']");



    // Step 2: Navigate to the 'Mobile' section
    public void clickOnMobileMenu() {
        driver.findElement(mobileMenu).click();
    }

    // Step 3: Add 'IPHONE' to cart
    public void addToCartIphone() {
        driver.findElement(addToCartIphone).click();
    }

    // Step 4: Enter the coupon code
    public void enterCouponCode(String code) {
        driver.findElement(couponCodeInput).sendKeys(code);
    }

    public void clickApplyCouponButton() {
        driver.findElement(applyCouponButton).click();
    }

    // Step 5: Verify the discount
    // Convert price string to a number and calculate expected discount
    public double Price() {
        return Double.parseDouble(driver.findElement(totalPrice).getText().replace("$", ""));
    }

    public double DiscountedPrice() {
        return Price() * 0.95;
    }
}