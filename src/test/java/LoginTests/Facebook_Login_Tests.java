package LoginTests;

import DataReaders.ReadData;
import Pages.HomePage;
import Pages.LoginPage;
import TestBase.WebTestBase;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Facebook_Login_Tests extends WebTestBase {

    private LoginPage loginPageObj;
    private ReadData rd = new ReadData("src/test/TestData/Facebook_Login_Registration_TestData.xlsx");
    private ArrayList<String> fb_login_credentials_list = new ArrayList<>();
    private HomePage homePageObj;

    @Test(priority = 0)
    public void successfulLoginTest() {
        loginPageObj = new LoginPage(driver);
        fb_login_credentials_list = rd.readFacebookLoginSheet("successfullogin");
        loginPageObj.enterEmail(fb_login_credentials_list.get(0));
        loginPageObj.enterPassword(fb_login_credentials_list.get(1));
        loginPageObj.clickLoginButton();
        homePageObj = new HomePage(driver);
        homePageObj.verifyHomePageIsDisplayed();
        homePageObj.clickAccountIcon();
        homePageObj.clickLogout();
        loginPageObj.verifyLoginPageIsDisplayed();
    }

    @Test(priority = 1)
    public void failedLoginTest()  {
        loginPageObj = new LoginPage(driver);
        fb_login_credentials_list = rd.readFacebookLoginSheet("failedlogin");
        loginPageObj.enterEmail(fb_login_credentials_list.get(0));
        loginPageObj.enterPassword(fb_login_credentials_list.get(1));
        loginPageObj.clickLoginButton();
        loginPageObj.verifyLoginErrorMsgIsDisplayed();
    }
}
