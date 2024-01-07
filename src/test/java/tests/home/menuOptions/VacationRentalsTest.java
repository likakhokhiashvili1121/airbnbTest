package tests.home.menuOptions;


import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import pages.Pages;
import tests.Search.hotels.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class VacationRentalsTest extends BaseTest {

    @Test
    public void validateMenuOptionVacationRentals(){
        log.info("Step 1: Validate the menu option is: Vacation Rentals");
        assertThat(Pages.returnHomePage(getDriver()).getTextOptionVacationRentals()).isEqualTo("");
        log.info("Step 2: Click on the option Vacation Rentals");
        Pages.returnHomePage(getDriver()).onClickOptionVacationRentals();
        log.info("Step 3: Validate the text in the text field of search Vacation Rentals");
        String textVacationRentals = Pages.returnHomePage(getDriver()).getTitleSearch(getDriver());
        assertThat(textVacationRentals).isEqualTo("");
    }
}

