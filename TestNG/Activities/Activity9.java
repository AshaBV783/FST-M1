import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
    WebDriver driver;

    @BeforeClass
    public void setUp() { 
        driver = new FirefoxDriver();

        Reporter.log("Start"); 
        driver.get("https://training-support.net/webelements/alerts");
        Reporter.log("Opened");
 
        Reporter.log("title " + driver.getTitle() + " |");
    }

    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("TC started |");
        driver.switchTo().defaultContent();
    }

    @Test(priority = 1)
    public void simpleAlertTestCase() {
        Reporter.log("simpleAlertTestCase() started |"); 
        driver.findElement(By.id("simple")).click();
        Reporter.log("Simple Alert opened |");
 
        Alert simpleAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");
 
        String alertText = simpleAlert.getText();
        Reporter.log("Alert  : " + alertText + " |");
 
        Assert.assertEquals(" simple alert!", alertText);

        simpleAlert.accept();
        Reporter.log("Alert closed");

        Reporter.log("TC ended |");
    }

    @Test(priority = 2)
    public void confirmAlertTestCase() {
        Reporter.log("confirmAlertTestCase() started |"); 
        driver.findElement(By.id("confirmation")).click();
        Reporter.log("Confirm Alert opened |");
 
        Alert confirmAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |"); 
        String alertText = confirmAlert.getText();
        Reporter.log("Alert text is: " + alertText + " |");
 
        Assert.assertEquals(" confirmation alert!", alertText);

        confirmAlert.accept();
        Reporter.log("Alert closed |");

        Reporter.log("TC ended |");
    }

    @Test(priority = 3)
    public void promptAlertTestCase() {
        Reporter.log("promptAlertTestCase() started |"); 
        driver.findElement(By.id("prompt")).click();
        Reporter.log("Prompt Alert opened |");
 
        Alert promptAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");
 
        String alertText = promptAlert.getText();
        Reporter.log("Alert : " + alertText + " |");
 
        Assert.assertEquals("Type text", alertText); 
        promptAlert.sendKeys("good!");
        Reporter.log("Text  alert |"); 
        promptAlert.accept();
        Reporter.log("Alert closed |");

        Reporter.log("TCended |");
    }

    @AfterClass
    public void tearDown() {
        Reporter.log("End|"); 
        driver.close();
    }
}