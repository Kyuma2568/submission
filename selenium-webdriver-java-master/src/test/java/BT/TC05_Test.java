package BT;


import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.time.Duration;


    public class TC05_Test {
    @Test
        public void main() {
            WebDriver driver = driverFactory.getChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.get("http://live.techpanda.org/");

            TC05_Page page = new TC05_Page(driver);

            page.clickOnMyAccountLink();
            page.clickCreateAnAccountLink();
            page.fillNewUserInfo("aaa", "aaa", "aaa", "aaaaa@email.com", "A123456", "A123456");
            page.clickRegister();

            String expectedMessage = "Thank you for registering with Main Website Store.";
            String actualMessage = page.getRegistrationMessage();
            assert actualMessage.equals(expectedMessage) : "Registration failed!";

            page.goToTvMenu();
            page.addToWishlistLgLcd();
            page.clickShareWishlist();

            page.enterEmailAndMessage("A@gmail.com", "aaaaaaa");
            page.clickShareWishlist();

            expectedMessage = "Your Wishlist has been shared.";
            actualMessage = page.getSharedWishlistMessage();
            assert actualMessage.equals(expectedMessage) : "Shared wishlist failed!";

            driver.quit();
        }
    }

