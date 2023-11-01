package FunctionalLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ExtentReport implements ISuiteListener {
    WebDriver driver;

@Override
    public void onStart(ISuite iSuite)
    {
        System.out.println("Suite execution started :"+iSuite.getName() +"at"+ System.currentTimeMillis());

    }


@Override
public void onFinish(ISuite iSuite)
{
    System.out.println("Suite execution ended :"+iSuite.getName()+"at"+ System.currentTimeMillis());

}

}

