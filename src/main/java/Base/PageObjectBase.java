package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PageObjectBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor executor;

    protected void enterText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
    protected void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void ClickOnElement(By locator) {
        driver.findElement(locator).click();
    }

    protected void ClickOnElement(WebElement element) {
       element.click();
    }

    protected void ClickOnElementUsingJS(By locator) {
        WebElement element = driver.findElement(locator);
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected void isElementDisplayed(By locator) {
        try {
            Assert.assertTrue(driver.findElement(locator).isDisplayed());
        } catch (Exception e) {
            System.out.println("Error!, The Element is not displayed");
        }
    }

    protected void waitForElement(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    protected void waitForElement(WebElement element, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

