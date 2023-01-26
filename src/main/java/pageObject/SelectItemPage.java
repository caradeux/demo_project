package pageObject;

import constantGlobal.Constans;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectItemPage  extends  Base{

    private By firstProduct = By.id(Constans.FIRST_PRODUCT);
    private By secondProduct = By.id(Constans.SECOND_PRODUCT);
    private By threeProduct = By.id(Constans.THREE_PRODUCT);
    private By iconShopping = By.id(Constans.ICON_SHOPPING);
    private By shoppingCartBadgeButton =By.xpath(Constans.SHOPPING_CART_BADGE);
    private By titleShoppingCart = By.xpath(Constans.TITLE_SHOPPING);

    public SelectItemPage(WebDriver driver) {
        super(driver);
    }

    public boolean givenThatUser(){
        return isDisplayed(iconShopping);
    }

    public void  whenTheUser(){
        clickButton(firstProduct);
        clickButton(secondProduct);
        clickButton(threeProduct);
        clickButton(shoppingCartBadgeButton);
    }

    public String   thenUserValue(){
        String titleApp= "";
        titleApp  = getTextLocator(titleShoppingCart);
        return titleApp;
    }

}
