package tests;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Cart;
import pages.Login;
import pages.Products;

public class CartTest {
    private WebDriver driver;
    private Login loginPage;
    private Products productsPage;
    private Cart cartPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new Login(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        productsPage = new Products(driver);
        cartPage = new Cart(driver);
    }

    @Test
    public void testAddToCart() {
        // Add the first product to the cart
        productsPage.addToCart("Sauce Labs Backpack"); // Implement this method in ProductsPage
        productsPage.clickCart(); // Implement this method to navigate to CartPage

        // Verify that the product is in the cart
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"), "Product not found in cart."); // Implement this method in CartPage
    }

    @Test(dependsOnMethods = "testAddToCart")
    public void testRemoveFromCart() {
        // Remove the product from the cart
        cartPage.removeFromCart("Sauce Labs Backpack"); // Implement this method in CartPage

        // Verify that the cart is empty
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty."); // Implement this method in CartPage
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
