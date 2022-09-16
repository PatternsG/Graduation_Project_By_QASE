package UI.DataProvider;

import UI.Utils.SuiteFactory;
import org.testng.annotations.DataProvider;

public class SuiteDataProvider {

    @DataProvider(name = "suiteDataProvider")
    public static Object[][] testData() {
        return new Object[][]{{SuiteFactory.getFullInfoSuite()}};
    }
}

