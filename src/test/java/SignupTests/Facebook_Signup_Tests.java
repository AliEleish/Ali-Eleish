package SignupTests;

import DataReaders.ReadData;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;
import TestBase.WebTestBase;
import org.testng.annotations.Test;

import java.util.List;

public class Facebook_Signup_Tests extends WebTestBase {

    private LoginPage loginPageObj;
    private SignUpPage signupPageObj;
    private ReadData rd = new ReadData("src/test/TestData/Facebook_Login_Registration_TestData.xlsx");
    private HomePage homePageObj;

    @Test
    public void successfulSignupTest(){
        loginPageObj = new LoginPage(driver);
        signupPageObj  = loginPageObj.clickCreateNewAccountButton();
        List<String> registration_Credentials_List = rd.readFacebookSignUpSheet();
        signupPageObj.enterFirstName(registration_Credentials_List.get(0));
        signupPageObj.enterLastName(registration_Credentials_List.get(1));
        signupPageObj.enterEmailAddress(registration_Credentials_List.get(2));
        signupPageObj.reEnterEmailAddress(registration_Credentials_List.get(3));
        signupPageObj.enterPassword(registration_Credentials_List.get(4));
        signupPageObj.selectFromDayDropDown(registration_Credentials_List.get(5));
        signupPageObj.selectFromMonthDropDown(registration_Credentials_List.get(6));
        signupPageObj.selectFromYearDropDown(registration_Credentials_List.get(7));
        signupPageObj.selectMaleGender();
        homePageObj = signupPageObj.clickSignUpButton();
        homePageObj.verifyHomePageIsDisplayed();
    }
}
