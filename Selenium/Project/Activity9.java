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

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void printLeadsTable() throws InterruptedException {
        // Step a: Open the site
        driver.get("https://alchemy.hguy.co/crm/");
        Thread.sleep(3000);

        // Step b: Login
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        Thread.sleep(3000);

        // Wait for homepage to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toolbar")));
        Thread.sleep(3000);

        // Step c: Navigate to Sales -> Leads
        driver.findElement(By.id("grouptab_0")).click(); // Sales tab
        Thread.sleep(3000);
        driver.findElement(By.id("moduleTab_9_Leads")).click(); // Leads tab
        Thread.sleep(3000);

        // Loop through first 10 rows
        for (int i = 1; i <= 10; i++) {

            // Build dynamic XPath for Name
            String nameXpath = "//*[@id='MassUpdate']/div[3]/table/tbody/tr[" + i + "]/td[3]";
            WebElement nameCell = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath(nameXpath))
            );

            // Build dynamic XPath for User
            String userXpath = "//*[@id='MassUpdate']/div[3]/table/tbody/tr[" + i + "]/td[8]/a";
            WebElement userCell = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath(userXpath))
            );

            System.out.println(
                    "Row " + i + " -> Name: " + nameCell.getText()
                    + " | User: " + userCell.getText()
            );
        }

        // Switch back to default content
        driver.switchTo().defaultContent();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
