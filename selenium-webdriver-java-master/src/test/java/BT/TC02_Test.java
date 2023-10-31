package BT;

import org.testng.annotations.Test;
import driver.driverFactory;
import org.openqa.selenium.WebDriver;

public class TC02_Test {
    @Test
    public void main() {

        // Create a WebDriver instance
        WebDriver driver = driverFactory.getChromeDriver();

        // Step 1: get Link
        driver.get("http://live.techpanda.org/");

        TC02_Page page = new TC02_Page(driver);


        // Step 2: Click on MOBILE menu
        page.clickMobileMenu();

        // Step 3: Read the cost of Sony Xperia mobile
        String listPageCost = page.getListPageCost();

        // Step 4: Click on Sony Xperia mobile
        page.clickSonyXperiaMobile();

        // Step 5: Read the Sony Xperia mobile cost from the detail page
        String detailPageCost = page.getDetailPageCost();

        // Step 6: Compare the product cost in the list and details page
        assert listPageCost.equals(detailPageCost) : "Product cost mismatch";

        // Close the browser
        driver.quit();
    }
}

