package Utilities;


import PageObjects.Calculator.MainPage;
import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {

    //--------{ General }--------

    protected static WebDriverWait wait;;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    public static String Platform;

    //--------{ Web }--------
    public static WebDriver driver;



    protected static PageObjects.NopCommerceWeb.HtcOneM8Page nopCommerceHtcOneM8;
    protected static PageObjects.NopCommerceWeb.HtcOneMiniPage nopCommerceHtcOneMini;
    protected static PageObjects.NopCommerceWeb.PhonesPage nopCommercePhonesPage;

    protected static PageObjects.NopCommerceWeb.FooterPage nopCommerceFooter;
    protected static PageObjects.NopCommerceWeb.RegisterPage nopCommerceRegister;
    protected static PageObjects.NopCommerceWeb.HeaderPage nopCommerceHeader;
    protected static PageObjects.NopCommerceWeb.HeaderApparelMenuPage nopCommerceHeaderApparelMenu;
    protected static PageObjects.NopCommerceWeb.ShoesPage nopCommerceShoes;
    protected static PageObjects.NopCommerceWeb.CommonPage nopCommerceCommon;
    protected static PageObjects.NopCommerceWeb.ShoppingCartMainPage nopCommerceCartMain;
    protected static PageObjects.NopCommerceWeb.NikeRunningShoesPage nopCommerceNikeRunningShoes;

    //--------{ Web - SauceDemo - DB }--------
    protected static PageObjects.SauceDemo.LoginPage sauceLogin;

    //--------{ Mobile }--------
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();
    protected static PageObjects.Mortgage.MainPage mortgageMain;


    //--------{ RestAPI }--------
    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject params = new JSONObject();
    public static JsonPath jp;

    //--------{ Electron Application }--------
   protected static ChromeOptions opt;
   protected static PageObjects.todo.MainPage todoListMain;

    //--------{ Desktop Application }--------
    public static PageObjects.Calculator.MainPage calcMain;


    //--------{ configuration of Data Base - eMySql}--------
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
}
