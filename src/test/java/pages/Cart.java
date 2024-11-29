package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
    private WebDriver driver;

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductInCart(String productName) {
        By productInCart = By.xpath("//div[text()='" + productName + "']");
        return driver.findElements(productInCart).size() > 0;
    }

    public void removeFromCart(String productName) {
        By removeButton = By.xpath("//div[text()='" + productName + "']/following-sibling::button[@class='btn_secondary cart_button']");
        driver.findElement(removeButton).click();
    }

    public boolean isCartEmpty() {
        By emptyCartMessage = By.className("cart_list");
        return driver.findElements(emptyCartMessage).isEmpty();
    }
}