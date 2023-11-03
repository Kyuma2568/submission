package BT;

import org.testng.annotations.Test;
import driver.driverFactory;
import org.openqa.selenium.WebDriver;

public class TC07_Test {
    @Test
    public void Main() {

        // Create a WebDriver instance
        WebDriver driver = driverFactory.getChromeDriver();

        TC07_Page page = new TC07_Page(driver);

        // Step 1: Go to http://live.techpanda.org/
        page.goToHomePage();

        // Step 2: Click on My Account link
        page.clickMyAccount();

        // Step 3: Login in application using previously created credential
        page.login("aaaaa@email.com", "A123456");

        // Step 4: Click on 'My Orders'
        page.clickMyOrders();

        // Step 5: Click on 'View Order'
        page.clickViewOrder();

        // Step 6: Click on 'Print Order' link
        page.clickPrintOrder();

        // Step 8: A popup will be opened as 'Select a destination' , select 'Save as PDF' link.
//        page.clickSavePDF();

        // Close the browser
        driver.quit();
    }
}