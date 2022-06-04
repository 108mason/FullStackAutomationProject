package PageObjects.NopCommerceWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {

    @FindBy(id="gender-male")
    private WebElement btn_male;

    @FindBy (id="gender-female")
    private WebElement btn_female;

    @FindBy (id="FirstName")
    private WebElement txt_firstName;

    @FindBy (id="LastName")
    private WebElement txt_lastName;

    @FindBy (name="DateOfBirthDay")
    private WebElement select_dayOfBirth;

    @FindBy (name="DateOfBirthMonth")
    private WebElement select_monthOfBirth;

    @FindBy (name="DateOfBirthYear")
    private WebElement select_yearOfBirth;

    @FindBy (id="Email")
    private WebElement txt_email;

    @FindBy (id="Company")
    private WebElement txt_company;

    @FindBy (id="Newsletter")
    private WebElement btn_newsLetter;

    @FindBy (id="Password")
    private WebElement txt_pass;

    @FindBy (id="ConfirmPassword")
    private WebElement txt_confirmPass;

    @FindBy (id="register-button")
    private WebElement btn_register;

    @FindBy (xpath="//div[@class='page registration-result-page']/div[@class='page-body']/div[@class='result']")
    private WebElement txt_registerConfirmation;

   /*
    #########################################################################
    Methods Names: Getters
    Method Description: This Methods return WebElements of this Page Class.
    Method Parameters: void
    Method Return Type: WebElement
    #########################################################################
     */

    public WebElement getBtn_male(){
        return btn_male;
    }

    public WebElement getBtn_female(){
        return btn_female;
    }

    public WebElement getTxt_firstName(){
        return txt_firstName;
    }

    public WebElement getTxt_lastName(){
        return txt_lastName;
    }

    public WebElement getSelect_dayOfBirth(){
        return select_dayOfBirth;
    }

    public WebElement getSelect_monthOfBirth(){
        return select_monthOfBirth;
    }

    public WebElement getSelect_yearOfBirth(){
        return select_yearOfBirth;
    }

    public WebElement getTxt_email(){
        return txt_email;
    }

    public WebElement getTxt_company(){
        return txt_company;
    }

    public WebElement getBtn_newsLetter(){
        return btn_newsLetter;
    }

    public WebElement getTxt_pass(){
        return txt_pass;
    }

    public WebElement getTxt_confirmPass(){
        return txt_confirmPass;
    }

    public WebElement getBtn_register(){
        return btn_register;
    }

    public WebElement getTxt_registerConfirmation(){
        return txt_registerConfirmation;
    }

}
