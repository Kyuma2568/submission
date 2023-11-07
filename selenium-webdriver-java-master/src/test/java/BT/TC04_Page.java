package BT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TC04_Page {
    private WebDriverWait wait;
    private WebDriver driver;

    // Declare element selector value here
    private By mobileMenu = By.linkText("MOBILE");
    private By DropBox = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > select:nth-child(2)");

    private By addProduct1ToCompare = By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[2]//a[1]");
    private By addProduct2ToCompare = By.xpath("//li[3]//div[1]//div[3]//ul[1]//li[2]//a[1]");
    private By compareButton = By.cssSelector("button[title='Compare'] span span");
    private By popupHeading = By.xpath("//h1[normalize-space()='Compare Products']");
    private By productNames1 = By.cssSelector("h2[class='product-name'] a[title='Sony Xperia']");
    private By productNames2 = By.cssSelector("h2[class='product-name'] a[title='IPhone']");


    // Constructor with required parameter as a WebDriver instance
    public TC04_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with the elements on the page
    public void clickOnMobileMenu() {
        driver.findElement(mobileMenu).click();
    }
    public void SortBy(String Price) {
        Select Dropdown = new Select(driver.findElement(DropBox));
        Dropdown.selectByVisibleText(Price);
    }

    public void addToCompareSonyXperia() {
        driver.findElement(addProduct1ToCompare).click();
    }

    public void addToCompareIphone() {
        driver.findElement(addProduct2ToCompare).click();
    }

    public void clickOnCompareButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(compareButton)).click();
        for (String x : driver.getWindowHandles()){
            driver.switchTo().window(x);
        }
    }

    public String getPopupHeading() {
        return driver.findElement(popupHeading).getText();
    }
    public String getProductNames1() {
        return driver.findElement(productNames1).getText();
    }
    public String getProductNames2() {
        return driver.findElement(productNames2).getText();
    }

}