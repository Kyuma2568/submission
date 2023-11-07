package BT;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import driver.driverFactory;

public class TC10_Test {
    @Test
    public void Main() {
        WebDriver driver = driverFactory.getChromeDriver();
        TC10_Page page = new TC10_Page(driver);

        // Step 1: Go to backend login page
        driver.get("http://live.techpanda.org/index.php/backendlogin");

        // Step 2: Login with provided credentials
        page.login("user01", "guru99com");

        // Step 3: Navigate to Sales -> Orders menu
        page.closeMsgBox();
        page.goToOrders();

        // Step 4: Select 'CSV' in Export To dropdown and click Export button
        page.exportOrdersToCSV();


        driver.quit();
    }
}