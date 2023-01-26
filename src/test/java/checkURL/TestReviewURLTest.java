package checkURL;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TestReviewURLTest {
    private WebDriver driver;
    private CheckLinkPage page;

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new CheckLinkPage(driver);
        driver.get("https://eldeber.com.bo");
    }

    @Test
    public void checkPageURL() {

        assertTrue(page.checkingPageLinnks(), "There are Broken links");
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

}
