package API_Utils;

import API_Models.Defect.Defect;

import java.util.ArrayList;

public class DefectFactory {
    public static Defect getFirstDefectInfo() {
        return Defect.builder()
                .id(Integer.parseInt("1"))
                .title("Author search not implemented in search window")
                .actual_result("### Steps to reproduce:\n\n1. Enter the author's name in the search box;\n2. Click on the search button.\n\n### Expected result:\n\n1. Opens a catalog with books by this author.\n\n### Actual Result:\n\n1. The message appears 'Nothing is found :('.")
                .status("open")
                .milestone_id(null)
                .project_id(Integer.parseInt("190277"))
                .severity("major")
                .member_id(Integer.parseInt("1"))
                .attachments(new ArrayList<>())
                .custom_fields(new ArrayList<>())
                .external_data("{}")
                .resolved_at(null)
                .created("2022-06-28 14:47:09")
                .updated("2022-09-05 10:44:06")
                .created_at("2022-06-28T14:47:09+00:00")
                .updated_at("2022-09-05T10:44:06+00:00")
                .tags(new ArrayList<>())
                .build();
    }
}
