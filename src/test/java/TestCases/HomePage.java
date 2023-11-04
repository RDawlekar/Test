package TestCases;

import FunctionalLibrary.TestBase;
import Mappings.HomePageMappings;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends TestBase {

    @Test
    public void verifyPage()
    {
        HomePageMappings HM =new HomePageMappings(TestBase.driver);
        List<String> ActualList= HomePageMappings.GetItemNames();
        for (String ele:ActualList)
        {
            System.out.print(ele+ " ");
        }


    }


}
