package BT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class TC01_Page {
    private WebDriver driver;

    public TC01_Page(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickMobileMenu() {
        WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
        mobileMenu.click();
    }

    public void selectSortBy(String option) {
        WebElement sortDropdown = driver.findElement(By.xpath("//select[@title='Sort By']"));
        Select sortSelect = new Select(sortDropdown);
        sortSelect.selectByVisibleText(option);
    }
    public List<String> getProductNames() {
        List<WebElement> nameElements = driver.findElements(By.cssSelector("h2[class='product-name']"));
        return nameElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
