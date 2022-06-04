package PageObjects.NopCommerceWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderApparelMenuPage {

    @FindBy(xpath="//a[@href='/shoes']")
    private WebElement link_shoes;


   @FindBy(xpath="//a[@href='/cell-phones']")
   private WebElement link_phones;


    /*
    #########################################################################
    Methods Names: Getters
    Method Description: This Methods return WebElements of this Page Class.
    Method Parameters: void
    Method Return Type: WebElement
    #########################################################################
     */

    public WebElement getLink_shoes(){
        return link_shoes;
    }


    public WebElement getLink_phones(){
        return link_phones;
    }

}
