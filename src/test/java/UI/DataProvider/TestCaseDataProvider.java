package UI.DataProvider;

import UI.Utils.TestCaseFactory;
import org.testng.annotations.DataProvider;

public class TestCaseDataProvider {
    @DataProvider(name = "testCaseDataProvider")
    public static Object[][] testData() {
        return new Object[][]{{TestCaseFactory.getFullInfoTestCase()}};
    }
}


