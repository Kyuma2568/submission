package BT;

import org.testng.annotations.Test;
import driver.driverFactory;
import org.openqa.selenium.WebDriver;

public class TC08_Test {
    @Test
    public void Main() {

        // Create a WebDriver instance
        WebDriver driver = driverFactory.getChromeDriver();

        TC08_Page page = new TC08_Page(driver);
        TC08_CheckOutPage chkout = new TC08_CheckOutPage(driver);

        // Step 1: Go to http://live.techpanda.org/
        page.goToHomePage();

        // Step 2: Click on My Account link
        page.clickMyAccount();

        // Step 3: Login in application using previously created credential
        page.login("aaaaa@email.com", "A123456");

        // Step 4: Click on 'REORDER' link , change QTY & click Update
        page.clickReorder();
        String OldgrandTotal = page.getOldGrandTotal();
        page.changeQty("10");
        page.clickUpdate();

        // Step 5: Verify Grand Total is changed
        String grandTotal = page.getGrandTotal();
        assert !grandTotal.equals(OldgrandTotal) : "Failed update Grand Total!";
        System.out.println("Grand Total Updated");

        // Step 6: Complete Billing & Shipping Information
        chkout.clickProceedToCheckout();

        chkout.enterBillingInformation("New Address", "aaa",
                "aaa", "aaa", "FPT", "24",
                "LVV", "THUDUC", "New York", "123456",
                "United States", "1234567890", "654321");

        chkout.enterShippingInformation("New Address", "aaa",
                "aaa", "aaa", "FPT", "24",
                "LVV", "THUDUC", "New York", "123456",
                "United States", "1234567890", "654321");

        chkout.selectShippingMethod();
        chkout.selectPaymentMethod();
        chkout.clickPaymentInfo();
        chkout.clickPlaceOrder();

        // Step 7: Verify order is generated and note the order number
        String expectedMessage = "THANK YOU FOR YOUR PURCHASE!";
        String actualMessage = chkout.getOrderRecievedMessage();
        assert actualMessage.equals(expectedMessage) : "Order failed!";
        System.out.println("Order sent succeed");

        String orderNumber = chkout.getOrderNumber();
        System.out.println(orderNumber);


        // Close the browser
        driver.quit();
    }
}
