package tests.home.menuOptions;


import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import pages.Pages;
import tests.Search.hotels.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ThinksForDoTest extends BaseTest {

    @Test
    public void validateMenuOptionThinksForDo(){
        log.info("Step 1: Validate the menu option: Thinks for do");
        assertThat(Pages.returnHomePage(getDriver()).getTextOptionThinksForDo()).isEqualTo("");
        log.info("Step 2: Click on the option Thinks for do");
        Pages.returnHomePage(getDriver()).onClickOptionThinksForDo();
        log.info("Step 3: Validate the text in the text field of search in thinks for do");
        String textThinksForDo = Pages.returnHomePage(getDriver()).getTitleSearch(getDriver());
        assertThat(textThinksForDo).isEqualTo("");
    }
}
