package Mappings;
import FunctionalLibrary.TestBase;
import FunctionalLibrary.TestListeners;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static FunctionalLibrary.TestListeners.test;

public class HomePageMappings extends TestBase {
public WebDriver driver;
      public HomePageMappings(){
          this.driver= TestBase.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(className="product")
    public List<WebElement> Itemlist;
    @FindBy(className="product-price")
    public  List<WebElement> Pricelist;
    @FindBy(className="product-name")
    public static   List<WebElement> Productname;

    @FindBys({
            @FindBy(className="product-action"),
            @FindBy(linkText="ADD TO CART")
    })
    public  WebElement AddToCart;

    public  List<String> GetItemNames()
    {
        List<String> ActualList=new ArrayList<>();
        for (WebElement ele: Productname )
            ActualList.add(ele.getText());
        return  ActualList;
    }
    public  void AddItemToCart(String itemName)
    {
       for (WebElement webelement: Productname)
       {
           if(webelement.getText().equals(itemName))
           {
           driver.findElement(By.xpath("//h4[contains(text(),'"+itemName+"')]//following::*[@class='product-action']")).click();
               test.log(Status.PASS,"Successfully added item " +itemName +"to cart ");
           }
           else
               Reporter.log("Listed item " +itemName +" Not found on page ");
       }
    }
    public  void ModifyQuantity(String itemName,String qtyToAdd) throws InterruptedException {
        for (WebElement webelement: Productname)
        {
            if(webelement.getText().equals(itemName))
            {
                for(int i=0;i<Integer.parseInt(qtyToAdd);i++) {
                    driver.findElement(By.xpath("//h4[contains(text(),'" + itemName + "')]//following::*[@class='increment']")).click();
                    Thread.sleep(500);
                }
                test.log(Status.PASS,"Successfully added item " +itemName +"to cart with quantity "+qtyToAdd);
            }
            else
                Reporter.log("Listed item " +itemName +" Not found on page ");

        }
    }
}
