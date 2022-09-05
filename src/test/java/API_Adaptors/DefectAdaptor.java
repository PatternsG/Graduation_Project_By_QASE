package API_Adaptors;

import API_Models.AllEntitiesResult;
import API_Models.Defect.Defect;
import API_Models.PositiveResponse;
import com.google.gson.reflect.TypeToken;

public class DefectAdaptor extends BaseAdaptor {
    private final static String ENDPOINT = "defect";

    public PositiveResponse<AllEntitiesResult<Defect>> getAllDefects(String projectCode,
                                                                     int limit, int statusCode) {
        return gson.fromJson(
                get(ENDPOINT + "/" + projectCode + "?limit=" + limit,
                        statusCode),
                new TypeToken<PositiveResponse<AllEntitiesResult<Defect>>>() {
                }.getType());
    }

    public PositiveResponse<Defect> createDefect(String projectCode, String requestBody, int statusCode) {
        return gson.fromJson(post(ENDPOINT + "/" + projectCode, statusCode, requestBody),
                new TypeToken<PositiveResponse<Defect>>() {
                }.getType());
    }

    public PositiveResponse<Defect> getDefectByProjectCodeAndDefectId(String projectCode,
                                                                      int defectId, int statusCode) {
        return gson.fromJson(
                get(ENDPOINT + "/" + projectCode + "/" + defectId, statusCode),
                new TypeToken<PositiveResponse<Defect>>() {
                }.getType());
    }

    public PositiveResponse<Defect> deleteDefectByProjectCodeAndDefectId(String projectCode, int defectId,
                                                                         int statusCode) {
        return gson.fromJson(
                delete(ENDPOINT + "/" + projectCode + "/" + defectId, statusCode),
                new TypeToken<PositiveResponse<Defect>>() {
                }.getType());
    }

    public PositiveResponse<Defect> updateDefectByProjectCodeAndDefectId(String projectCode, int defectId,
                                                                         String requestBody, int statusCode) {
        return gson.fromJson(
                patch(ENDPOINT + "/" + projectCode + "/" + defectId, requestBody, statusCode),
                new TypeToken<PositiveResponse<Defect>>() {
                }.getType());
    }
}
