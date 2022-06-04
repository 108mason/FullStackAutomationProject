package PageObjects.NopCommerceWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HtcOneM8Page {


    @FindBy(id = "add-to-cart-button-18")
    private WebElement btn_addToCart;

   /*
    #########################################################################
    Methods Names: Getters
    Method Description: This Methods return WebElements of this Page Class.
    Method Parameters: void
    Method Return Type: WebElement
    #########################################################################
     */

    public WebElement getBtn_addToCart() {
        return btn_addToCart;

    }
}
