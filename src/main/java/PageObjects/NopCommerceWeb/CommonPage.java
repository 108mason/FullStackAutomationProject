package PageObjects.NopCommerceWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPage {
    @FindBy(className="ajax-products-busy")
    private WebElement productContainerAjax;

  /*
    #########################################################################
    Methods Names: Getters
    Method Description: This Methods return WebElements of this Page Class.
    Method Parameters: void
    Method Return Type: WebElement
    #########################################################################
     */

    public WebElement getProductContainerAjax(){
        return productContainerAjax;
    }
}
