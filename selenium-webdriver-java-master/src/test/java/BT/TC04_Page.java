package BT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TC04_Page {
    private WebDriver driver;

    // Declare element selector value here
    private By mobileMenuSelector = By.linkText("MOBILE");
    private By addToCompareSonyXperiaSelector = By.xpath("//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]");
    private By addToCompareIphoneSelector = By.xpath("//li[3]//div[1]//div[3]//ul[1]//li[2]//a[1]");
    private By compareButtonSelector = By.cssSelector("button[title='Compare'] span span");
    private By popupHeadingSelector = By.xpath("//h1[normalize-space()='Compare Products']");
    private By productNamesSelector1 = By.cssSelector("h2[class='product-name'] a[title='Sony Xperia']");
    private By productNamesSelector2 = By.cssSelector("h2[class='product-name'] a[title='IPhone']");


    // Constructor with required parameter as a WebDriver instance
    public TC04_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with the elements on the page
    public void clickOnMobileMenu() {
        driver.findElement(mobileMenuSelector).click();
    }

    public void addToCompareSonyXperia() {
        driver.findElement(addToCompareSonyXperiaSelector).click();
    }

    public void addToCompareIphone() {
        driver.findElement(addToCompareIphoneSelector).click();
    }

    public void clickOnCompareButton() {
        driver.findElement(compareButtonSelector).click();
        for (String x : driver.getWindowHandles()){
            driver.switchTo().window(x);
        }
    }

    public String getPopupHeading() {
        return driver.findElement(popupHeadingSelector).getText();
    }
    public String getProductNames1() {
        return driver.findElement(productNamesSelector1).getText();
    }
    public String getProductNames2() {
        return driver.findElement(productNamesSelector2).getText();
    }

}