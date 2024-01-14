package runners;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class FilterRunner {

    @Test(dataProvider = "scenarios", parallel = true)
    public void testScenario(String scenario) {
        runScenario(scenario);
    }

    @Step("Run Scenario: {0}")
    public void runScenario(String scenario) {
        attachScreenshot("Screenshot on scenario start");
        attachScreenshot("Screenshot on scenario end");
    }

    @Attachment(value = "{attachmentName}", type = "image/png")
    public byte[] attachScreenshot(String attachmentName) {
        return null;
    }

    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return new Object[][]{
                {"Scenario9"},
                {"Scenario10"}
        };
    }
}
