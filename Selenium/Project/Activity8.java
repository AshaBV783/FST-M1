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
import java.util.List;

public class Activity8 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Initialize Chrome driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void printOddRows() {
        // Step a + b: Open URL and login
        driver.get("https://alchemy.hguy.co/crm/");

        // Enter username
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
        username.sendKeys("admin");

        // Enter password
        WebElement password = driver.findElement(By.id("username_password"));
        password.sendKeys("pa$$w0rd");

        // Click login
        driver.findElement(By.id("bigbutton")).click();

        // Navigate to Sales -> Accounts
        WebElement salesMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("grouptab_0")));
        salesMenu.click();

        WebElement accountsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("moduleTab_9_Accounts")));
        accountsMenu.click();

        WebElement tbody = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id='MassUpdate']/div[3]/table/tbody")
                )
        );

        List<WebElement> oddRows = tbody.findElements(By.xpath("./tr[contains(@class,'oddListRowS1')]"));

        System.out.println("First 5 odd-numbered row names:");

        // 4. Loop through first 5 odd rows
        for (int i = 0; i < oddRows.size() && i < 5; i++) {

            // 5. Get Name column (update index if Name column is different)
        	WebElement nameLink = oddRows.get(i).findElement(By.xpath("./td[3]/b/a"));

            System.out.println(nameLink.getText());

        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
