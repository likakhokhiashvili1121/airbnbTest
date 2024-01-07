package tests.home.menuOptions;


import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import pages.Pages;
import tests.Search.hotels.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SearchAllTest extends BaseTest {

    @Test
    public void validateMenuOptionSearchAll(){
        log.info("Step 1: Validate the menu option: Search All");
        assertThat(Pages.returnHomePage(getDriver()).getTextOptionSearchAll()).isEqualTo("");
        log.info("Step 2: Click on the option Search All");
        Pages.returnHomePage(getDriver()).onClickOptionSearchAll();
        log.info("Step 3: Validate the text in the text field of search in Search All");
        String textSearchAll = Pages.returnHomePage(getDriver()).getTitleSearch(getDriver());
        assertThat(textSearchAll).isEqualTo("");
    }
}
