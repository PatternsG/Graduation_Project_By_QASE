package API_Adaptors;

import com.google.gson.reflect.TypeToken;
import API_Models.AllEntitiesResult;
import API_Models.PositiveResponse;
import API_Models.Project.Project;

public class ProjectAdaptor extends BaseAdaptor {
    private final static String ENDPOINT = "project";

    public PositiveResponse<AllEntitiesResult<Project>> getAllProjects(int statusCode, int limit) {
        return gson.fromJson(get(ENDPOINT + "?limit=" + limit, statusCode),
                new TypeToken<PositiveResponse<AllEntitiesResult<Project>>>(){}.getType());
    }

    public PositiveResponse<Project> createProject(int statusCode, String requestBody) {
        return gson.fromJson(post(ENDPOINT, statusCode, requestBody),
            new TypeToken<PositiveResponse<Project>>(){}.getType());
    }
    public PositiveResponse<Project> getProjectByCode(int statusCode, String projectCode) {
        return gson.fromJson(
                get(ENDPOINT + "/" + projectCode, statusCode),
                new TypeToken<PositiveResponse<Project>>(){}.getType());
    }
    public PositiveResponse<Project> deleteProjectByCode(int statusCode, String projectCode) {
        return gson.fromJson(delete(ENDPOINT + "/" + projectCode, statusCode),
            new TypeToken<PositiveResponse<Project>>(){}.getType());
    }

}
