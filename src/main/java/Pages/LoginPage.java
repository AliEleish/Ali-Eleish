package Pages;

import Base.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageObjectBase {

    private By emailAddressBy =By.id("email");
    private By passwordBy =By.id("pass");
    private By loginButtonBy =By.xpath("//button[@name='login']");
    private By loginErrorMsg1By = By.xpath("//div[@class='_9ay7']");
    private By loginErrorMsg2By = By.xpath("//div[@class='_aklw']");
    private By createNewAccountBtnBy = By.xpath("//a[contains(@id,'u_0_0')]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterEmail(String email){
        enterText(emailAddressBy, email);
    }

    public void enterPassword(String pass){
        enterText(passwordBy, pass);
    }

    public void clickLoginButton(){
        ClickOnElement(loginButtonBy);
    }

    public void verifyLoginPageIsDisplayed(){
        waitForElement(emailAddressBy,10);
        isElementDisplayed(emailAddressBy);
    }

    public void verifyLoginErrorMsgIsDisplayed(){
        try{
        waitForElement(loginErrorMsg1By,10);
        isElementDisplayed(loginErrorMsg1By);
    }catch(Exception e){
            waitForElement(loginErrorMsg2By,10);
            isElementDisplayed(loginErrorMsg2By);
        }
    }

    public SignUpPage clickCreateNewAccountButton(){
        ClickOnElementUsingJS(createNewAccountBtnBy);
        return new SignUpPage(driver);
    }
}
