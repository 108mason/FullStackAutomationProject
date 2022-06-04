package PageObjects.NopCommerceWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NikeRunningShoesPage {
    @FindBy(id="add-to-cart-button-24")
    private WebElement btn_addToCart;

    @FindBy(id="product_attribute_8_19")
    private WebElement btn_printNatural;


     /*
    #########################################################################
    Methods Names: Getters
    Method Description: This Methods return WebElements of this Page Class.
    Method Parameters: void
    Method Return Type: WebElement
    #########################################################################
     */

    public WebElement getBtn_addToCart(){
        return btn_addToCart;
    }

    public WebElement getBtn_printNatural(){
        return btn_printNatural;
    }
}

