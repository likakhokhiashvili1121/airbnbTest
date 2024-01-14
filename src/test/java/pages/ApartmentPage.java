package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class ApartmentPage extends  BasePage{
    public ApartmentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    String apartmentListContainer="//div[@data-testid='card-container']";
    String ratedApartment="//div[@data-plugin-in-point-id='TITLE_DEFAULT']//button[contains(@aria-label,'Rated')]";
    String ratedData="//div[@role='dialog']//h2";
    public String[] apartmentReviews() throws InterruptedException {
        List<WebElement> apartmentList = driver.findElements(By.xpath(apartmentListContainer));
        String[] ratereviews=new String[2];
        if (apartmentList.size() > 0) {
            apartmentList.get(2).click();
            Thread.sleep(5000);
            Set<String> handles = driver.getWindowHandles();
            for (String actual : handles) {
                if (!actual.equalsIgnoreCase(driver.getWindowHandle())) {
                    driver.switchTo().window(actual);
                }
            }
            if (driver.findElement(By.xpath(ratedApartment)) != null) {
                driver.findElement(By.xpath(ratedApartment)).click();
                String rate = driver.findElement(By.xpath(ratedData)).getText();
                ratereviews = rate.split("·");
                System.out.println("The selected stay has " + ratereviews[0] + " star rate and " + ratereviews[1] + " reviews.");
            }
        }
        return ratereviews;
    }
}