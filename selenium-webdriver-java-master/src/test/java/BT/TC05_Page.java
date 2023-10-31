package BT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC05_Page {
    WebElement Elem = null;
    WebDriverWait wait = null;
    private WebDriver driver;

    // Declare element selector value here
    private By myAccountLinkSelector = By.linkText("MY ACCOUNT");
    private By createAnAccountLinkSelector = By.linkText("CREATE AN ACCOUNT");

    private By fisrtNameBox = By.cssSelector("#firstname");
    private By middleNameBox = By.cssSelector("#middlename");
    private By lastNameBox = By.cssSelector("#lastname");
    private By emailAddressBox = By.cssSelector("#email_address");
    private By passwordBox = By.cssSelector("#password");
    private By confirmPasswordBox = By.cssSelector("#confirmation");
    private By registerButtonSelector = By.cssSelector("button[title='Register']");
    private By registrationMessageSelector = By.cssSelector("li[class='success-msg'] ul li span");
    private By tvMenuSelector = By.linkText("TV");
    private By addToWishlistLgLcdSelector = By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]");
    private By shareWishlistButtonSelector = By.cssSelector("button[title='Share Wishlist']");
    private By ShareEmailAddressBox = By.cssSelector("#email_address");
    private By ShareMsgBox = By.cssSelector("#message");

    private By sharedWishlistMessageSelector = By.cssSelector("li[class='success-msg'] ul li span");

    // Constructor with required parameter as a WebDriver instance
    public TC05_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with the elements on the page
    public void clickOnMyAccountLink() {
        driver.findElement(myAccountLinkSelector).click();
    }

    public void clickCreateAnAccountLink() {
        driver.findElement(createAnAccountLinkSelector).click();
    }

    public void fillNewUserInfo(String fisrtName, String middleName, String lastName, String emailAddress, String password, String confirmPassword) {
        Elem = driver.findElement(fisrtNameBox);
        Elem.clear();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(fisrtNameBox, "value", ""));
        Elem.sendKeys(fisrtName);

        Elem = driver.findElement(middleNameBox);
        Elem.clear();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(middleNameBox, "value", ""));
        Elem.sendKeys(middleName);

        Elem = driver.findElement(lastNameBox);
        Elem.clear();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(lastNameBox, "value", ""));
        Elem.sendKeys(lastName);

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

        Elem = driver.findElement(confirmPasswordBox);
        Elem.clear();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(confirmPasswordBox, "value", ""));
        Elem.sendKeys(confirmPassword);

    }

    public void clickRegister() {
        driver.findElement(registerButtonSelector).click();
    }

    public String getRegistrationMessage() {
        return driver.findElement(registrationMessageSelector).getText();
    }

    public void goToTvMenu() {
        driver.findElement(tvMenuSelector).click();
    }

    public void addToWishlistLgLcd() {
        driver.findElement(addToWishlistLgLcdSelector).click();
    }

    public void clickShareWishlist() {
        driver.findElement(shareWishlistButtonSelector).click();
    }

    public void enterEmailAndMessage(String email, String ShareMsg) {
        Elem = driver.findElement(ShareEmailAddressBox);
        Elem.clear();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(ShareEmailAddressBox, "value", ""));
        Elem.sendKeys(email);

        Elem = driver.findElement(ShareMsgBox);
        Elem.clear();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(ShareMsgBox, "value", ""));
        Elem.sendKeys(ShareMsg);
    }

    public String getSharedWishlistMessage() {
        return driver.findElement(sharedWishlistMessageSelector).getText();
    }
}
