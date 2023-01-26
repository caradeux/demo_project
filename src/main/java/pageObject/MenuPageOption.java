package pageObject;

import constantGlobal.Constans;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPageOption extends Base {

    private By shoppingCart = By.cssSelector(Constans.SHOPPING_CART);
    private By burgerButton = By.id(Constans.BURGER_BUTTON);
    private By aboutOptionButton = By.id(Constans.SIDEBAR_BUTTON_OPTION);
    private By logoPageWeb = By.xpath(Constans.LOGO_PAGE_WEB);

    public MenuPageOption(WebDriver driver) {
        super(driver);
    }

    public boolean givenThatTheUser() {
        return isDisplayed(shoppingCart);
    }

    public void whenTheUser() throws InterruptedException {
        clickButton(burgerButton);
        Thread.sleep(1000);
        clickButton(aboutOptionButton);
    }

    public boolean thenUser() {
        return isExistElement(logoPageWeb);
    }

    public  void  returnLastView(){
        returnPage();
    }

}
