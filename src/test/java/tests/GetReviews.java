package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ApartmentPage;
import steps.BaseSteps;

public class GetReviews extends BaseSteps {
    @BeforeMethod
    public void setup() throws Exception {
        init("CHROME");
        gotoAirbnb("AIRBNB");
    }
    @AfterMethod
    @Parameters({"quit"})
    public void tearDown(String quit){
        if(quit.equalsIgnoreCase("yes")) {
            quit();
        }
    }
    @Test(enabled=true)
    public void getReviews() throws InterruptedException {
        ApartmentPage apartment=new ApartmentPage(driver);
        String [] rates=apartment.apartmentReviews();
        if(rates.length>0) {
            Assert.assertTrue((rates[1].trim()).contains("reviews"));
        }
    }
}