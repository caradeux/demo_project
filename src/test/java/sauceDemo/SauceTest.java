package sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.*;
import testSetup.TestBase;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;


public class SauceTest extends TestBase {
    private WebDriver webDriver;

    @Autowired
    private SauceDemoPage sauceDemoPage;

    @Autowired
    private MenuPageOption menuPageOption;

    @Autowired
    private DropDrownListPage dropDrownListPage;

    @Autowired
    private SelectItemPage selectItemPage;


    @Autowired
    private CheckoutPage checkoutPage;


    @Autowired
    private CheckoutInformationPage checkoutInformationPage;

    @Autowired
    private FinishPage finishPage;


    @BeforeClass
    public void init() {
        webDriver = getWebDriver();
        sauceDemoPage = PageFactory.initElements(webDriver, SauceDemoPage.class);
        menuPageOption = PageFactory.initElements(webDriver, MenuPageOption.class);
        dropDrownListPage = PageFactory.initElements(webDriver, DropDrownListPage.class);
        selectItemPage = PageFactory.initElements(webDriver, SelectItemPage.class);
        checkoutPage = PageFactory.initElements(webDriver, CheckoutPage.class);
        checkoutInformationPage = PageFactory.initElements(webDriver, CheckoutInformationPage.class);
        finishPage = PageFactory.initElements(webDriver, FinishPage.class);
    }

    @Test
    public void sauce_login() throws InterruptedException {
        sauceDemoPage.givenThatTheUser();
        sauceDemoPage.whenTheUser();
        assertTrue(sauceDemoPage.isExistElement());
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = {"sauce_login"})
    public void about_option() throws InterruptedException {
        menuPageOption.whenTheUser();
        assertTrue(menuPageOption.thenUser());
        Thread.sleep(1000);
        menuPageOption.returnPage();
    }

    @Test(dependsOnMethods = {"about_option"})
    public void sauce_login_new() throws InterruptedException {
        sauceDemoPage.givenThatTheUser();
        sauceDemoPage.whenTheUser();
        assertTrue(sauceDemoPage.isExistElement());
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = {"sauce_login_new"})
    public void select_dropdown() throws InterruptedException {
        String valueDropDown = "Price (low to high)";
        String titleApp = "PRODUCTS";
        assertEquals(dropDrownListPage.givenThatTheUser(), titleApp);
        dropDrownListPage.whenTheUser(valueDropDown);
        assertEquals(dropDrownListPage.thenUser(), valueDropDown);
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = {"select_dropdown"})
    public void select_product_catalog() throws InterruptedException {
        selectItemPage.givenThatUser();
        selectItemPage.whenTheUser();
        selectItemPage.thenUserValue();
        assertEquals(selectItemPage.thenUserValue(), "YOUR CART");
        Thread.sleep(1000);
    }


    @Test(dependsOnMethods = {"select_product_catalog"})
    public void checkout_request() throws InterruptedException {
        assertEquals(checkoutPage.givenTheUser(), "YOUR CART");
        checkoutPage.whenTheUser();
        assertEquals(checkoutPage.theUser(), "CHECKOUT: YOUR INFORMATION");
    }

    @Test(dependsOnMethods = {"checkout_request"})
    public void checkout_information() {
        assertEquals(checkoutInformationPage.givenThatUser(), "CHECKOUT: YOUR INFORMATION");
        checkoutInformationPage.whenThenUser();
        assertEquals(checkoutInformationPage.thenUser(), "CHECKOUT: OVERVIEW");
    }

    @Test(dependsOnMethods = {"checkout_information"})
    public void finish_operation() {
        assertEquals(finishPage.givenThatUser(), "CHECKOUT: OVERVIEW");
        finishPage.whenTheUser();
        assertEquals(finishPage.thenUser(), "CHECKOUT: COMPLETE!");
        finishPage.actionThenUser();
    }

    @AfterClass
    public void sauce_demo_close() {
        webDriver.quit();
    }

}
