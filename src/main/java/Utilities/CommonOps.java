package Utilities;

import WorkFlows.desktopFlows;
import WorkFlows.electronFlows;
import WorkFlows.mobileFlows;
import WorkFlows.webFlows;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    /*
  #################################################
     * get data from the xml configuration file
     * parameter: nodeName - node from the xml file
     * return: requested data in form of a String
####################################################
     */

    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

       /*
  ################################################################################
    Method name: initBrowser
    Method description: This method performs the following actions:
                        - initiates driver according to browser type
                        - maximizes browser window
                        - sets implicitly wait time (timeout) configured in XML file
                        - navigates to web site configured in XML file
                        - creates object action from class Actions by constructor. Driver that was initiate with
                          ChromeDriver is sent to this constructor.
    Method parameter: String browserType - Name of browser to test
    Method return: none
################################################################################
     */

    public void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid Browser Type");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.get(getData("urlWeb"));
        ManagePages.initWeb();
        action = new Actions(driver);
    }
    /*
################################################################################
Method Name: initChromeDriver
Method Description: This Method Sets Up System Property of Updated ChromeDriver
Method Parameters: void
Method Return Type: WebDriver
################################################################################
 */
    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    /*
    ##################################################################################
    Method Name: initFirefoxDriver
    Method Description: This Method Sets Up System Property of Updated FirefoxDriver
    Method Parameters: void
    Method Return Type: WebDriver
    ##################################################################################
     */
    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    /*
    ###########################################################################################
    Method Name: initIEDriver
    Method Description: This Method Sets Up System Property of Updated InternetExplorerDriver
    Method Parameters: void
    Method Return Type: WebDriver
    ###########################################################################################
     */
    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    /*
    ################################################################################################
    Method Name: initMobile
    Method Description: This Method Initializes the Driver with desired Mobile Platform Driver.
                        Configures Objects and Parameters needed and launches the defined Mobile
                        Application.
    Method Parameters: String
    Method Return Type: void
    ################################################################################################
     */

    @Step("Initializing Mobile Platform")
    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        try {
            mobileDriver = new AppiumDriver(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Can not Connect to Appium Server, See Details: " + e);
        }
        ManagePages.initMortgage();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
      action = new Actions(mobileDriver);
    }

    /*
    ##########################################################################################
    Method Name: initAPI
    Method Description: This Method Connects to defined Server and Initializes API Objects.
    Method Parameters: void
    Method Return Type: void
    ##########################################################################################
     */

    @Step("Initializing API Platform")
    public static void initAPI() {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given();
//                .auth().preemptive().basic(getData("api-user"), getData("api-pass"));
    }

    /*
    #############################################################################################
    Method Name: initElectron
    Method Description: This Method Initializes the Electron Driver. Configures
                        Objects and Parameters needed and launches the Electron Application.
    Method Parameters: void
    Method Return Type: void
    #############################################################################################
     */

    @Step("Initializing Electron Platform")
    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initTodoList();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);
    }

    /*
  #############################################################################################
  Method Name: initDesktop
  Method Description: This Method Initializes the Windows Driver. Configures
                      Objects and Parameters needed and launches the Desktop Application.
  Method Parameters: void
  Method Return Type: void
  #############################################################################################
   */

    @Step("Initializing Desktop Platform")
    public static void initDesktop() {
        dc = new DesiredCapabilities();
        dc.setCapability("app", getData("DesktopAppPath"));
        try {
           driver = new WindowsDriver(new URL (getData("AppiumServerDesktop")),dc); // Line needs to be remarked while testing Mobile Apps
        } catch (Exception e) {
            System.out.println("Can not connect to Appium Server, see details: " + e);
        }

        ManagePages.initCalculator();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);


    }


    /*
    ################################################################################################
    Method Name: startSession
    Method Description: This Method receives the Platform Name from TestNG Suite and passes the
                        Platform to relevant method.
                        Initializes Objects needed and opens DB connection with given Parameters.
    Method Parameters: String (Using @Parameters)
    Method Return Type: void
    ################################################################################################
     */

    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) {
        Platform = PlatformName;

        if (Platform.equalsIgnoreCase("web")) {
            initBrowser(getData("BrowserName"));
        } else if (Platform.equalsIgnoreCase("DB")) {
            initBrowser(getData("BrowserName"));
        } else if (Platform.equalsIgnoreCase("mobile")) {
            initMobile();
        } else if (Platform.equalsIgnoreCase("api")) {
            initAPI();
        } else if (Platform.equalsIgnoreCase("electron")) {
            initElectron();
        } else if (Platform.equalsIgnoreCase("desktop")) {
            initDesktop();
        } else
            throw new RuntimeException("Invalid Platform Name");

        ManageDB.openConnection(getData("dbURL"), getData("dbUser"), getData("dbPass"));

    }

    @AfterClass
    public void afterSession() {
        ManageDB.closeConnection();
        if (!Platform.equalsIgnoreCase("api")) {
            if (!Platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();

        }

    }

    /*
    ##################################################################
    Method Name: closeSession
    Method Description: This Method closes Connection to DB and AUT.
    Method Parameters: void
    Method Return Type: void
    ##################################################################
     */

        @BeforeMethod
        public void beforeMethod (Method method){
            if (!Platform.equalsIgnoreCase("api")) {
                try {
                    MonteScreenRecorder.startRecord(method.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    /*
    ###############################################################################
    Method Name: afterMethodProcedures
    Method Description: This Method preforms after method actions at the end of
                        each Test of AUT.
    Method Parameters: void
    Method Return Type: void
    ###############################################################################
     */

        @AfterMethod
        public void afterMethodProcedures () {
            if (Platform.equalsIgnoreCase("web")) {
                webFlows.emptyShoppingCart();
                driver.get(getData("urlWeb"));
            } else if (Platform.equalsIgnoreCase("electron")) {
                electronFlows.emptyList();
                electronFlows.chooseNoTagAndCloseTagMenu();
            } else if (Platform.equalsIgnoreCase("desktop"))
                desktopFlows.clickOnClearButton();
        else if (Platform.equalsIgnoreCase("mobile"))
             mobileFlows.clearTextFields();

        }

    }



