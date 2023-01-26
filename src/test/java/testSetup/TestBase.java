package testSetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

@Listeners(ExtentTestNGITestListener.class)
public class TestBase {
    private WebDriver driver;
    private Properties props;
    private String appURL;
    private String browserType;

    private void loadProperties(){
        props = new Properties();
        InputStream input=getClass().getResourceAsStream("/automation.properties");

        try{
            props.load(input);
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            if (input!=null){
                try{
                    input.close();
                }   catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    @BeforeSuite
    public void intSuite(){
        loadProperties();
        appURL = props.getProperty("ServerPath");
        browserType = props.getProperty("Browser");
        setDriver(browserType,appURL);
    }

    public WebDriver getWebDriver(){
        return driver;
    }

    private void setDriver(String browserType, String appURL){
        if(driver == null){
            if(browserType.equals("chrome")){
                driver=initChromeDriver(appURL);
            }
            /*else if (browserType.equals("firefox")){
                driver=initFirefoxDriver(appURL);
            }
            */
            else {
                driver = initIExplorer(appURL);
            }
        }else{
            driver.get(appURL);
        }
    }

    private WebDriver initIExplorer(String appURL) {
        return driver;
    }

    private WebDriver initChromeDriver(String appURL) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(appURL);
        return driver;
    }

    public void tearDown(){
        if (driver !=null){
            driver.quit();
        }
    }


}
