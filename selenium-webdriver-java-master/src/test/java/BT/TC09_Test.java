package BT;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09_Test {
    @Test
    public void Main() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        TC09_Page page = new TC09_Page(driver);

        page.clickOnMobileMenu();
        page.addToCartIphone();
        page.enterCouponCode("GURU50");
        page.clickApplyCouponButton();


        Assert.assertEquals(page.DiscountedPrice(), page.Price() * 0.95);
        System.out.println("Price is discounted by 5%");

        driver.quit();
    }
}