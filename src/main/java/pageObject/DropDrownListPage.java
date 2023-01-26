package pageObject;

import constantGlobal.Constans;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropDrownListPage extends Base {

    private By titleAppBuy = By.xpath(Constans.TITLE_APP);
    private By selectDropDown = By.xpath(Constans.SELECT_DROPDOWN);
    private By optionDropDown = By.xpath(Constans.SELECT_DROPDOWN_OPTION);

    public DropDrownListPage(WebDriver driver) {
        super(driver);
    }

    public String givenThatTheUser() {
        String titleApp = "";
        titleApp = getTextLocator(titleAppBuy);
        return titleApp;
    }

    public void whenTheUser(String valueOption) {
        WebElement dropdownList = findElement(selectDropDown);
        List<WebElement> option = dropdownList.findElements(optionDropDown);
        for (int i = 0; i < option.size(); i++) {
            if (getText(option.get(i)).equals(valueOption)) ;
            clickButton(option.get(i));
        }

    }

    public String thenUser() {
        String selectOption = "";
        selectOption = getTextLocator(optionDropDown);
        return selectOption;
    }

}
