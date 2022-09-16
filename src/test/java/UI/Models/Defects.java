package UI.Models;

import UI.Enums.Defects.Assignee;
import UI.Enums.TestCase.Severity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Defects {

    private String defectTitle;
    private String actualResult;
    private Severity severity;
    private Assignee assignee;
}
