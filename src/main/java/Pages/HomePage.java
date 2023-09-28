package Pages;

import Base.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObjectBase {

    protected By homePage_welcomeMsgBy = By.xpath("//div[@class='xg87l8a x1iymm2a']");
    protected By homePage_AccountIconBy = By.xpath("(//div[@class='x1rg5ohu x1n2onr6 x3ajldb x1ja2u2z'])[1]");
    protected By logoutButtonBy = By.xpath("(//div[contains(@class, 'x1gg8mnh')])[5]");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyHomePageIsDisplayed(){
        waitForElement(homePage_welcomeMsgBy, 10);
       isElementDisplayed(homePage_welcomeMsgBy);
    }

    public void clickAccountIcon(){
        waitForElement(homePage_AccountIconBy,10);
        ClickOnElementUsingJS(homePage_AccountIconBy);
    }

    public void clickLogout(){
        waitForElement(logoutButtonBy,10);
        ClickOnElementUsingJS(logoutButtonBy);
    }
}
