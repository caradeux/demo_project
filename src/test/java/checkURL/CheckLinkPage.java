package checkURL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CheckLinkPage {
    private WebDriver driver;

    public CheckLinkPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkingPageLinnks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        String url = "";
        List<String> brokenLinks = new ArrayList<String>();
        List<String> okLinks = new ArrayList<String>();

        HttpURLConnection httpConnection = null;
        int responseCode = 200;
        Iterator<WebElement> it = links.iterator();

        while (it.hasNext()) {
            url = it.next().getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println(url + "url is not configured  or it is empty");
                continue;
            }
            try {
                httpConnection = (HttpURLConnection) (new URL(url).openConnection());
                httpConnection.setRequestMethod("HEAD");
                httpConnection.connect();
                responseCode = httpConnection.getResponseCode();

                if (responseCode > 400) {
                    System.out.println("ERROR BROKEN LINK: ---" + url);
                    brokenLinks.add(url);
                } else {
                    System.out.println("VALID LINK: ---" + url);
                    okLinks.add(url);
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

        System.out.println("valid links: ---" + okLinks.size());
        System.out.println("Invalid links: ---" + brokenLinks.size());

        if (brokenLinks.size() > 0) {
            System.out.println("***** ERROR ------- broken links");
            for (int i = 0; i < brokenLinks.size(); i++) {
                System.out.println(brokenLinks.get(i));
            }
            return false;

        } else {
            return true;
        }
    }
}
