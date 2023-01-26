package screanshot;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreanshotAppTest {


    private WebDriver driver ;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","./src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();

       // System.setProperty("webdriver.gecko.driver","./src/test/resources/driver/geckodriver.exe");
       // driver = new FirefoxDriver();

        //System.setProperty("webdriver.edge.driver","./src/test/resources/driver/msedgedriver.exe");
       // driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

    }

    @Test
    public void test() {

        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
    }

    @After
    public void tearDown() throws Exception {
        //	driver.close();
    }

    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable throwable, Description description) {
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {

                FileUtils.copyFile(screenshotFile, new File("erro_test_"+description.getMethodName()+getDate()+".png"));
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        }

        @Override
        protected void finished(Description description) {
            driver.quit();
        }

    };


    public String getDate() {
        DateFormat dateformat = new SimpleDateFormat("dd-MM-yy");
        Date date = new Date();
        return dateformat.format(date);
    }


}
