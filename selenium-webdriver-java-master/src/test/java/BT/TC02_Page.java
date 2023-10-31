package BT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    public class TC02_Page {
        private WebDriver driver;

        public TC02_Page(WebDriver driver) {
            this.driver = driver;
        }

        public void clickMobileMenu() {
            WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
            mobileMenu.click();
        }

        public String getListPageCost() {
            return driver.findElement(By.xpath("//h2[contains(@class, 'product-name')]/a[text()='Sony Xperia']/parent::h2/following-sibling::div/span[@class='regular-price']/span[@class='price']")).getText();
        }

        public void clickSonyXperiaMobile() {
            driver.findElement(By.linkText("SONY XPERIA")).click();
        }

        public String getDetailPageCost() {
            return driver.findElement(By.cssSelector("span#product-price-1")).getText();
        }
    }

