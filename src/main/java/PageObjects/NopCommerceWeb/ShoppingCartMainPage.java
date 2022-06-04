package PageObjects.NopCommerceWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartMainPage {


    @FindBy(xpath="//table[@class='cart']/tbody/tr")
    private List<WebElement> list_productsInTheCart;

    @FindBy(className="remove-btn")
    private WebElement btn_remove;


    public WebElement getBtn_remove(){
        return btn_remove;
    }


  /*
    #########################################################################
    Methods Names: Getters
    Method Description: This Methods return WebElements of this Page Class.
    Method Parameters: void
    Method Return Type: WebElement
    #########################################################################
     */

    public List<WebElement> getList_productsInTheCart(){
        return list_productsInTheCart;
    }
}
