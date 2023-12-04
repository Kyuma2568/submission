package BT;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC09_Test {
    @Test
    public void main() throws InterruptedException {
        WebDriver driver = driverFactory.getChromeDriver();
        TC09_Page check = new TC09_Page(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Step 1: get Link
        driver.get("http://live.techpanda.org/");
        // Step 2: Click on MOBILE menu and add IPHONE to cart
        check.Mobile();
        check.Select();
        // Step 3:  Enter Coupon Code
        check.getTotal();
        System.out.println("origin: " + check.getTotal());
        check.Input("GURU50");
        Thread.sleep(2000);

        // Step 4:  Verify the discount generated
        check.getTotal2();
        System.out.println("discount: " + check.getTotal2());
        Thread.sleep(2000);
        String totalBeforeDiscount = check.getTotal();
        String totalAfterDiscount = check.getTotal2();
        check.compare(totalBeforeDiscount, totalAfterDiscount);
        Thread.sleep(2000);
        driver.quit();
    }
}