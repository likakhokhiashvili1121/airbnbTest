package drivermanager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    WebDriver driver;
    public abstract void setDriver();
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    public WebDriver getDriver(){
        if(driver==null){
            setDriver();
        }
        return driver;

    }
}
