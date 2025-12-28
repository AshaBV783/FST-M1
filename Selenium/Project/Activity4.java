package SeleniumProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import java.time.Duration;

	public class Activity4 {

	    WebDriver driver;
	    WebDriverWait wait;

	    @BeforeMethod
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	    }

	    @Test
	    public void loginTest() {

	        // a & b: Open browser and navigate
	        driver.get("https://alchemy.hguy.co/crm/");

	        // c: Locate username and password fields
	        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
	        WebElement passwordField = driver.findElement(By.id("username_password"));

	        // d: Enter credentials
	        usernameField.sendKeys("admin");
	        passwordField.sendKeys("pa$$w0rd");

	        // e: Click login
	        driver.findElement(By.id("bigbutton")).click();

	        // f: Verify homepage loaded (check Dashboard or user menu visible)
	        boolean isHomeLoaded = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.id("toolbar"))
	        ).isDisplayed();

	        Assert.assertTrue(isHomeLoaded, "Home page did not load after login!");

	        System.out.println("Login successful and homepage verified.");
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}

	

