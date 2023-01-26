//package googleSearch;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import pageObject.SauceDemoPage;
//import pageObject.SauceDemoPageObject;
//import testSetup.TestBase;
//
//import java.time.Duration;
//import java.util.NoSuchElementException;
//import java.util.concurrent.TimeUnit;
//import java.util.function.Function;
//
//import static org.testng.Assert.assertEquals;
//import static org.testng.AssertJUnit.assertTrue;
//
//public class SauceDemoTest  extends TestBase {
//    private WebDriver webDriver;
//
//    @Autowired
//    private  SauceDemoPageObject sauceDemoPageObject;
//    private SauceDemoPage sauceDemoPage;
//
//    private By shoppingCart = By.cssSelector("a[class='shopping_cart_link']");
//
//
//    @BeforeClass
//    public void init (){
//        webDriver = getWebDriver();
//        sauceDemoPageObject = PageFactory.initElements(webDriver,SauceDemoPageObject.class);
//    }
//    @Test
//    public  void sauce_Demo_Login(){
//        sauceDemoPageObject.givenThatTheUser();
//        sauceDemoPageObject.whenTheUser();
//        //implicitas
//      //  webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//
//
//
//        //explicitas
//
//      /*   WebDriverWait expwait = new WebDriverWait(webDriver,10);
//         expwait.until(ExpectedConditions.titleContains("Swag Labs"));
//         assertEquals("Swag Labs",webDriver.getTitle());*/
//
//
//        //fluewait
//
//  Wait<WebDriver> flueWait = new FluentWait<WebDriver>(webDriver)
//          .withTimeout(Duration.ofSeconds(30))
//          .pollingEvery(Duration.ofSeconds(30))
//          .ignoring(NoSuchElementException.class);
//
//   WebElement cart =flueWait.until(new Function<WebDriver, WebElement>() {
//       public WebElement apply(WebDriver webDriver) {
//           return  webDriver.findElement(shoppingCart);
//       }
//   });
//
//
//
//    }
//
//    @AfterClass
//    public  void setSaucw_Demo(){
//        webDriver.close();
//    }
//
//}
