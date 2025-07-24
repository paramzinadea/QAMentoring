import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    public class TestSelenium {
        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\crmd018\\Desktop\\personal\\QA\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com");

            System.out.println("Title: " + driver.getTitle());

            driver.quit();
        }
    }
