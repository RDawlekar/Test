package FunctionalLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
public class commonFunctions extends  TestBase {
    WebDriver driver;
    public commonFunctions()
    {
        this.driver=TestBase.driver;

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
