package SeleniumProject;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import java.time.Duration;

	public class Activity1 {

	    private WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	    }

	    @Test
	    public void verifyWebsiteTitle() {
	        driver.get("https://alchemy.hguy.co/crm/");

	        String actualTitle = driver.getTitle();
	        String expectedTitle = "SuiteCRM";
	        
			System.out.println("actualTitle: " +actualTitle);
	        Assert.assertEquals(actualTitle, expectedTitle, "Website title does not match!");
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}
