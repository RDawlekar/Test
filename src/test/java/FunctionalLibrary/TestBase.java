package FunctionalLibrary;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Iterator;


public abstract class TestBase{
    public static WebDriver driver;


    @BeforeMethod
    @Parameters({"URL" , "title"})
    public void browserLaunch(String Url, String title)
    {
        try{
//            WebDriverManager.chromedriver().setup();
            System.setProperty("driver.chrome.driver","C:\\Users\\rkuma\\Downloads\\chrome-win64\\chrome-win64\\chromedriver.exe");
                driver=new ChromeDriver();
                driver.get(Url);
                CheckTitle(driver,title);
   }
       catch(Exception e)
        {

            System.out.println("Browser launch is exception"+e.getMessage());
        }

    }
    void CheckTitle(WebDriver driver,String title) {
       Assert.assertEquals( driver.getTitle(),title);
       Reporter.log("successfully launched the site");
    }
@AfterMethod
public  void close()
{
    driver.close();
    driver.quit();
}
    public static WebDriver getDriver()
    {
        return  driver;
    }


    public static String getScreenshot(String MethodName,WebDriver driver)  {
        File path=new File(System.getProperty("user.dir")+"\\Reports\\"+MethodName+"_"+Date.valueOf(LocalDate.now())+"_"+System.currentTimeMillis()+"\\"+Date.valueOf(LocalDate.now())+"_"+System.currentTimeMillis()+".png");
        try
        {
            TakesScreenshot screenshot=(TakesScreenshot)driver;
            File screenPath=screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenPath,path);
        }   catch (Exception e)
         {
            e.printStackTrace();
            }
    return path.getPath();
    }
    public static void cleanReports() {
        try {
            File currentUsersHomeDir = new File(System.getProperty("user.dir") + "\\Reports");
            if (FileUtils.sizeOfDirectory(currentUsersHomeDir) > 0) {
                FileUtils.deleteDirectory(currentUsersHomeDir);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

