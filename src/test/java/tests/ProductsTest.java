package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.Products;

public class ProductsTest {
    private WebDriver driver;
    private Login loginPage;
    private Products productsPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new Login(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        productsPage = new Products(driver);
    }

    @Test
    public void testProductTitle() {
        Assert.assertEquals(productsPage.getProductTitle(), "Products");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}