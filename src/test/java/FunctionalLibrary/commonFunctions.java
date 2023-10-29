package FunctionalLibrary;

import FunctionalLibrary.BrowserClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import static sun.security.util.KnownOIDs.Data;

public class commonFunctions extends BrowserClass {
    WebDriver driver;
    public commonFunctions(WebDriver driver)
    {
        this.driver=driver;

    }

    public  void explicitWait()
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
    }
@DataProvider(name="ReadExcelData")
    public Object[][] readExcelData(Class ExcelData)
    {
        String ExcelSheetName=System.getProperty("TestCaseName");
        Object[][] Data=getExcelData(ExcelSheetName);

        return Data;
    }
    public Object[][] getExcelData(String ExcelSheetName)  {
        Object[][] Data=null;
        try{

            FileInputStream fs=new FileInputStream("C:\\TestData\\"+ExcelSheetName+".xlsx");


        }catch (Exception e){

        }

        return  Data;
    }
}
