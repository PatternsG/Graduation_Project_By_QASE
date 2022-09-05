package Tests.API;

import API_Adaptors.DefectAdaptor;
import API_Models.Defect.Defect;
import API_Models.ErrorField;
import API_Models.PositiveResponse;
import API_Utils.DefectFactory;
import API_Utils.PropertyReader;
import com.google.gson.Gson;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class DefectTests {
    private static final String PROJECT_CODE = "SHARELANE";
    private static final Gson GSON = new Gson();
    private static final DefectAdaptor defectAdaptor = new DefectAdaptor();


    @Test
    public void createDefectPositiveTest() {
        Defect defect = Defect.builder()
                .title(PropertyReader.getProperty("Test defect"))
                .actual_result(PropertyReader.getProperty("Test Error"))
                .severity(PropertyReader.getProperty("0"))
                .build();

        PositiveResponse<Defect> expectedResponse = PositiveResponse
                .<Defect>builder()
                .result(Defect.builder()
                        .build())
                .build();

        PositiveResponse<Defect> actualResponse =
                defectAdaptor.createDefect(PROJECT_CODE, GSON.toJson(defect), HttpStatus.SC_OK);
        actualResponse.getResult().setId(null); //don't want to validate returned id

        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void createDefectNegativeTest() {
        Defect defect = Defect.builder()
                .title("")
                .actual_result("")
                .severity("")
                .build();

        PositiveResponse<Defect> expectedResponse = PositiveResponse
                .<Defect>builder()
                .status(false)
                .errorMessage("Data is invalid.")
                .errorFields(Arrays.asList(
                        ErrorField.builder()
                                .field("title")
                                .error("The title field is required.")
                                .build(),
                        ErrorField.builder()
                                .field("actual_result")
                                .error("The actual result field is required.")
                                .build(),
                        ErrorField.builder()
                                .field("severity")
                                .error("The severity field is required.")
                                .build()))
                .build();

        PositiveResponse<Defect> actualResponse =
                defectAdaptor.createDefect(PROJECT_CODE, GSON.toJson(defect), HttpStatus.SC_BAD_REQUEST);

        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void getDefectByProjectCodeAndDefectIdPositiveTest() {
        PositiveResponse<Defect> expectedResponse = PositiveResponse.<Defect>builder()
                .result(DefectFactory.getFirstDefectInfo())
                .build();
        PositiveResponse<Defect> actualResponse = defectAdaptor.getDefectByProjectCodeAndDefectId(
                PROJECT_CODE, Integer.parseInt("1"), HttpStatus.SC_OK);
        Assert.assertEquals(actualResponse, expectedResponse);
    }
}
