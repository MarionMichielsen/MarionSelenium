import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class HelloSeleniumTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        System.out.println("Test starting.");
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
        WebDriverManager.safaridriver().setup();
        driver = new ChromeDriver();
        String testURL = "https://marionmichielsen-frontend.herokuapp.com/";
        driver.get(testURL);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test completed.");
        driver.quit();
    }

    @Test
    @DisplayName("Check if title is Document")
    public void testTitle() {
        Assertions.assertEquals(driver.getTitle(), "Document");
        System.out.println("Document title: "+driver.getTitle());
    }

    @Test
    @DisplayName("check URL")
    public void testURL(){
        Assertions.assertEquals("https://marionmichielsen-frontend.herokuapp.com/", driver.getCurrentUrl());
        System.out.println("Current URL: "+driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check if CreateTable Button works")
    public void testCreateTable() {
        WebElement button = driver.findElement(By.id("buttons"));
        button.click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", button);
        System.out.println("tested Generate table button");
    }


}

