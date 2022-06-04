package Utilities;


import PageObjects.Calculator.MainPage;
import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base {

    /*
###########################################################################################
    Method Name: All Methods in page
    Method Description: These Methods Initializes elements and return Page Objects
                        of all Page Objects classes referred to NopCommerce Application.
    Method Parameters: void
    Method Return Type: void
###########################################################################################
     */

public static void initWeb() {
    //Web
    nopCommerceHtcOneM8 = PageFactory.initElements(driver, PageObjects.NopCommerceWeb.HtcOneM8Page.class);
    nopCommerceHtcOneMini = PageFactory.initElements(driver, PageObjects.NopCommerceWeb.HtcOneMiniPage.class);
    nopCommercePhonesPage =  PageFactory.initElements(driver, PageObjects.NopCommerceWeb.PhonesPage.class);

    nopCommerceFooter = PageFactory.initElements(driver, PageObjects.NopCommerceWeb.FooterPage.class);
    nopCommerceRegister = PageFactory.initElements(driver, PageObjects.NopCommerceWeb.RegisterPage.class);
    nopCommerceHeader = PageFactory.initElements(driver, PageObjects.NopCommerceWeb.HeaderPage.class);
    nopCommerceHeaderApparelMenu = PageFactory.initElements(driver, PageObjects.NopCommerceWeb.HeaderApparelMenuPage.class);
    nopCommerceShoes = PageFactory.initElements(driver, PageObjects.NopCommerceWeb.ShoesPage.class);
    nopCommerceCommon = PageFactory.initElements(driver, PageObjects.NopCommerceWeb.CommonPage.class);
    nopCommerceCartMain = PageFactory.initElements(driver, PageObjects.NopCommerceWeb.ShoppingCartMainPage.class);
    nopCommerceNikeRunningShoes = PageFactory.initElements(driver, PageObjects.NopCommerceWeb.NikeRunningShoesPage.class);

    //Web - Sauce Demo
    sauceLogin = PageFactory.initElements(driver, PageObjects.SauceDemo.LoginPage.class);
    }

    //Mobile
    public static void initMortgage() {
        mortgageMain = new PageObjects.Mortgage.MainPage(mobileDriver);

    }

    //Electron
    public static void initTodoList(){
        todoListMain = PageFactory.initElements(driver, PageObjects.todo.MainPage.class);
    }


    //Desktop
    public static void initCalculator() {
        calcMain = PageFactory.initElements(driver, PageObjects.Calculator.MainPage.class);
    }


}
