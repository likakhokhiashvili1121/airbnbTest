package tests.home.menuOptions;


import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import pages.Pages;
import tests.Search.hotels.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class HotelsTest extends BaseTest {

    @Test
    public void validateMenuOptionHotels() {
        log.info("Step 1: Validate the menu option: Hotels");
        assertThat(Pages.returnHomePage(getDriver()).getTextOptionHotels()).isEqualTo("Hoteles");
        log.info("Step 2: Click on the option Hotels");
        Pages.returnHomePage(getDriver()).onClickOptionHotels();
        log.info("Step 3: Validate the text in the text field of search in hotels");
        String textHotels = Pages.returnHomePage(getDriver()).getTitleSearch(getDriver());
        assertThat(textHotels).isEqualTo("");
    }
}
