package FunctionalLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase{
    WebDriver driver;

@BeforeMethod
   public void BeforeMethod(Method method){System.out.println("hellow in browser from launch");
    System.out.println("Method execution started :"+method.getName());
    System.setProperty("TestCaseName",method.getName());
    }

@Test
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


}

