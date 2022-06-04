package PageObjects.NopCommerceWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoesPage {

    @FindBy(id="products-orderby")
    private WebElement select_orderBy;

    @FindBy(xpath="//div[@class='item-box']")
    private List<WebElement> list_products;


   /*
    #########################################################################
    Methods Names: Getters
    Method Description: This Methods return WebElements of this Page Class.
    Method Parameters: void
    Method Return Type: WebElement
    #########################################################################
     */

    public WebElement getSelect_orderBy(){
        return select_orderBy;
    }


    public List<WebElement> getList_products(){
        return list_products;
    }


}
