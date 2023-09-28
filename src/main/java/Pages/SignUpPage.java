package Pages;

import Base.PageObjectBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SignUpPage extends PageObjectBase {

    private JavascriptExecutor executor;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterFirstName(String firstname){
       executor = (JavascriptExecutor)driver;
       var javascript = "document.getElementsByName('firstname')[0];";
       var firstNameTxtField = executor.executeScript(javascript);
       enterText((WebElement) firstNameTxtField,firstname);
    }
    public void enterLastName(String lastname){
        executor = (JavascriptExecutor)driver;
        var javascript = "document.getElementsByName('lastname')[0];";
        var lastNameTxtField = executor.executeScript(javascript);
        enterText((WebElement) lastNameTxtField,lastname);
    }

    public void enterEmailAddress(String email){
        executor = (JavascriptExecutor)driver;
        var javascript = "document.getElementsByName('reg_email__')[0];";
        var emailAddressTxtField = executor.executeScript(javascript);
        enterText((WebElement) emailAddressTxtField,email);
    }

    public void reEnterEmailAddress(String emailConfirmation){
        executor = (JavascriptExecutor)driver;
        var javascript = "document.getElementsByName('reg_email_confirmation__')[0];";
        var reEnterEmailAddressTxtField = executor.executeScript(javascript);
        enterText((WebElement) reEnterEmailAddressTxtField,emailConfirmation);
    }

    public void enterPassword(String password){
        executor = (JavascriptExecutor)driver;
        var javascript = "document.getElementsByName('reg_passwd__')[0];";
        var passwordTxtField = executor.executeScript(javascript);
        enterText((WebElement) passwordTxtField,password);
    }

    public void selectFromDayDropDown(String value){
        Select dayDropDown;
        executor = (JavascriptExecutor)driver;
        var javascript = "document.getElementByID('day');";
        dayDropDown = new Select((WebElement)executor.executeScript(javascript));
        dayDropDown.selectByValue(value);
    }
    public void selectFromMonthDropDown(String visibleText){
        Select monthDropDown;
        executor = (JavascriptExecutor)driver;
        var javascript = "document.getElementByID('month');";
        monthDropDown = new Select((WebElement)executor.executeScript(javascript));
        monthDropDown.selectByVisibleText(visibleText);
    }

    public void selectFromYearDropDown(String visibleText){
        Select yearDropDown;
        executor = (JavascriptExecutor)driver;
        var javascript = "document.getElementByID('year');";
        yearDropDown = new Select((WebElement)executor.executeScript(javascript));
        yearDropDown.selectByVisibleText(visibleText);
    }

    public  void selectMaleGender(){
        executor = (JavascriptExecutor)driver;
        var javascript = "document.getElementsByClassName('._8esa')[1];";
        WebElement maleRadioButton = (WebElement)executor.executeScript(javascript);
        ClickOnElement(maleRadioButton);
    }

    public HomePage clickSignUpButton(){
        executor = (JavascriptExecutor) driver;
        var javascript = "document.getElementsByName('websubmit')[0];";
        WebElement signUpButton = (WebElement)executor.executeScript(javascript);
        ClickOnElement(signUpButton);
        return new HomePage(driver);
    }
}

