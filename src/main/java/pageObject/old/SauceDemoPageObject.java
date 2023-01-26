//package pageObject;
//
//import constantGlobal.Constans;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//public class SauceDemoPageObject {
//    @FindBy(id = Constans.USERNAME)
//    private WebElement inputUserName;
//
//    @FindBy(name = Constans.PASSWORD)
//    private WebElement inputPassword;
//
//    @FindBy(xpath = Constans.BUTTON_LOGIN)
//    private WebElement buttonLogin;
//
//    public WebElement getInputUserName() {
//        return inputUserName;
//    }
//
//    public WebElement getInputPassword() {
//        return inputPassword;
//    }
//
//    public WebElement getButtonLogin() {
//        return buttonLogin;
//    }
//
//    public void givenThatTheUser() {
//        inputUserName.clear();
//        inputUserName.sendKeys("standard_user");
//
//        inputPassword.clear();
//        inputPassword.sendKeys("secret_sauce");
//    }
//
//    public void whenTheUser(){
//        buttonLogin.click();
//    }
//
//}
