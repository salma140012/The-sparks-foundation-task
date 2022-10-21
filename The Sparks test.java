package test;

import static org.junit.Assert.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class loginTest {

    String path = "C:/Users/User/Downloads/SeleniumLab/SeleniumLab/";
   
    
    public String getCellData(int row, int col) throws Exception {
        XSSFSheet ExcelWSheet;
        XSSFWorkbook ExcelWBook;

        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(path + "Login.xlsx");

            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet("Sheet1");
            String cellData = ExcelWSheet.getRow(row).getCell(col).getStringCellValue();
            ExcelWBook.close();
            return cellData;
        }
        catch (IOException e){
            return "Error in opening the file";
        }
    }
    
    

    @Test
    public void FirefoxTest() throws Exception {

    	String username = getCellData(1, 0);
    	String password = getCellData(1, 1);
        // Set Firefox Web Driver
        System.setProperty("webdriver.gecko.driver", path + "geckodriver.exe");
    	WebDriver driver = new FirefoxDriver();
        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);    
        // Launch website
        driver.navigate().to("https://www.thesparksfoundationsingapore.org/");
        // Maximize the browser
        driver.manage().window().maximize();   
        
        
//1
        
        //About us and 2 elements
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/nav/div[2]/nav/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[1]/ul/li[7]/a")).click();     
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        assertEquals(true, driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/ul/li[1]")).isDisplayed());
        assertEquals(true, driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[3]/div[1]/h3/span")).isDisplayed());
        
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        ///////////////////////////////
        
//2
        
        //policies and code and 2 elements
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/nav/div[2]/nav/ul/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/nav/div[2]/nav/ul/li[2]/ul/li[2]/a")).click();     
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        assertEquals(true, driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/div/div/h4")).isDisplayed());
        assertEquals(true, driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/ul/li[5]/a")).isDisplayed());  
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        ////////////////////////////////////
        
//3
        
        //programs and 2 elements
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/nav/div[2]/nav/ul/li[3]/a")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/nav/div[2]/nav/ul/li[3]/ul/li[4]/a")).click();   
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);     
        assertEquals(true, driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div/h4/a")).isDisplayed());
        assertEquals(true, driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/ul/li[4]/a")).isDisplayed());   
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        //////////////////////////////////////
        
//4
        
        // links and 2 elements
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/nav/div[2]/nav/ul/li[4]/a")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/nav/div[2]/nav/ul/li[4]/ul/li[3]/a")).click();       
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        assertEquals(true, driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/div/div/div[2]/div/h4/a")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        ////////////////////////////////////
        
//5
        
        //join us and 2 elements
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/nav/div[2]/nav/ul/li[5]/a")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/nav/div[2]/nav/ul/li[5]/ul/li[1]/a")).click();      
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        assertEquals(true, driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div[1]/div/h4")).isDisplayed());
        assertEquals(true, driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div[2]/div/h4")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        Thread.sleep(2000);
       	driver.close();
    
}
}
