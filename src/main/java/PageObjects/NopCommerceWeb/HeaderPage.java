package PageObjects.NopCommerceWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage {

    @FindBy(className="ico-register")
    private WebElement link_register;

    @FindBy(className="ico-cart")
    private WebElement link_cart;

    @FindBy(xpath="//a[@href='/electronics']")
    private WebElement link_electronics;

    @FindBy(xpath="//a[@href='/apparel']")
    private WebElement link_apparel;

  /*
 #########################################################################
 Methods Names: Getters
 Method Description: This Methods return WebElements of this Page Class.
 Method Parameters: void
 Method Return Type: WebElement
 #########################################################################
  */

    public WebElement getLink_register(){
        return link_register;
    }

    public WebElement getLink_cart(){
        return link_cart;
    }


    public WebElement getLink_electronics(){
        return link_electronics;
    }

    public WebElement getLink_apparel(){
        return link_apparel;
    }



}
