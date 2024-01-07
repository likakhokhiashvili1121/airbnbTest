package tests.home.menuOptions;


import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import pages.Pages;
import tests.Search.hotels.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class RestaurantsTest extends BaseTest {

    @Test
    public void validateMenuOptionRestaurant(){
        log.info("Step 1: Validate the menu option is: Restaurants");
        assertThat(Pages.returnHomePage(getDriver()).getTextOptionRestaurants()).isEqualTo("Restaurantes");
        log.info("Step 2: Click on the option Restaurants");
        Pages.returnHomePage(getDriver()).onClickOptionRestaurants();
        log.info("Step 3: Validate the text in the text field of search Restaurants");
        String textRestaurants = Pages.returnHomePage(getDriver()).getTitleSearch(getDriver());
        assertThat(textRestaurants).isEqualTo("");
    }
}
