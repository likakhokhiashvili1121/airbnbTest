package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait driverWait;
    int waitTime = 5;
    int numRetries = 3;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String updateXpathValue(String xpath, String value) {
        return xpath.replace("$$", value);
    }

    public boolean elementExistsByXpath(String xpath) {
        return !driver.findElements(By.xpath(xpath)).isEmpty();
    }

    public void setAttribute(WebElement element, String attr, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "value", value);
    }

    public void selectByValue(WebElement element, String value, String log) throws Exception {
        try {
            new Select(element).selectByValue(value);
            System.out.println(getCurrentTimeDate() + " Selected: " + value + " " + log);
        } catch (Exception e) {
            handleRetryException(e, "Failed to select: " + value + " " + log);
        }
    }

    public void typeText(WebElement element, String text, String log) throws Exception {
        try {
            new Actions(driver).moveToElement(element).perform();
            element.click();
            element.clear();
            element.sendKeys(text);
            System.out.println(getCurrentTimeDate() + " Clicked and Typed: " + log);
        } catch (Exception e) {
            handleRetryException(e, "Failed to type '" + text + "' into: " + log);
        }
    }

    public String getText(WebElement element, String log) throws Exception {
        try {
            return element.getText();
        } catch (Exception e) {
            return handleRetryException(e, "Failed to get text: " + log);
        }
    }

    public void click(WebElement element, String log) throws Exception {
        try {
            new Actions(driver).moveToElement(element).click().perform();
            System.out.println(getCurrentTimeDate() + " Clicked: " + log);
        } catch (Exception e) {
            handleRetryException(e, "Failed to click on: " + log);
        }
    }

    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
    }

    private String handleRetryException(Exception e, String errorMessage) throws Exception {
        for (int retryCount = 1; retryCount <= numRetries; retryCount++) {
            System.out.println("Retry: " + retryCount + " - " + errorMessage);
            if (retryCount == numRetries) {
                e.printStackTrace();
                throw new Exception(getCurrentTimeDate() + " " + errorMessage);
            }
        }
        return "";
    }

    public String getCurrentTimeDate() {
        return "[" + java.time.LocalTime.now() + "]";
    }
}
