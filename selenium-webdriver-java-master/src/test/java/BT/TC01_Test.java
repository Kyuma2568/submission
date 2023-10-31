package BT;

import org.testng.annotations.Test;
import driver.driverFactory;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class TC01_Test {
    @Test
    public void test() {

        // Create a WebDriver instance
        WebDriver driver = driverFactory.getChromeDriver();

        // Step 1: get Link
        driver.get("http://live.techpanda.org/");

        TC01_Page page = new TC01_Page(driver);

        // Step bonus: Verify Title of the page
        String expectedTitle = "Home page";
        String actualTitle = page.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Verification successfully");
        } else {
            System.out.println("Verification failed");
        }

        // Step 2: Click on MOBILE menu
        page.clickMobileMenu();

        // Step 3: Select SORT BY dropdown as name
        page.selectSortBy("Name");
        
        // Step 4: Verify all products are sorted by name
        List<String> productNames = page.getProductNames();
        for (int i = 0; i < productNames.size() - 1; i++) {
            if (productNames.get(i).compareTo(productNames.get(i + 1)) > 0) {
                System.out.println("Products are not sorted by name");
                break;
            }
        }

        // Close the browser
        driver.quit();
    }
}