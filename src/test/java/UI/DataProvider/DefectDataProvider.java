package UI.DataProvider;

import UI.Utils.DefectFactory;
import org.testng.annotations.DataProvider;

public class DefectDataProvider {

    @DataProvider(name = "defectDataProvider")
    public static Object[][] testData() {
        return new Object[][]{{DefectFactory.getFullInfoDefect()}};
    }
}
