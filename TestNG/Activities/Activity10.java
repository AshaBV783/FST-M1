import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Activity10 {

    WebDriver driver;

    // ---------- BeforeClass ----------
    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/simple-form");
    }

    // ---------- DataProvider using Apache POI ----------
    @DataProvider(name = "formData")
    public Object[][] readExcelData() throws IOException {

        FileInputStream file = new FileInputStream("src/test/resources/TestData.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = row.getCell(j).toString();
            }
        }

        workbook.close();
        file.close();
        return data;
    }

    // ---------- Test ----------
    @Test(dataProvider = "formData")
    public void testSimpleForm(String fullName, String email, String date, String details) {

        driver.findElement(By.id("full-name")).clear();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("date")).clear();
        driver.findElement(By.id("details")).clear();

        driver.findElement(By.id("full-name")).sendKeys(fullName);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("date")).sendKeys(date);
        driver.findElement(By.id("details")).sendKeys(details);

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert message: " + alertText);

        Assert.assertTrue(alertText.contains(fullName));

        driver.switchTo().alert().accept();
    }

    // ---------- AfterClass ----------
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
