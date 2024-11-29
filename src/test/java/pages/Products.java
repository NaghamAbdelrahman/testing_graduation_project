package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Products{
    private WebDriver driver;

    public Products(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart(String productName) {
        By addToCartButton = By.xpath("//div[text()='" + productName + "']/following-sibling::button");
        driver.findElement(addToCartButton).click();
    }

    public void clickCart() {
        By cartButton = By.id("shopping_cart_container");
        driver.findElement(cartButton).click();
    }

    public String getProductTitle() {
        return driver.findElement(By.className("title")).getText();
    }
}

