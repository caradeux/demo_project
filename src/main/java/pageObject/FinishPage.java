package pageObject;

import constantGlobal.Constans;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinishPage extends  Base{

    private By titleOverView = By.xpath(Constans.TITLE_OVERVIEW);
    private By buttonFinish = By.id(Constans.BUTTON_FINISH);
    private By titleComplete = By.xpath(Constans.TITLE_COMPLETE);
    private By buttonGoBakHome=By.id(Constans.BUTTON_BACK_HOME);

    public FinishPage (WebDriver driver){
        super(driver);
    }

    public String givenThatUser(){
        String titleApp=getTextLocator(titleOverView);
        return titleApp;
    }

    public void whenTheUser(){
        clickButton(buttonFinish);
    }

    public  String thenUser(){
        String titleApp =getTextLocator(titleComplete);
        return titleApp;
    }

    public void  actionThenUser(){
        clickButton(buttonGoBakHome);
    }

}
