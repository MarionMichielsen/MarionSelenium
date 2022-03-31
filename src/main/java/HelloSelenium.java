import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.concurrent.TimeUnit;



class HelloSeleniumTest {

    final private String testURL = "https://marionmichielsen-frontend.herokuapp.com/";

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("Test starting...");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("Test completed.");
    }

    @Test
    @DisplayName("Check if title is Super Mario")
    public void testTitle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(testURL);
        Assertions.assertEquals(driver.getTitle(), "Document");
        System.out.println(driver.getTitle());
    }


    @Test
    @DisplayName("Check if user has UUID")
    public void testUUID() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(testURL);
        String showUUID = driver.findElement(By.id("app")).getAttribute("innerHTML");
        //String UUID = showUUID.getAttribute("innerHTML");
        System.out.println("This is the UUID: "+showUUID);
    }
}


/*

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class HelloSelenium {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
        WebDriverManager.safaridriver().setup();

        WebDriver driver = new ChromeDriver();



        driver.get("https://google.com");


        System.out.println(driver.getTitle()); // => "Google"



        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        Thread.sleep(5 * 1000);




        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.name("btnK"));





        // Skriv något i textrutan
        searchBox.sendKeys("Sele");
        searchButton.click();

        driver.getTitle();

        String urlValue = driver.getCurrentUrl();



        System.out.println(searchBox.getAttribute("value"));




        searchButton.getText();
        searchBox = driver.findElement(By.name("q"));
        searchBox.getAttribute("value"); // => "Selenium"


        driver.quit();






    }
}*/