package drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class ChromeDriverManager extends DriverManager {
    @Override
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions op=new ChromeOptions();
        op.addArguments("start-maximized");
        driver = new ChromeDriver(op);
    }
}