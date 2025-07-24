import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


import static org.testng.Assert.*;

public class LoginTestCase {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\crmd018\\Desktop\\personal\\QA\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * @Test(enabled = false)
     * public void checkTitle() {
     * System.out.println("TestNG is working!");
     * }
     */
  /*  @Test(groups={"positive"})
    @Parameters({"username", "password"})
    public void testLogin(String username, String pwd) {
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        userNameField.sendKeys(username);
        passwordField.sendKeys(pwd);

        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        //Assert the page redirect
        assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "User wasn't redirected");
    }

*/
    @Test(groups={"negative"})
    @Parameters({"username", "password", "errorMessage"})
    public void testWrongLogin(String username, String pwd, String errorMsg) {
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        userNameField.sendKeys(username);
        passwordField.sendKeys(pwd);

        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();


        //Assert the page does not redirect
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/", "User was redirected");

        //Assert the error message appears
        //List<WebElement> errorElements = driver.findElements(By.cssSelector("h3[data-test='error']"));

        //Assert the error message appears
        WebElement errorElement = driver.findElement(By.cssSelector("h3[data-test='error']"));
        assertTrue(errorElement.isDisplayed(), "Error message is not displayed");

        //Assert error content is correct
        assertEquals(errorElement.getText(), errorMsg, "Error message mismatch");
        //}
        //System.out.println("TestNG is working!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
