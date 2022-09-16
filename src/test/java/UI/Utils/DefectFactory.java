package UI.Utils;

import UI.Enums.Defects.Assignee;
import UI.Enums.TestCase.Severity;
import UI.Models.Defects;

public class DefectFactory {

    public static Defects getFullInfoDefect() {
        return Defects.builder()
                .defectTitle("Error calculating discount in shopping cart")
                .actualResult("The percentage of the discount must be subtracted from the total price.")
                .severity(Severity.CRITICAL)
                .assignee(Assignee.KOVALEVSIY_IVAN)
                .build();
    }
}
