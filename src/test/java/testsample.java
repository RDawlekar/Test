import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testsample {
    @BeforeTest(alwaysRun = true)
    void StartReport(){System.out.println("hellow in browser from launch");
    }
 @Test
     void browserLaunch()
    {
        System.out.println("hellow in browserlogin");
        System.setProperty("driver.chrome.driver","C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\chrome.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://google.com");
        System.out.println("Browser launch is sucessfull");
        CheckTitle(driver);
    }


    void CheckTitle(WebDriver driver) {
       Assert.assertEquals( driver.getTitle(),"Google");
       Reporter.log("successfully launched the site");
    }


  @AfterTest(alwaysRun = true)
    void browserLogout() {
        System.out.println("hellow in browserlogout");
    }

    @AfterTest(alwaysRun = true)
    void GenerateReport() {
        System.out.println("hellow in browserlogout");
    }

}

