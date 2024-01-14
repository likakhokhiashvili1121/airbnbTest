package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AnywhereStaysPage;
import pages.HomePage;
import steps.BaseSteps;
import org.testng.annotations.BeforeMethod;
import java.util.List;

public class CategoryCarousel extends BaseSteps {
    @BeforeMethod
    public void setup() throws Exception {
        init("CHROME");
        gotoAirbnb("AIRBNB");
    }

    @AfterMethod
    @Parameters({"quit"})
    public void tearDown(String quit) {
        if (quit.equalsIgnoreCase("yes")) {
            quit();
        }
    }

    @Test(enabled = true)
    @Parameters({"category", "checkword"})
    public void categoryCarousel(String category, String checkword) throws Exception {
        HomePage homePage = new HomePage(driver);
        String catTitle = homePage.clickCategory(category);
        checkword.trim();
        if(!(catTitle.isEmpty())) {
            Assert.assertTrue(catTitle.contains(checkword), "Check if results are from correct category.");
        }
    }
}