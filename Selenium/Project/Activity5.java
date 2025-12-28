package SeleniumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void getNavigationMenuColor() {

        // Open site
        driver.get("https://alchemy.hguy.co/crm");

        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name"))).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

        // Wait for home page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toolbar")));

        // Locate navigation menu (top bar)
        WebElement navBar = driver.findElement(By.id("toolbar"));

        // Get background color
        String color = navBar.getCssValue("background-color");

        // Print color
        System.out.println("Navigation menu background color: " + color);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
