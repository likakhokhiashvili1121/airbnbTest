package steps;

import io.qameta.allure.*;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AnywhereStaysPage;
import steps.BaseSteps;

public class AnywhereSteps extends BaseSteps {
    String browser;
    String quit;
    String env;

    @BeforeClass
    @Parameters({"browser", "quit", "env"})
    public void setup(String browser, String quit, String env) throws Exception {
        this.browser = browser;
        this.quit = quit;
        this.env = env;
        init(this.browser);
    }

    @AfterClass
    public void tearDown() {
        if (quit.equalsIgnoreCase("quit")) {
            quit();
        }
    }

    @Test
    @Description("Navigate to Airbnb website")
    public void userNavigateToAirbnbWebsite() throws Exception {
        gotoAirbnb(env);
    }

    @Test
    @Parameters({"region", "location"})
    @Description("Select region or type a location")
    public void userSelectsRegionOrTypesALocation(String region, String location) throws Exception {
        new AnywhereStaysPage(driver).setRegionLocation(region, location);
    }

    @Test
    @Parameters({"checkin", "checkout"})
    @Description("Select check-in and check-out dates")
    public void userSelectsCheckInDateAndCheckOutDate(String checkin, String checkout) throws Exception {
        new AnywhereStaysPage(driver).setChechInCheckOut(checkin, checkout);
    }

    @Test
    @Parameters({"adults", "children", "infants", "pets"})
    @Description("Add guests - adults, children, infants, and pets")
    public void userAddsGuestsAdultsChildInfantsAndPets(String adults, String children, String infants, String pets) throws Exception {
        new AnywhereStaysPage(driver).addGuests(adults, children, infants, pets);
    }

    @Test
    @Description("Click search button")
    public void userClicksSearchButton() throws Exception {
        new AnywhereStaysPage(driver).search();
    }

    @Test
    @Parameters({"dates", "month"})
    @Description("Select flexible dates option and stays option")
    public void userSelectsFlexibleDatesOptionAndStaysOptionAndMonth(String dates, String month) throws Exception {
        new AnywhereStaysPage(driver).selectFlexibleDates(dates, month);
    }
}
