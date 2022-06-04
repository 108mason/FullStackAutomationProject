package SanityTests;

import Extentions.UIActions;
import Extentions.Verifications;
import Utilities.CommonOps;
import WorkFlows.webFlows;
import com.sun.org.glassfish.gmbal.Description;
import org.testng.annotations.Test;


public class NopCommerceWeb extends CommonOps {

    @Test(description = "Test01 - Verify Registration")
    @Description("This test registers with credentials and Verifies Log out link appearance")
    public void Test01_verifyRegistration(){
        webFlows.register(getData("Gender"),getData("FirstName"),getData("LastName"),
                getData("DayOfBirth"),getData("MonthOfBirth"),getData("YearOfBirth"),
                getData("Email"),getData("Company"),getData("Password"));
        Verifications.assertTextInElement(nopCommerceRegister.getTxt_registerConfirmation(),"Your registration completed");
    }

    @Test(description = "Test02 - Verify List Order - Low to High")
    @Description("This test Verifies List order By Price 'Low to High' is correct")
    public void Test02_verifyListOrder(){
        UIActions.mouseHover(nopCommerceHeader.getLink_apparel(),nopCommerceHeaderApparelMenu.getLink_shoes());
        UIActions.selectFromDropDown(nopCommerceShoes.getSelect_orderBy(),"Price: Low to High");
        Verifications.assertCondition(webFlows.isProductListPriceSorting_LowToHigh(nopCommerceShoes.getList_products()));
    }


    @Test(description = "Test03 - Verify Addition To Cart")
    @Description("This test adds product from Shoes List to Cart and Verifies it's Addition")
    public void Test03_verifyAdditionToCart(){
        UIActions.mouseHover(nopCommerceHeader.getLink_electronics(),nopCommerceHeaderApparelMenu.getLink_phones());
        webFlows.addproductfromelectronicslisttocart("HTC One M8 Android L 5.0 Lollipop");
        UIActions.click(nopCommerceHeader.getLink_cart());
        Verifications.assertNumberOfElementsInList(nopCommerceCartMain.getList_productsInTheCart(),1);
    }


    @Test(description = "Test05 - Verify LOGO")
    @Description("This test Verifies The LOGO of The AUT (using Sikuli tool)")
    public void Test06_verifyLOGO(){
        Verifications.assertElementVisually("CompanyLogo");
    }

}
