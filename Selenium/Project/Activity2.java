package SeleniumProject;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import java.time.Duration;

	public class Activity2 {

	    WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	    }

	    @Test
	    public void getHeaderImageUrlTest() {
	        // Open site
	        driver.get("https://alchemy.hguy.co/crm/");

	        // Locate header image
	        WebElement headerImage = driver.findElement(By.cssSelector("img[alt='SuiteCRM']"));

	        // Get src attribute
	        String imageUrl = headerImage.getAttribute("src");

	        // Print URL
	        System.out.println("Header Image URL: " + imageUrl);
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}


