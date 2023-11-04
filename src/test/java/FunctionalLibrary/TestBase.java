package FunctionalLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public abstract class TestBase{
    public static WebDriver driver;


    @BeforeMethod
    @Parameters({"URL" , "title"})
    public void browserLaunch(String Url, String title)
    {
        try{
            WebDriverManager.chromedriver().setup();
//            System.setProperty("driver.chrome.driver","C:\\Users\\rkuma\\Downloads\\chrome-win64\\chrome-win64\\chromedriver.exe");
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
}

