package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class AnywhereStaysPage extends BasePage {
    public AnywhereStaysPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="//div[@data-testid='little-search']//button//div[text()='Anywhere']")
    WebElement anywhereButton;
    String regionField ="//div[@id='locationInspirationsSectionID']//span[text()='$$']//parent::label";
    @FindBy(xpath ="//button[@aria-label='Move forward to switch to the next month.']")
    WebElement nextArrowCalendar;
    String date = "//div[@data-testid='calendar-day-$$']";
    @FindBy(xpath = "//div[@aria-label='Calendar']")
    List<WebElement> calendar;
    @FindBy(xpath = "//div[@data-testid='structured-search-input-field-split-dates-0']")
    WebElement dateInput;
    @FindBy(css = "[id='bigsearch-query-location-input']")
    WebElement locationInput;
    String destinationLocation1 = "//div[@id='bigsearch-query-location-suggestion-0']//div[text()='$$']";
    String destinationLocation2 = "//div[@id='bigsearch-query-location-suggestion-1']//div[text()='$$']";
    @FindBy (xpath="//div[@data-testid='structured-search-input-field-guests-button']")
    WebElement guestsInput;
    @FindBy(xpath = "//button[@data-testid='stepper-adults-increase-button']")
    WebElement adultsAdd;
    @FindBy(xpath = "//button[@data-testid='stepper-children-increase-button']")
    WebElement childrenAdd;
    @FindBy(xpath = "//button[@data-testid='stepper-infants-increase-button']")
    WebElement infantsAdd;
    @FindBy(xpath = "//button[@data-testid='stepper-pets-increase-button']")
    WebElement petsAdd;
    @FindBy(xpath = "//button[@data-testid='structured-search-input-search-button']")
    WebElement searchButton;
    @FindBy(css = "[id='tab--tabs--1']")
    WebElement flexDates;
    String flexWeekEnd = "label[id='flexible_trip_lengths-weekend_trip']";
    String flexWeek = "label[id='flexible_trip_lengths-one_week']";
    String flexMonth = "label[id='flexible_trip_lengths-one_month']";
    String flexMonthSelect = "//div[@id='flexible_trip_dates-$$']";
    @FindBy(xpath ="//button[@aria-label='Next']")
    WebElement nextArrowFlexCalendar;
    @FindBy(xpath ="//button[@aria-label='Previous']")
    WebElement previousArrowFlexCalendar;
    public void selectRegion(String region) throws Exception {
        click(anywhereButton);
        click(driver.findElement(By.xpath(updateXpathValue(regionField, region))));
    }
    public void setRegionLocation(String region, String location) throws Exception {
        if(region!=null || !(region.isEmpty())) {
            selectRegion(region);
        }
        else if(location!=null || !(location.isEmpty())) {
            enterLocation(location);
            selectRecommendedLocation(location);
        }
    }
    public void enterLocation(String location) throws Exception {
        typeText(locationInput, location, "Location Input");
        Thread.sleep(1000);
    }
    public void selectRecommendedLocation(String location) throws Exception {
        if (elementExistsByXpath(updateXpathValue(destinationLocation1, location))) {
            click(driver.findElement(By.xpath(updateXpathValue(destinationLocation1, location))), "Location Recommendation 1 - " + location);
        } else {
            click(driver.findElement(By.xpath(updateXpathValue(destinationLocation2, location))), "Location Recommendation 2 - " + location);
        }
    }
    public void setChechInCheckOut(String checkin, String checkout) throws Exception {
        openCalendar();
        String checkInXpath = updateXpathValue(date, checkin);
        String checkOutXpath = updateXpathValue(date, checkout);

        while (true) {
            if (elementExistsByXpath(checkInXpath)) {
                driver.findElement(By.xpath(checkInXpath)).click();
                break;
            } else {
                clickCalendarNext();
            }
        }
        while (true) {
            if (elementExistsByXpath(checkOutXpath)) {
                if ((driver.findElement(By.xpath(checkOutXpath))).isDisplayed()) {
                    driver.findElement(By.xpath(checkOutXpath)).click();
                    break;
                }
                else {
                    clickCalendarNext();
                }
            }
            else {
                clickCalendarNext();
            }
        }
    }
    public void openCalendar() throws Exception {
        if (calendar.size() == 1){
            if(!calendar.get(0).isDisplayed()){
                click(dateInput, "Check In - Check Out Calendar");
                Thread.sleep(1000);
            }
        } else {
            if(!calendar.get(1).isDisplayed()){
                click(dateInput, "Check In - Check Out Calendar");
                Thread.sleep(1000);
            }
        }
    }

    public void clickCalendarNext() throws Exception {
        click(nextArrowCalendar, "Calendar Next Arrow");
    }
    public void clickFlexCalendarNext() throws Exception {
        click(nextArrowFlexCalendar, "Flex Calendar Next Arrow");
    }
    public void clickFlexCalendarPrevious() throws Exception {
        click(previousArrowFlexCalendar, "Flex Calendar Previous Arrow");
    }
    public void addGuests(String adults, String children, String infants, String pets) throws Exception {
        click(guestsInput,"Click guests input field");
        Thread.sleep(2000);
        addAdults(adults);
        addChildren(children);
        addInfants(infants);
        addPets(pets);
    }
    public void addAdults(String adults) throws Exception {
        for (int i = 0; i < Integer.parseInt(adults); i++) {
            click(adultsAdd, "Click + Adults");
        }
    }
    public void addChildren(String children) throws Exception {
        for (int i = 0; i < Integer.parseInt(children); i++) {
            click(childrenAdd, "Click + Children");
        }
    }
    public void addInfants(String infants) throws Exception {
        for (int i = 0; i < Integer.parseInt(infants); i++) {
            click(infantsAdd, "Click + Infants");
        }
    }
    public void addPets(String pets) throws Exception {
        for (int i = 0; i < Integer.parseInt(pets); i++) {
            click(petsAdd, "Click + Pets");
        }
    }
    public void selectFlexibleDates(String dates,String month) throws Exception {
        openCalendar();
        click(flexDates);
        dates=dates.toLowerCase();
        switch(dates){
            case "weekend":{ click(driver.findElement(By.cssSelector(updateXpathValue(flexWeekEnd, dates)))); } break;
            case "week":{ click(driver.findElement(By.cssSelector(updateXpathValue(flexWeek, dates)))); } break;
            case "month":{ click(driver.findElement(By.cssSelector(updateXpathValue(flexMonth, dates)))); } break;
            default: throw new Exception("Option "+dates+" for flexible date is not supported!");
        }
        while (true) {
            if (elementExistsByXpath(updateXpathValue(flexMonthSelect, month.toLowerCase()))) {
                if ((driver.findElement(By.xpath(updateXpathValue(flexMonthSelect, month.toLowerCase())))).isDisplayed()) {
                    driver.findElement(By.xpath(updateXpathValue(flexMonthSelect, month.toLowerCase()))).click();
                    break;
                } else {

                    clickFlexCalendarNext();
                }
            } else {
                clickFlexCalendarNext();
            }
        }
    }
    public void search() throws Exception {
        click(searchButton,"Click search");
        Thread.sleep(5000);
        String url=driver.getCurrentUrl();
        String res=(driver.findElement(By.xpath("//div[@data-testid='little-search']//button[1]//div"))).getText();
        res=res.replace(" ","-");
        Assert.assertTrue(url.contains(res),"Verify that url for destination contains: "+res);
    }
}