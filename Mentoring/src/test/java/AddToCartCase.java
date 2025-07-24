import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


import static org.testng.Assert.*;


public class AddToCartCase {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\crmd018\\Desktop\\personal\\QA\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 0)
    //@Parameters({"username", "password"})
    public void testLogin() {
            WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            userNameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");

            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
            //Assert the page redirect
            assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "User wasn't redirected");
    }

    @Test(dependsOnMethods = "testLogin")
    public void addItemToCartTest() {

       /* WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        userNameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        //Assert the page redirect
        assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "User wasn't redirected");*/

        WebElement backpackButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));
        wait.until(ExpectedConditions.elementToBeClickable(backpackButton)).click();

        //Assert new item on the cart
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_link")));
        WebElement shoppingCartBadge = driver.findElement(By.className("shopping_cart_badge"));
        assertEquals(shoppingCartBadge.getText(), "1", "Item is not added to the cart");

        //Assert button renamed
        assertTrue(driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed(), "Remove button is not displayed");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
