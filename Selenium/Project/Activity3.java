package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity3 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void printCopyrightText() {
        // Step a & b: Open browser and navigate to site
        driver.get("https://alchemy.hguy.co/crm/");

        // Step c: Locate the copyright text using visible text
        WebElement firstCopyright = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id='admin_options']")
                )
        );
        // Step d: Print the text
        System.out.println("Footer text: " + firstCopyright.getText());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
