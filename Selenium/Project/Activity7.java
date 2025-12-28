package SeleniumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
    }

    @Test
    public void readAdditionalInfo() {
        // 1. Open CRM site
        driver.get("https://alchemy.hguy.co/crm");

        // 2. Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name"))).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

        // 3. Wait for home page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toolbar")));

        // 4. Navigate to Sales -> Leads
        WebElement salesMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grouptab_0"))); // Sales menu
        actions.moveToElement(salesMenu).perform();

        WebElement leadsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moduleTab_9_Leads"))); // Leads submenu
        leadsMenu.click();

        // 5. Wait for Leads table to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MassUpdate")));

     // 6. Click on the Additional Information icon at the end of the first row
     // Locate the first row and find the "i" icon
        WebElement additionalInfoIcon = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@id=\"adspan_77c0ebaa-448d-740d-a00f-605ae70266e9\"]")
        ));
        additionalInfoIcon.click();
      
        // 7. Wait for the popup to appear
        WebElement getPhoneNumbElement = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@id=\"ui-id-5\"]/span")
        ));
        // Step d: Print the text
        System.out.println("Footer text: " + getPhoneNumbElement.getText());
        
        
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}