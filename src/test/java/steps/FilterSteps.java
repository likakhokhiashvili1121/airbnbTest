package steps;

import io.qameta.allure.Step;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.FilterPage;
import steps.BaseSteps;

public class FilterSteps extends BaseSteps {
    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        init(browser);
    }

    @AfterMethod
    public void tearDown() {
        if (quit.equalsIgnoreCase("quit")) {
            quit();
        }
    }

    @Step("User goes to airbnb.com website and clicks filter button")
    @BeforeMethod
    public void userGoesToAirbnbComWebsiteAndClicksFilterButton() throws Exception {
        gotoAirbnb(env);
        new FilterPage(driver).openFilter();
    }

    @Step("User specifies min price {minPrice} and max price {maxPrice}")
    @BeforeMethod
    public void userSpecifiesMinPriceAndMaxPrice(String minPrice, String maxPrice) throws InterruptedException {
        new FilterPage(driver).setPrice(minPrice, maxPrice);
    }

    @Step("User specifies the type {placeType} of the place")
    @BeforeMethod
    public void userSpecifiesTheTypeOfThePlace(String placeType) throws Exception {
        new FilterPage(driver).setPlaceType(placeType);
    }

    @Step("User specifies number of rooms {rooms}, number of beds {beds}, and number of bathrooms {baths}")
    @BeforeMethod
    public void userSpecifiesNumberOfRoomsNumberOfBedsAndNumberOfBathrooms(String rooms, String beds, String baths) throws Exception {
        new FilterPage(driver).setRoomsBedsBaths(rooms, beds, baths);
    }

    @Step("User selects property type {propertyType}")
    @BeforeMethod
    public void userSelectsPropertyType(String propertyType) throws Exception {
        new FilterPage(driver).setPropertyType(propertyType);
    }

    @Step("User selects amenities: essentials {essentials}, features {features}, location {location}, and safety {safety}")
    @BeforeMethod
    public void userSelectsAmenitiesEssentialsFeaturesLocationAndSafety(String essentials, String features, String location, String safety) throws Exception {
        new FilterPage(driver).setAmenities(essentials, features, location, safety);
    }

    @Step("User selects booking options: instant book {instantBook} and self-check {selfCheck}")
    @BeforeMethod
    public void userSelectsBookingOptionsInstantBookAndSelfCheck(String instantBook, String selfCheckk) throws Exception {
        new FilterPage(driver).setBookingOptions(instantBook, selfCheckk);
    }

    @Step("User selects accessibility features: guest entrance and parking {entranceParking}, bedroom {accessBedroom}, bathroom {accessBaths}, and adaptive equipment {addaptiveEquipment}")
    @BeforeMethod
    public void userSelectsAccessibilityFeaturesGuestEntranceAndParkingBedroomBathroomAndAdaptiveEquipment(String entranceParking, String accessBedroom, String accessBaths, String addaptiveEquipment) throws Exception {
        new FilterPage(driver).setAccessibility(entranceParking, accessBedroom, accessBaths, addaptiveEquipment);
    }

    @Step("User selects top tier stays superhost {superHost} and airbnb plus {plus}")
    @BeforeMethod
    public void userSelectsTopTierStaysSuperhostAndAirbnbPlus(String superHost, String plus) throws Exception {
        new FilterPage(driver).setTopTierStays(superHost, plus);
    }

    @Step("User selects host language {lang}")
    @BeforeMethod
    public void userSelectsHostLanguage(String lang) throws Exception {
        new FilterPage(driver).setHostLanguage(lang);
    }

    @Step("User clicks show homes button to search apartments for specified data")
    @BeforeMethod
    public void userClicksShowHomesButtonToSearchApartmentsForSpecifiedData() throws Exception {
        new FilterPage(driver).filterSearch();
    }
}
