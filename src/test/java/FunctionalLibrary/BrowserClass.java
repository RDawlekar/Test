package FunctionalLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public abstract class BrowserClass {

    @BeforeTest(alwaysRun = true)
    void BeforeMethod(Method method){System.out.println("hellow in browser from launch");
        System.setProperty("TestCaseName",method.getName());
    }

    @Test
    @Parameters({"URL" , "title"})
    public void browserLaunch(String Url,String title)
    {
        try{

            System.setProperty("driver.chrome.driver","C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\chrome.exe");
        WebDriver driver= new ChromeDriver();
        driver.get(Url);
        CheckTitle(driver,title);

    }
       catch(Exception e)
        {
            System.out.println("Browser launch is sucessfull");
        }


    }


    void CheckTitle(WebDriver driver,String title) {
       Assert.assertEquals( driver.getTitle(),title);
       Reporter.log("successfully launched the site");
    }



}

