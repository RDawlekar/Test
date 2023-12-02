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
}
