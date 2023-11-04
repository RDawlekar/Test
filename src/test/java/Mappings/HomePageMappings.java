package Mappings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class HomePageMappings {
WebDriver driver;
      public HomePageMappings(WebDriver driver){
         this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className="product")
    public static List<WebElement> Itemlist;
    @FindBy(className="product-price")
    public static List<WebElement> Pricelist;
    @FindBy(className="product-name")
    public static List<WebElement> Pricename;


    public static  List<String> GetItemNames()
    {
        List<String> ActualList=new ArrayList<>();
        for (WebElement ele: Pricename )
            ActualList.add(ele.getText());
        return  ActualList;
    }


}
