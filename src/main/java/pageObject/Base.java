package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Base {
    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getTextLocator(By locator) {
        return driver.findElement(locator).getText();
    }

    public void insertValue(By locator, String inputText) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void clickButton(By locator) {
        driver.findElement(locator).click();
    }

    public void clickButton(WebElement element) {
        element.click();
    }

    public void clearInput(WebElement element){
        element.clear();
    }

    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchContextException e) {
            return false;
        }
    }


    public Boolean isExistElement(By locator) {
        if (driver.findElements(locator).size() != 0) {
            return driver.findElements(locator).size() != 0;
        } else {
            return false;
        }
    }

    public void visitUrl(String url) {
        driver.get(url);
    }

   public void returnPage(){
        driver.navigate().to("https://www.saucedemo.com/");
   }

}
