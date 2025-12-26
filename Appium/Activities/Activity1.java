package Activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;

public class Activity1 {

    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
 
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setApp("Downloads/calculator.apk");   
 
        URL appiumServerURL = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(appiumServerURL, options);
    }
 
    @Test
    public void multiplyTest() { 
        driver.findElement(AppiumBy.id("digit_3")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
 
        String result = driver.findElement(AppiumBy.id("result_final")).getText();
         Assert.assertEquals(result, "6");
    }
 
    @AfterClass
    public void tearDown() { 
        driver.quit();
    }
}
