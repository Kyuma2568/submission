package BT;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC04_Test {
    @Test
    public void main() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://live.techpanda.org/");

        TC04_Page page = new TC04_Page(driver);

        page.clickOnMobileMenu();
        page.addToCompareSonyXperia();
        page.addToCompareIphone();
        page.clickOnCompareButton();


        String expectedHeading = "COMPARE PRODUCTS";
        String actualHeading = page.getPopupHeading();
        assert actualHeading.equals(expectedHeading) : "Popup heading does not match!";

        String x = page.getPopupHeading();
        System.out.println("\nPage Heading: " + x);
        String y = page.getProductNames1();
        System.out.println("1st Product name: " + y);
        String z = page.getProductNames2();
        System.out.println("2nd Product name: " + z);

        driver.quit();
    }
}