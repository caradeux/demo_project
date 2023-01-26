package downloadFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CheckDownloadFileTest {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","./src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/download");
    }

    @Test
    public void downloadFile() throws MalformedURLException, IOException {
        String link = driver.findElement(By.cssSelector("div.example>a")).getAttribute("href");
        HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(link).openConnection());
        httpURLConnection.setRequestMethod("HEAD");
        httpURLConnection.connect();

        String contenType = httpURLConnection.getContentType();
        int contentLength = httpURLConnection.getContentLength();

        System.out.println("content Type" + contenType);

//	assertEquals(contenType , "application/octet-stream");
        assertEquals(contenType , "image/jpeg");
        assertNotEquals(contentLength,0);
    }


    @AfterClass
    public void afterClass() {
        driver.close();
    }

}
