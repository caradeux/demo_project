package googleSearchOld;
//
//import constantGlobal.Constans;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import pageObject.GooglePageObject;
//import testSetup.TestBase;
//import  static org.testng.AssertJUnit.assertEquals;
//
//public class GoogleSearchTest  extends TestBase {
//    private WebDriver driver;
//
//    @Autowired
//    private GooglePageObject googlePageObject;
//
//    @BeforeClass
//    public  void init(){
//        driver = getWebDriver();
//        googlePageObject = PageFactory.initElements(driver,GooglePageObject.class);
//    }
//    @Test
//    public void google_search_test(){
//        googlePageObject.givenThatTheUser();
//        googlePageObject.whenTheUser();
//        this.waitTitle();
//        assertEquals(Constans.AFTER_SEARCH,driver.getTitle());
//
//    }
//    @AfterClass
//    public  void  afterClass(){
//        driver.close();
//    }
//
//    public void waitTitle (){
//        WebDriverWait waitTitle = new WebDriverWait(driver,10);
//        waitTitle.until(ExpectedConditions.titleContains(Constans.AFTER_SEARCH));
//    }
//
//}
