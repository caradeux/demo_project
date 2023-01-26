package downloadFile;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static org.testng.Assert.assertTrue;

public class DownloadFileTest {
    private WebDriver driver;
    private String downloadFilePath = "C:\\Users\\hysca\\eclipse-workspace\\DowloadFile";

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","./src/test/resources/driver/chromedriver");
        HashMap<String , Object> chromePrefs = new HashMap<String , Object>();
        chromePrefs.put("profile.default_content_settings.popup",0);
        chromePrefs.put("download.default_directory", downloadFilePath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        driver = new ChromeDriver(options);

    }

    @Test
    public void dpwnpadfile() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.cssSelector("div.example>a")).click();
        Thread.sleep(2000);

        File folder = new File(downloadFilePath);
        File [] listFiles = folder.listFiles();
        assertTrue(listFiles.length >0 , "File not download correctly");
    }


    @AfterClass
    public void afterClass() {
        driver.close();
    }

}
