package PageObjects.SauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy(how = How.ID, using = "user-name")
    public WebElement txt_username;

    @FindBy(how = How.ID, using = "password")
    public WebElement txt_password;

    @FindBy(how = How.ID, using = "login-button")
    public WebElement btn_login;

    @FindBy(how = How.XPATH, using = "//h3[@data-test='error']")
    public WebElement errorMessage;
}

