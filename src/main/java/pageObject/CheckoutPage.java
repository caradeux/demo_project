package pageObject;

import constantGlobal.Constans;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends Base{

     private By titleCheckout = By.xpath(Constans.TITLE_CHECKOUT);
     private By buttonCheckout = By.id(Constans.CHECKOUT_BUTTON);
     private By titleInformation =By.xpath(Constans.TITLE_INFORMATION);

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    public String givenTheUser(){
        String titleApp ="";
        titleApp = getTextLocator(titleCheckout);
        return titleApp;
    }

    public void  whenTheUser(){
        clickButton(buttonCheckout);
    }

    public String theUser(){
        String titleApp = "";
        titleApp = getTextLocator(titleInformation);
        return  titleApp;
    }
}
