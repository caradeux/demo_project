package pageObject;

import constantGlobal.Constans;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage  extends Base{

    private By firstName = By.id(Constans.FIRST_NAME);
    private By lastName = By.id(Constans.LAST_NAME);
    private By postalCode =By.id(Constans.POSTAL_CODE);
    private By buttonContinue =By.id(Constans.BUTTON_CONTINUE_PERSONAL_INFORMATION);
    private By titleOverview = By.xpath(Constans.TITLE_OVERVIEW);
    private By titlePersonalInformation = By.xpath(Constans.TITLE_INFORMATION);

    public CheckoutInformationPage(WebDriver driver){
        super(driver);
    }

     public String givenThatUser(){
        String titleApp = getTextLocator(titlePersonalInformation);
        return titleApp;
     }

     public void whenThenUser(){
        insertValue(firstName,"Test Automation");
        insertValue(lastName, "Selenium Webdriver");
        insertValue(postalCode, "0000");
        clickButton(buttonContinue);
     }

     public  String thenUser(){
        String titleApp =getTextLocator(titleOverview);
        return titleApp;
     }


}
