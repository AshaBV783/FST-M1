package SeleniumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Initialize Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void verifyActivitiesMenu() {
        // Open CRM site
        driver.get("https://alchemy.hguy.co/crm");

        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name"))).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

        // Wait for home page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toolbar")));

        // Locate navigation menu and "Activities" menu item
        WebElement activitiesMenu = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("grouptab_3") // "Activities" menu item ID in SuiteCRM
            )
        );

        // Verify it is displayed and clickable
        Assert.assertTrue(activitiesMenu.isDisplayed(), "'Activities' menu is not displayed");
        Assert.assertTrue(activitiesMenu.isEnabled(), "'Activities' menu is not clickable");

        System.out.println("'Activities' menu exists and is clickable.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
