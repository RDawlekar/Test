package TestCases;

import FunctionalLibrary.dataDriven;
import FunctionalLibrary.TestBase;
import Mappings.HomePageMappings;
import org.testng.annotations.Test;

public class HomePage extends TestBase {
    @Test(dataProvider = "getdata",dataProviderClass = dataDriven.class)
    public void verifyPage(String productNametoSelect,String qtyToAdd) throws InterruptedException {
        HomePageMappings homePageMappings=new HomePageMappings();
        homePageMappings.ModifyQuantity(productNametoSelect,qtyToAdd);
        homePageMappings.AddItemToCart(productNametoSelect);

    }
}
