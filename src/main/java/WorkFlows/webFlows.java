package WorkFlows;

import Extentions.DBActions;
import Extentions.UIActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class webFlows extends CommonOps
{

    @Step("Business Flow: Fill Form Register")
    public static void register(String gender, String firstName, String lastName, String dayOfBirth, String monthOfBirth, String yearOfBirth, String email, String company, String pass) {
        UIActions.click(nopCommerceHeader.getLink_register());
        if (gender.equalsIgnoreCase("male"))
            UIActions.click(nopCommerceRegister.getBtn_male());
        else
            UIActions.click(nopCommerceRegister.getBtn_female());
        UIActions.updateText(nopCommerceRegister.getTxt_firstName(), firstName);
        UIActions.updateText(nopCommerceRegister.getTxt_lastName(), lastName);
        if (!dayOfBirth.equalsIgnoreCase("null"))
            UIActions.selectFromDropDown(nopCommerceRegister.getSelect_dayOfBirth(), dayOfBirth);
        if (!monthOfBirth.equalsIgnoreCase("null"))
            UIActions.selectFromDropDown(nopCommerceRegister.getSelect_monthOfBirth(), monthOfBirth);
        if (!yearOfBirth.equalsIgnoreCase("null"))
            UIActions.selectFromDropDown(nopCommerceRegister.getSelect_yearOfBirth(), yearOfBirth);
        UIActions.updateText(nopCommerceRegister.getTxt_email(), email);
        if (!company.equalsIgnoreCase("null"))
            UIActions.updateText(nopCommerceRegister.getTxt_company(), company);
        if (!nopCommerceRegister.getBtn_newsLetter().isSelected())
            UIActions.click(nopCommerceRegister.getBtn_newsLetter());
        UIActions.updateText(nopCommerceRegister.getTxt_pass(), pass);
        UIActions.updateText(nopCommerceRegister.getTxt_confirmPass(), pass);
        UIActions.click(nopCommerceRegister.getBtn_register());
    }

    @Step("Business Flow: Check if the Product Price Sorting is: Low to High")
    public static boolean isProductListPriceSorting_LowToHigh(List<WebElement> productList){
        wait.until(ExpectedConditions.attributeContains(nopCommerceCommon.getProductContainerAjax(),"style","display: none;"));
        boolean isLowToHigh = true;
        for (int i=0;i<productList.size()-1;i++){
            if (Double.parseDouble(productList.get(i).findElement(By.xpath(".//span[@class='price actual-price']")).getText().substring(1))<=Double.parseDouble(productList.get(i+1).findElement(By.xpath(".//span[@class='price actual-price']")).getText().substring(1)))
                continue;
            else{
                isLowToHigh = false;
                break;
            }
        }
        return isLowToHigh;
    }


    @Step("Business Flow: Add Product From Electronics List To Cart")
    public static void addproductfromelectronicslisttocart(String productName) {
        for (int i = 0; i < nopCommercePhonesPage.getList_products().size(); i++) {
            if (nopCommercePhonesPage.getList_products().get(i).findElement(By.xpath(".//h2[@class='product-title']")).getText().equalsIgnoreCase(productName)) {
                UIActions.JSclick(nopCommercePhonesPage.getList_products().get(i).findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/h2/a")));
                if (productName.equalsIgnoreCase("HTC One M8 Android L 5.0 Lollipop")) {
                    UIActions.JSclick(nopCommerceHtcOneM8.getBtn_addToCart());

                }
                else if (productName.equalsIgnoreCase("HTC One Mini Blue")) {
                    UIActions.JSclick(nopCommerceHtcOneMini.getBtn_addToCart());
                }
                break;
            }
            else if (i == nopCommercePhonesPage.getList_products().size() - 1)
                throw new RuntimeException("The Requested Product Does Not Exist in The Shoe Collection");
        }
    }



    @Step("Empty Cart")
    public static void emptyShoppingCart() {
        if (!nopCommerceHeader.getLink_cart().findElement(By.xpath("//span[@class='cart-qty']")).getText().equals("(0)")) {
            UIActions.click(nopCommerceHeader.getLink_cart());
            for (int i = 0; i < nopCommerceCartMain.getList_productsInTheCart().size(); i++) {
                UIActions.JSclick(nopCommerceCartMain.getBtn_remove());
            }
        }
    }

    @Step("Business Flow: Login To SauceDemo with DB Credentials")
    public static void loginDB(String query) {
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(sauceLogin.txt_username, cred.get(0));
        UIActions.updateText(sauceLogin.txt_password, cred.get(1));
        UIActions.click(sauceLogin.btn_login);
    }



}
