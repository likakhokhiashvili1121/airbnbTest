package drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxDriverManager extends DriverManager{
    @Override
    public void setDriver(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions op=new FirefoxOptions();
        op.addArguments("start-maximized");
        driver=new FirefoxDriver(op);
    }
}