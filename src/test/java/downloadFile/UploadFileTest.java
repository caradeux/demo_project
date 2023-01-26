package downloadFile;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class UploadFileTest {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","./src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void uploadfile() throws InterruptedException {

        File file = new File("C:\\Users\\hysca\\eclipse-workspace\\DowloadFile\\test.txt");
        String path = file.getAbsolutePath();

        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys((path));
        driver.findElement(By.id("file-submit")).click();

        String text = driver.findElement(By.id("uploaded-files")).getText();

        assertEquals("test.txt", text);
    }


    @AfterClass
    public void afterClass() {
        //  driver.close();
    }
}
