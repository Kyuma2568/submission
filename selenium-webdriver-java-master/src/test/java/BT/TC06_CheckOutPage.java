package BT;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TC06_CheckOutPage {
    WebElement Elem;
    Select Dropdown;
    private WebDriver driver;
    public TC06_CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By proceedToCheckout = By.cssSelector("li[class='method-checkout-cart-methods-onepage-bottom'] button[title='Proceed to Checkout'] span span");
    private final By newBillingAddressBox = By.id("billing-address-select");
    private final By newShippingAddressBox = By.id("shipping-address-select");
    private final By BfisrtNameBox = By.id("billing:firstname");
    private final By BmiddleNameBox = By.id("billing:middlename");
    private final By BlastNameBox = By.id("billing:lastname");
    private final By BcompanyBox = By.id("billing:company");
    private final By BaddressBox = By.id("billing:street1");
    private final By BstreetAddress2Box = By.id("billing:street2");
    private final By BcityBox = By.id("billing:city");
    private final By BstateBox = By.id("billing:region_id");
    private final By BzipBox = By.id("billing:postcode");
    private final By BcountryBox = By.id("billing:country_id");
    private final By BtelephoneBox = By.id("billing:telephone");
    private final By BfaxBox = By.id("billing:fax");
    private final By SfisrtNameBox = By.id("shipping:firstname");
    private final By SmiddleNameBox = By.id("shipping:middlename");
    private final By SlastNameBox = By.id("shipping:lastname");
    private final By ScompanyBox = By.id("shipping:company");
    private final By SaddressBox = By.id("shipping:street1");
    private final By SstreetAddress2Box = By.id("shipping:street2");
    private final By ScityBox = By.id("shipping:city");
    private final By SstateBox = By.id("shipping:region_id");
    private final By SzipBox = By.id("shipping:postcode");
    private final By ScountryBox = By.id("shipping:country_id");
    private final By StelephoneBox = By.id("shipping:telephone");
    private final By SfaxBox = By.id("shipping:fax");
    private final By ShipToDifAddress = By.cssSelector("label[for='billing:use_for_shipping_no']");
    private final By ContinueBiling = By.cssSelector("button[onclick='billing.save()']");
    private final By ContinueShipping = By.cssSelector("button[onclick='shipping.save()'] span span");
    private final By ContinueShippingMethod = By.xpath("//button[@onclick='shippingMethod.save()']");
    private final By ChkMo = By.xpath("//label[@for='p_method_checkmo']");
    private final By ContinuePayment = By.cssSelector("button[onclick='payment.save()'] span span");
    private final By PlaceOrder = By.xpath("//button[@title='Place Order']");
    private final By OrderRecievedMessage = By.cssSelector(".sub-title");
    private final By orderNumberMessage = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > p:nth-child(3)");


    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckout).click();
    }

    public void enterBillingInformation(String newAddress, String fisrtName, String middleName, String lastName,
                                        String company, String address, String streetAddress2, String city,
                                        String state, String zip, String country, String telephone, String fax) {
        try {
            WebElement element = driver.findElement(newBillingAddressBox);
            if (element.isDisplayed()) {
                Dropdown = new Select(element);
                Dropdown.selectByVisibleText(newAddress);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found. Skipping this step.");
        }


        Elem = driver.findElement(BfisrtNameBox);
        Elem.clear();
        Elem.sendKeys(fisrtName);

        Elem = driver.findElement(BmiddleNameBox);
        Elem.clear();
        Elem.sendKeys(middleName);

        Elem = driver.findElement(BlastNameBox);
        Elem.clear();
        Elem.sendKeys(lastName);

        Elem = driver.findElement(BcompanyBox);
        Elem.clear();
        Elem.sendKeys(company);

        Elem = driver.findElement(BaddressBox);
        Elem.clear();
        Elem.sendKeys(address);

        Elem = driver.findElement(BstreetAddress2Box);
        Elem.clear();
        Elem.sendKeys(streetAddress2);

        Elem = driver.findElement(BcityBox);
        Elem.clear();
        Elem.sendKeys(city);

        Dropdown = new Select(driver.findElement(BstateBox));
        Dropdown.selectByVisibleText(state);

        Elem = driver.findElement(BzipBox);
        Elem.clear();
        Elem.sendKeys(zip);

        Dropdown = new Select(driver.findElement(BcountryBox));
        Dropdown.selectByVisibleText(country);


        Elem = driver.findElement(BtelephoneBox);
        Elem.clear();
        Elem.sendKeys(telephone);

        Elem = driver.findElement(BfaxBox);
        Elem.clear();
        Elem.sendKeys(fax);

        driver.findElement(ShipToDifAddress).click();
        driver.findElement(ContinueBiling).click();
    }
        public void enterShippingInformation(String fisrtName, String middleName, String lastName,
                                         String company, String address, String streetAddress2, String city,
                                         String state, String zip, String country, String telephone, String fax) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            try {
                if (driver.findElements(newShippingAddressBox).size() > 0) {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(newShippingAddressBox));
                    Dropdown = new Select(driver.findElement(newShippingAddressBox));
                    int DropdownSize = Dropdown.getOptions().size();
                    Dropdown.selectByIndex(DropdownSize - 1);
                } else {
                    System.out.println("Element does not exist, skipping this step");
                }
            } catch (Exception e) {
                System.out.println("No dropdown element present");
            }

        Elem = driver.findElement(SfisrtNameBox);
        Elem.clear();
        Elem.sendKeys(fisrtName);

        Elem = driver.findElement(SmiddleNameBox);
        Elem.clear();
        Elem.sendKeys(middleName);

        Elem = driver.findElement(SlastNameBox);
        Elem.clear();
        Elem.sendKeys(lastName);

        Elem = driver.findElement(ScompanyBox);
        Elem.clear();
        Elem.sendKeys(company);

        Elem = driver.findElement(SaddressBox);
        Elem.clear();
        Elem.sendKeys(address);

        Elem = driver.findElement(SstreetAddress2Box);
        Elem.clear();
        Elem.sendKeys(streetAddress2);

        Elem = driver.findElement(ScityBox);
        Elem.clear();
        Elem.sendKeys(city);

        Dropdown = new Select(driver.findElement(SstateBox));
        Dropdown.selectByVisibleText(state);

        Elem = driver.findElement(SzipBox);
        Elem.clear();
        Elem.sendKeys(zip);

        Dropdown = new Select(driver.findElement(ScountryBox));
        Dropdown.selectByVisibleText(country);


        Elem = driver.findElement(StelephoneBox);
        Elem.clear();
        Elem.sendKeys(telephone);

        Elem = driver.findElement(SfaxBox);
        Elem.clear();
        Elem.sendKeys(fax);

        driver.findElement(ContinueShipping).click();
    }
    public void selectShippingMethod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueShippingMethod)).click();
    }
    public void selectPaymentMethod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ChkMo)).click();
    }
    public void clickPaymentInfo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContinuePayment)).click();
    }
    public void clickPlaceOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceOrder)).click();
    }
    public String getOrderRecievedMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(OrderRecievedMessage)).getText();
    }

    public String getOrderNumber() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumberMessage)).getText();
    }

}
